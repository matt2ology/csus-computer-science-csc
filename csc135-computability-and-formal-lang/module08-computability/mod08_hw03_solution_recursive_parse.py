#! /usr/bin/python3

import logging

FORMAT = '[%(asctime)s]-[%(funcName)s]-[%(levelname)s] - %(message)s'
logging.basicConfig(
    level=logging.INFO,
    format=FORMAT
)


class node:
    def __init__(self, data):
        self.data = data
        self.children = None

    def add_child(self, child):
        if self.children == None:
            self.children = []
        self.children.append(child)

    def is_leaf(self):
        return self.children == None


class scanner:
    # toks[i] must evaluate to the i-th token in the token stream.
    # Assumes toks does not change during parsing
    def __init__(self, toks):
        self._toks = toks
        self._i = 0

    # If no more tokens exist or current token isn't s, raise exception.
    # Otherwise pass over the current one and move to the next.
    def match(self, s):
        if (self._i < len(self._toks)) and (self._toks[self._i] == s):
            self._i += 1
        else:
            raise Exception

    # If any tokens remain return the current one. If no more, return None.
    def next(self):
        if self._i < len(self._toks):
            return self._toks[self._i]
        else:
            return None


# S' → S$
# S → BA
# A → +BA | -BA | λ
# B → DC
# C → *DC | /DC | λ
# D → a | (S)


def parseD(toks):
    """
    D → a | (S)
    """
    tok = toks.next()
    # Create node to be returned and lable it "D"
    rval = node('D')
    logging.info("NODE: D TOK: {}".format(tok))
    if (tok == 'a'):
        toks.match('a')
        rval.add_child(node('a'))
    elif tok == '(':
        toks.match('(')
        rval.add_child(node('('))
        rval.add_child(parseS(toks))
        toks.match(')')
        rval.add_child(node(')'))
    else:
        raise Exception
    return rval


def parseC(toks):
    """
    C → *DC | /DC | λ
    """
    tok = toks.next()
    # Create node to be returned and lable it "C"
    rval = node('C')
    logging.info("NODE: C TOK: {}".format(tok))
    if tok in ('*', '/'):
        # Match tok and add first child, a leaf node labled tok
        toks.match(tok)
        rval.add_child(node(tok))
        rval.add_child(parseD(toks))
        rval.add_child(parseC(toks))
    elif (tok in ('+', '-', ')', 'a') or tok == None):
        # Make child be a leafe node labled "" (empty string)
        rval.add_child(node(''))
    else:
        # Unexpected token, so throw an exception
        raise Exception
    return rval


def parseB(toks):
    """
    B → DC
    """
    tok = toks.next()
    # Create node to be returned and lable it "B"
    rval = node('B')
    logging.info("NODE: B TOK: {}".format(tok))
    if tok in ('a', '('):
        rval.add_child(parseD(toks))
        rval.add_child(parseC(toks))
    else:
        # Unexpected token, so throw an exception
        raise Exception
    return rval


def parseA(toks):
    """
    A → +BA | -BA | λ
    """
    tok = toks.next()
    # Create node to be returned and lable it "A"
    rval = node('A')
    logging.info("NODE: A TOK: {}".format(tok))
    if tok in ('+', '-'):
        # Match tok and add first child, a leaf node labled tok
        toks.match(tok)
        rval.add_child(node(tok))
        # parseA and have resulting subtree be our second child
        rval.add_child(parseB(toks))
        rval.add_child(parseA(toks))
    elif tok in ('a', ')') or (tok == None):
        # A is nullable; also, both ')' and '$' indicate A -> lambda
        # Make child be a leafe node labled "" (empty string)
        rval.add_child(node(''))
    else:
        # Unexpected token, so throw an exception
        raise Exception
    return rval


def parseS(toks):
    """
    S → BA
    """
    tok = toks.next()
    # Create node to be returned and lable it "S"
    return_value = node('S')
    logging.info("NODE: S TOK: {}".format(tok))
    if tok in ('a', '('):
        # parseS and have resulting subtree be our first child
        return_value.add_child(parseB(toks))
        # parseS and have resulting subtree be our second child
        return_value.add_child(parseA(toks))
    else:
        # Unexpected token, so throw an exception
        raise Exception
    return return_value


def parse(input):
    toks = scanner(input)
    rval = parseS(toks)
    if toks.next() != None:
        raise Exception
    return rval


def num_leaves(tree_node):
    """
    Takes a tree as input and returns the number of leaves in the tree
    (including ones labeled with the empty string)
    @param: tree as input
    @return: the number of leaves in the tree
    """
    # Walks a tree rooted at tree_node and returns how many leaf nodes there are in it
    number_of_leaves = 0
    if tree_node is not None:
        for childNode in tree_node:
            number_of_leaves += 1
            num_leaves(childNode)
    return number_of_leaves


# THE CORRECT OUTPUT OF THE TEST CASE
# <<<<a>><<λ>>><<λ>>>
# <<<<(><<<<a>><<λ>>><<λ>>><)>><<λ>>><<λ>>>
# <<<<(><<<<(><<<<a>><<λ>>><<λ>>><)>><<λ>>><<λ>>><)>><<λ>>><<λ>>>
# <<<<a>><<λ>>><<+><<<a>><<λ>>><<λ>>>>
# <<<<a>><<*><<a>><<λ>>>><<λ>>>
# <<<<(><<<<(><<<<a>><<λ>>><<λ>>><)>><</><<(><<<<a>><<λ>>><<λ>>><)>><<λ>>>><<-><<<(><<<<a>><<λ>>><<λ>>><)>><<λ>>><<λ>>>><)>><<λ>>><<λ>>>
# <<<<(><<<<(><<<<a>><<λ>>><<λ>>><)>><</><<(><<<<a>><<λ>>><<λ>>><)>><<λ>>>><<-><<<(><<<<a>><<λ>>><<λ>>><)>><<λ>>><<λ>>>><)>><<*><<(><<<<(><<<<a>><<λ>>><<λ>>><)>><</><<(><<<<a>><<λ>>><<λ>>><)>><<λ>>>><<-><<<(><<<<a>><<λ>>><<λ>>><)>><<λ>>><<λ>>>><)>><<λ>>>><<λ>>>
# <<<<a>><<λ>>><<+><<<a>><<*><<a>><<λ>>>><<-><<<a>><</><<a>><<λ>>>><<λ>>>>>
# <<<<a>><</><<a>><<λ>>>><<-><<<a>><<*><<a>><<λ>>>><<+><<<a>><<λ>>><<λ>>>>>
# <<<<(><<<<a>><<λ>>><<+><<<a>><<*><<a>><<λ>>>><<-><<<a>><</><<a>><<λ>>>><<λ>>>>><)>><<λ>>><<λ>>>
# <<<<(><<<<a>><</><<a>><<λ>>>><<-><<<a>><<*><<a>><<λ>>>><<+><<<a>><<λ>>><<λ>>>>><)>><<λ>>><<λ>>>
# <<<<(><<<<a>><<λ>>><<+><<<(><<<<a>><<*><<a>><<*><<a>><<λ>>>>><<λ>>><)>><<λ>>><<+><<<a>><<λ>>><<+><<<a>><<λ>>><<λ>>>>>><)>><<λ>>><<λ>>>
# <<<<(><<<<a>><<*><<(><<<<a>><<λ>>><<+><<<a>><<λ>>><<+><<<a>><<λ>>><<λ>>>>><)>><<*><<a>><<*><<a>><<λ>>>>>><<λ>>><)>><<λ>>><<λ>>>

try:
    # THE CORRECT OUTPUT OF THE TEST CASE
    # parse ("a")
    # parse("(a)")
    # NODE: S TOK: (
    # NODE: B TOK: (
    # NODE: D TOK: (
    # NODE: S TOK: a
    # NODE: B TOK: a
    # NODE: D TOK: a
    # NODE: C TOK: )
    # NODE: A TOK: )
    # NODE: C TOK: None
    # NODE: A TOK: None
    # parse("((a))")
    # parse("a+a")
    # parse ("a*a")
    # parse ("((a)/(a)-(a))")
    parse("((a)/(a)-(a))*((a)/(a)-(a))")
    # parse ("a+a*a-a/a")
    # parse ("a/a-a*a+a")
    # parse ("(a+a*a-a/a)")
    # parse ("(a/a-a*a+a)")
    # parse ("(a+(a*a*a)+a+a)")
    # parse ("(a*(a+a+a)*a*a)")
except:
    print("Reject")
else:
    print("Accept")

# TOP: S TOK: ( = NODE: S TOK: (
# TOP: B TOK: ( = NODE: B TOK: (
# TOP: D TOK: ( = NODE: D TOK: (
# TOP: S TOK: ( = NODE: S TOK: (
# TOP: B TOK: ( = NODE: B TOK: (
# TOP: D TOK: ( = NODE: D TOK: (
# TOP: S TOK: a = NODE: S TOK: a
# TOP: B TOK: a = NODE: B TOK: a
# TOP: D TOK: a = NODE: D TOK: a
# TOP: C TOK: ) = NODE: C TOK: )
# TOP: A TOK: ) = NODE: A TOK: )
# TOP: C TOK: / = NODE: C TOK: /
# TOP: D TOK: ( = NODE: D TOK: (
# TOP: S TOK: a = NODE: S TOK: a
# TOP: B TOK: a = NODE: B TOK: a
# TOP: D TOK: a = NODE: D TOK: a
# TOP: C TOK: ) = NODE: C TOK: )
# TOP: A TOK: ) = NODE: A TOK: )
# TOP: C TOK: - = NODE: C TOK: -
# TOP: A TOK: -
# TOP: B TOK: (
# TOP: D TOK: (
# TOP: S TOK: a
# TOP: B TOK: a
# TOP: D TOK: a
# TOP: C TOK: )
# TOP: A TOK: )
# TOP: C TOK: )
# TOP: A TOK: )
# TOP: C TOK: *
# TOP: D TOK: (
# TOP: S TOK: (
# TOP: B TOK: (
# TOP: D TOK: (
# TOP: S TOK: a
# TOP: B TOK: a
# TOP: D TOK: a
# TOP: C TOK: )
# TOP: A TOK: )
# TOP: C TOK: /
# TOP: D TOK: (
# TOP: S TOK: a
# TOP: B TOK: a
# TOP: D TOK: a
# TOP: C TOK: )
# TOP: A TOK: )
# TOP: C TOK: -
# TOP: A TOK: -
# TOP: B TOK: (
# TOP: D TOK: (
# TOP: S TOK: a
# TOP: B TOK: a
# TOP: D TOK: a
# TOP: C TOK: )
# TOP: A TOK: )
# TOP: C TOK: )
# TOP: A TOK: )
# TOP: C TOK: None
# TOP: A TOK: None

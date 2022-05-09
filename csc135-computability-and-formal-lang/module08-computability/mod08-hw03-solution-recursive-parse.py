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

def parseD(toks):
    pass

def parseC(toks):
    pass

def parseB(toks):
    pass

def parseA(toks):
    pass

def parseS(toks):
    pass

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
    if tree_node is None:
        for childNode in tree_node:
            number_of_leaves += 1
            num_leaves(childNode)
    return number_of_leaves

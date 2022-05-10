#! /usr/bin/python3

import logging

FORMAT = '[%(asctime)s]-[%(funcName)s]-[%(levelname)s] - %(message)s'
logging.basicConfig(
    level=logging.INFO,
    format=FORMAT
)


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


# Input can be any type where len(input) is defined and input[i] yields a
# string (ie, string, list, etc). Raises Exception on a parse error.
def parse(input):
    """
    S' → S$
    S → BA
    A → +BA | -BA | λ
    B → DC
    C → *DC | /DC | λ
    D → a | (S)
    """
    toks = scanner(input)
    stack = ['S']
    while len(stack) > 0:
        top = stack.pop()
        tok = toks.next()
        if top in ('a', '+', '-', '*', '/', '(', ')'):
            toks.match(top)
        elif top == 'S' and (tok == 'a' or tok == '('):
            stack.append('A')
            stack.append('B')
            logging.info("TOP: {} TOK: {}".format(top, tok))
        elif top == 'A' and tok in ('+', '-'):
            stack.append('A')
            stack.append('B')
            stack.append(tok)
            logging.info("TOP: {} TOK: {}".format(top, tok))
        elif top == 'A' and (tok == ')' or tok == None):
            logging.info("TOP: {} TOK: {}".format(top, tok))
            pass
        elif top == 'B' and (tok == 'a' or tok == '('):
            stack.append('C')
            stack.append('D')
            logging.info("TOP: {} TOK: {}".format(top, tok))
        elif top == 'C' and tok in ('*', '/'):
            stack.append('C')
            stack.append('D')
            stack.append(tok)
            logging.info("TOP: {} TOK: {}".format(top, tok))
        elif top == 'C' and (tok in ('+', '-', ')') or tok == None):
            logging.info("TOP: {} TOK: {}".format(top, tok))
            pass
        elif top == 'D' and tok == 'a':
            stack.append('a')
            logging.info("TOP: {} TOK: {}".format(top, tok))
        elif top == 'D' and tok == '(':
            stack.append(')')
            stack.append('S')
            stack.append('(')
            logging.info("TOP: {} TOK: {}".format(top, tok))
        else:
            raise Exception    # Unrecognized top/tok combination
    if toks.next() != None:
        raise Exception


try:
    # THE CORRECT OUTPUT OF THE TEST CASE
    # parse("a")
    parse("(a)")
    # parse("((a))")
    # parse("a+a")
    # parse("a*a")
    # parse("((a)/(a)-(a))")
    # parse("((a)/(a)-(a))*((a)/(a)-(a))")
    # parse("a+a*a-a/a")
    # parse("a/a-a*a+a")
    # parse("(a+a*a-a/a)")
    # parse("(a/a-a*a+a)")
    # parse("(a+(a*a*a)+a+a)")
    # parse("(a*(a+a+a)*a*a)")
except:
    print("Reject")
else:
    print("Accept")

class scanner:
    # toks[i] must evaluate to the i-th token in the token stream.
    # Assumes toks does not change during parsing
    def __init__(self,toks):
        self._toks = toks
        self._i = 0
    
    # If no more tokens exist or current token isn't s, raise exception.
    # Otherwise pass over the current one and move to the next.
    def match(self,s):
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
    toks = scanner(input)
    stack = ['S']
    while len(stack) > 0:
        top = stack.pop()      # Always pop top of stack
        tok = toks.next()      # None if token stream empty
        if top in ('a', '+', '-', '*', '/', '(', ')'):  # try input/stack match
            toks.match(top)
        elif top == 'S' and tok in ('a', '('):
            stack.append('A')
            stack.append('B')
        elif top == 'A' and tok in ('+', '-'):
            stack.append('A')
            stack.append('B')
            stack.append(tok)
        elif top == 'A' and (tok == None or tok == ')'):
            pass
        elif top == 'B' and tok in ('a', '('):
            stack.append('C')
            stack.append('D')
        elif top == 'C' and tok in ('*', '/'):
            stack.append('C')
            stack.append('D')
            stack.append(tok)
        elif top == 'C' and (tok == None or tok in ('+', '-', ')')):
            pass
        elif top == 'D' and tok == 'a':
            stack.append('a')
        elif top == 'D' and tok == '(':
            stack.append(')')
            stack.append('S')
            stack.append('(')
        else:
            raise Exception    # Unrecognized top/tok combination
    if toks.next() != None:
        raise Exception

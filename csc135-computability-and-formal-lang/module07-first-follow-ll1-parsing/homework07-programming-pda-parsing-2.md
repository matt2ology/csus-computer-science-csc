# PDA parsing 2 - S22

## INSTRUCTIONS

This programming assignment is explained at <https://krovetz.net/135/module_cfl/prog2.html>

**Note**: I use Mimir as a submission site. It is not intended to do your testing for you. You should thoughly test your own code in addition to ensuring it passes the enclosed Mimir tests. I may add additional tests after the due date.

You analyzed the following context-free language as part of homework on Canvas. Use that analysis to write a PDA parser similar to the one found in <http://krovetz.net/135/module_cfl/parse_intro.html>

$S'\:\rightarrow\:$

$S\:\rightarrow\:BA$

$A\:\rightarrow\:+BA\:|\:-BA\:\lambda$

$B\:\rightarrow\:DC$

$C\:\rightarrow\:\ast DC\:|\:/DC\:|\:\lambda$

$D\:\rightarrow\:a\:|\:(S)$

The programming assignment is further explained at <https://krovetz.net/135/module_cfl/prog2.html>

## Starter Code

```python
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
        tok = toks.next()      # None indicates token stream empty
        if top in ('a', 'b', 'x'):     # Matching stack top to token
            toks.match(top)
        elif top == 'A' and tok == None: # next == $ 
            pass # "pass" is how you say do nothing in Python
        elif top == 'S' and tok == 'a':  # S -> aSa must be the next
            stack.append('a')            # production to follow here
            stack.append('S')
            stack.append('a')
        elif top == 'S' and tok == 'b':  # S -> bSb must be the next
            stack.append('b')            # production to follow here
            stack.append('S')
            stack.append('b')
        elif top == 'S' and tok == 'x':  # S -> x must be the next
            stack.append('x')            # production to follow here
        else:
            raise Exception    # Unrecognized top/tok combination
    if toks.next() != None:
        raise Exception

try:
    parse("aabxbaa")
except:
    print("Reject")
else:
    print("Accept")
```

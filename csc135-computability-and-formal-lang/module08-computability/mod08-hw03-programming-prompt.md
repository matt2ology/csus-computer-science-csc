# Recursive parse

- [Recursive parse](#recursive-parse)
  - [Homework Assignment](#homework-assignment)
  - [Starter Code](#starter-code)

Due: Sun May 15, 11:59pm.

You may collaborate with one or two other students on this homework if you wish, or work alone. Collaboration must be true collaboration however, which means that the work put into each problem should be roughly equal and all parties should come away understanding the solution. Here are some suggested ways of collaborating on the programming part.

- Pair programming. Two or three of you look at the same screen and only one of you operate the keyboard. The one at the keyboard is the "driver" and the other is the "navigator". The driver explains everything they are doing as they do it and the navigator asks questions and makes suggestions. If the navigator knows how to solve the problem and the driver does not, the navigator should not dictate solutions to the driver but instead should tutor the driver to help them understand. The driver and navigator should switch roles every 10-15 minutes. Problems solved this way can then be individually submitted.

- Code review. The members of the collaborative each try to solve the problem independently. They then take turns analyzing each other's code, asking questions trying to understand each other's algorithms and suggesting improvements. After the code reviews, each of you can then fix your code using what you learned from the reviews. Do not copy code. If the result of code review is that your code needs changes to be more like your partner's, do not copy it. Instead recreate your own variant without looking at your partner's.

The goal is to learn enough from one another so that you each can do similar problems independently in an exam situation.

If you want a collaborator but don't know people in the class, you can ask on Discord and/or use the group-finding post on Piazza.

## Homework Assignment

Recall that you wrote a PDA parser for the following grammar in an [earlier programming assignment](../module07-first-follow-ll1-parsing/mod07-reading06-pda-parse-lambda-productions.pdf) (<https://krovetz.net/135/module_cfl/prog2.html>)

$S'\:\rightarrow\:S\$$

$S\:\rightarrow\:BA$

$A\:\rightarrow+BA\:|\:-BA\:|\:\lambda$

$B\:\rightarrow\:DC$

$C\:\rightarrow\:\ast DC\:|\:/DC\:|\:\lambda$

$D\:\rightarrow\:a\:|\:(S)$

In this assignment you are to build and return a tree following the model given in the "Building a tree" and "Example: Bf" readings. Your code must use the recursive descent method seen in those readings.

Also write a num_leaves function that takes a tree as input and returns the number of leaves in the tree (including ones labeled with the empty string).

## Starter Code

Here is the code from the in-class demonstration. A page will soon appear on Mimir for you to submit your completed code.

```python
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

def parseD(toks):

def parseC(toks):

def parseB(toks):

def parseA(toks):

def parseS(toks):

def parse(input):
    toks = scanner(input)
    rval = parseS(toks)
    if toks.next() != None:
        raise Exception
    return rval
```

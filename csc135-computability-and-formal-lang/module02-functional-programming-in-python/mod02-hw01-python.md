# Python Homework II

You may collaborate with _one or two_ other students on this homework if you wish, or work alone. Collaboration must be true collaboration however, which means that the work put into each problem should be roughly equal and all parties should come away understanding the solution. Here are some suggested ways of collaborating.

- Pair programming. Two or three of you look at the same screen and only one of you operate the keyboard. The one at the keyboard is the "driver" and the other is the "navigator". The driver explains everything they are doing as they do it and the navigator asks questions and makes suggestions. If the navigator knows how to solve the problem and the driver does not, the navigator should not dictate solutions to the driver but instead should tutor the driver to help them understand. The driver and navigator should switch roles every 10-15 minutes. Problems solved this way can then be individually submitted.
- Code review. The members of the collaborative each try to solve the problem independently. They then take turns analyzing each other's code, asking questions trying to understand each other's algorithms and suggesting improvements. After the code reviews, each of you can then fix your code using what you learned from the reviews. Do not copy code. If the result of code review is that your code needs changes to be more like your partner's, do not copy it. Instead recreate your own variant without looking at your partner's.

The goal is to learn enough from one another so that you each can write similar code independently in an exam situation.

If you want a collaborator but don't know people in the class, you can ask on Discord and/or use the group-finding post on Piazza.

## Homework Exercises

Completion of these tasks by Midnight February 20 is worth approximately 1-2% of your course grade. No late homework will be accepted.

1. Do the following two exercises from Code Step By Step.

    [https://www.codestepbystep.com/problem/view/python/classes/BankAccount](https://www.codestepbystep.com/problem/view/python/classes/BankAccount)

    [https://www.codestepbystep.com/problem/view/python/classes/BankAccount\_str](https://www.codestepbystep.com/problem/view/python/classes/BankAccount_str)

    Recall from lecture that to pass the tester you will have to make "getter" methods called name and balance, each preceded with the @property decorator. You can read about string formatting in Python here: [https://www.geeksforgeeks.org/python-output-formatting/](https://www.geeksforgeeks.org/python-output-formatting/).

2. Do all of the exercises in Code-step-by-step under the python/functional programming section except for four\_letter\_words, generate\_odds, pig\_latin, print\_40\_char\_lines, and the\_lines. Most, if not all of these, can be done with a single line of functional code. You should try to do it this way. For example four\_letter\_words can be solved as

    ```python
    def four_letter_words(filename):
        return len(list(filter(lambda x: len(x)==4, open(filename).read().split())))
    ```

    (Note: `open(filename).read().split()` opens the file, reads it into a string, and then splits the string into a list of tokens.)

    Here are hints for most of the problems. Try each one without reading its hint, and then read the hint if you need the help.

    count\_negatives: filter to keep just the negatives and then get the length of the resulting list.

    count\_vowels: `for c in "hello"` will have c iterate over the characters in string s. if c is a character, then `c.upper() in "AEIOU"` will be true if it's a vowel.

    functional\_concepts: a bound variable is one that is defined locally (ie, a parameter or local variable). A free variable is not defined locally and must have its value supplied from outside the local context. For example, in the definition f(x) = x+a, x is bound because it is defined locally via the parameter, but a is free because it must be defined elsewhere for the function to make sense.

    glue\_reverse: Use reduce, and string concatenation + in a lambda

    largest\_even: make a list with only the evens, then use max with reduce.

    three\_four\_letter\_words: Use a list comprehension

    total\_circle\_area: Use map to create a list of areas, reduce to sum them, and then round to produce the answer.

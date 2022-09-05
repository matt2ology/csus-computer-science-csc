# CSC 135 - Midterm 2 Written Part - Spring 2022

1. (2 Pts) On the board is an NFA.
    Follow the method from class to convert it to a DFA.

2. (2 Pts) On the board is an NFA. Follow the method from class to convert it
    to a regular expression. Eliminate states in alphabetical order.
    Draw a diagram before and after eliminating each state (ie, six small diagrams)

3. (2 Pts) Follow the method from class to convert regular expression `(aa)*a`
    to a NFA. Draw a diagram before and after eliminating each regular
    operation (ie, four small diagrams).

4. (2 Pts) Given the lexical specification below what are the tokens generated
    from the string: "aa aaa aaaa aaaaa". List each token as an ordered pair
    (class, lexeme), for example "(TWO, aa)".

    ```text
    THREE: aaa
    ODD: (aa)*a
    TWO: aa
    ```

5. (2 Pts) For the following grammar, write next to each production of all the
    set constraints you want to deduce from it. Omit tautologies.

    $S' \rightarrow S\$$

    $S \rightarrow AB$

    $A \rightarrow aAb$

    $A \rightarrow \lambda$

    $B \rightarrow bBa$

    $B \rightarrow \lambda$

6. (2 Pts) In a proof that $\large L=\left\{a^nba^n|n\ge 0\right\}$ is not a
    regular language you would presume `L` is regular with pumping length `p`
    and then pick a string that would allow an easy contradiction using the
    pumping lemma. Give an example suitable string for this purpose, and
    explain very briefly why it is a good choice.

7. (2 Pts) The grammar $S\:\rightarrow \:\left(S\right)\left|SS\right|\lambda$
    produces all legal arrangements of parentheses. Show that it is ambiguous.

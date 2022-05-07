# Homework 7

## Question 1

Assuming you already know A is nullable and B is not nullable, which of the following set constraints can be deduced from the following set of productions?

$S\:\rightarrow \:ABS\:|\lambda$

Check all that apply. Note: Canvas scores this kind of problem proportional to (# of correct checked boxes) - (# of incorrect checked boxes).

- [ ] First(A) ⊆ First(S)
- [ ] First(B) ⊆ First(S)
- [ ] First(B) ⊆ Follow(A)
- [ ] First(S) ⊆ Follow(A)
- [ ] First(S) ⊆ Follow(B)
- [ ] Follow(B) ⊆ Follow(S)
- [ ] Follow(S) ⊆ Follow(B)
- [ ] Follow(A) ⊆ Follow(S)
- [ ] Follow(S) ⊆ Follow(A)

## Question 2

Consider the context-free grammar

$S'\:\rightarrow \:A\$$

$A\:\rightarrow\:aA\:|\:B\:|\:\lambda$

$B\:\rightarrow\:bB\:|\:cA$

In each of the following questions list your set in alphabetical order with $ at the end of the list if it's included. If a set is empty write exactly the word empty. Separate items using commas and no spaces. For example: x,y,$

> What is in First(S')?
> > 

> What is in First(A)?
> > 

> What is in First(B)?
> > 

> What is in Follow(S')?
> > 

> What is in Follow(A)?
> > 

> What is in Follow(B)?
> > 

## Question 3

Consider the context-free grammar below that generates mathematical expressions (it uses "a" as a placeholder for where values would go).

$S'\:\rightarrow\:S\$$

$S\:\rightarrow\:BA$

$A\:\rightarrow\:+BA\:|\:-BA\:|\:\lambda$

$B\:\rightarrow\:DC$

$C\:\rightarrow\:\ast DC\:|\:/DC\:|\:\lambda$

$D\:\rightarrow\:a\:|\:(S)$

The non-terminals in this grammar are S', S, A, B, C, and D. The terminals are a, +, -, \*, /, (, ), and \$. For grading purposes, list terminals in your answers in the following order: a+-\*/()\$

In each of the following questions list your set in the order given above. If a set is empty write exactly the word empty. Separate items using commas and no spaces. For example: a,-,/,)

> What is in First(S)?
> >

> What is in First(A)?
> >

> What is in First(B)?
> >

> What is in First(C)?
> >

> What is in First(D)?
> >

> What is in Follow(S)?
> >

> What is in Follow(A)?
> >

> What is in Follow(B)?
> >

> What is in Follow(C)?
> >

> What is in Follow(D)?
> >

## Question 4

Consider the context-free grammar below that generates mathematical expressions (it uses "a" as a placeholder for where values would go).

$S'\:\rightarrow\:S\$$

$S\:\rightarrow\:BA$

$A\:\rightarrow\:+BA\:|\:-BA\:|\:\lambda$

$B\:\rightarrow\:DC$

$C\:\rightarrow\:\ast DC\:|\:/DC\:|\:\lambda$

$D\:\rightarrow\:a\:|\:(S)$

The non-terminals in this grammar are S', S, A, B, C, and D. The terminals are a, +, -, *, /, (, ), and $. For grading purposes, list terminals in your answers in the following order: a+-*/()$

For each production, list which next input symbol would predict the production (assuming that the production's left-hand side is on the top of the parsing stack). You should find your answer by building a prediction table as seen in class. In each answer list your set in the order given above. If a set is empty write exactly the word empty. Separate items using commas and no spaces. For example: a,-,/,)

> $S\:\rightarrow\:BA$
> > 

> $A\:\rightarrow\:+BA$
> > 

> $A\:\rightarrow\:-BA$
> > 

> $A\:\rightarrow\:\lambda$
> > 

> $B\:\rightarrow\:DC$
> > 

> $C\:\rightarrow\:\ast DC$
> > 

> $C\:\rightarrow\:/DC$
> > 

> $C\:\rightarrow\:\lambda$
> > 

> $D\:\rightarrow\:a\:|\:(S)$
> > 

> $D\:\rightarrow\:(S)$
> > 

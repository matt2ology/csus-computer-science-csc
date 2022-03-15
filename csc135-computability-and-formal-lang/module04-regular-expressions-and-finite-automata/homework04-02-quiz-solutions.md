# Homework 4

## Instructions'

Although this is called a quiz by Canvas, it is just a part of your homework.

This work is untimed and you can retake it as many times as you want. Each time you submit, Canvas will show you your score.

You may collaborate with one or two other students on this homework if you wish, or work alone. Collaboration must be true collaboration however, which means that the work put into each problem should be roughly equal and all parties should come away understanding the solution.

There is also [ungraded homework](homework04-formative-ungraded.md) that you should do

## Question 01

Put a checkmark next to each of the following regular expressions that can generate the string "abab".

- [ ] $a^{\ast}b^{\ast}$
- [ ] $a^\ast +\:b^\ast$

> - [x] **$\left(a\:+\:b\right)^{\ast}$**
> - [x] **$\left(ab\right)^{\ast}$**
> - [x] **$\left(a^{\ast\:}b^{\ast}\right)^{\ast}$**
> - [x] **$\left(b^{\ast }a^{\ast }\right)^{\ast}$**

## Question 02

**When listing strings in "lexicographic" order, shorter strings are listed before longer ones, and same length strings are listed in alphabetical order. For example: b, aab, aba are listed in lexicographic order. Consider the regular expression (a + bb + aaaa)*. The first four strings in the language it represents, listed in lexicographic order are: λ, a, aa, bb. What are the next two strings in lexicographic order**?

**Next string**:

> **`aaa`**

**Next after that**:

> **`abb`**

## Question 03

**A regular expression is shorthand for a set of strings. For example ab*a + a* represents a set of strings for which the first several elements (when listed in length order with same length strings listed in alphabetical order) are: lambda, a, aa, aaa, aba, etc. What are the next two strings in this sequence**?

**Next string**:

> **`aaaa`**

**Next after that**:

> **`abba`**

## Question 04

```text
#states
s0
s1
s2
s3
s4
#initial
s0
#accepting
s0
s1
s2
s4
#alphabet
a
b
#transitions
s0:a>s1
s0:b>s4
s1:b>s2
s1:a>s4
s2:a>s3
s2:b>s4
s3:a,b>s4
s4:a,b>s4
```

**How many input strings does it NOT accept**?

> **`1`**

## Question 05

Open a new browser window to the FA simulator we have been using in class (<http://ivanzuzak.info/noam/webapps/fsm_simulator>) and paste the following deterministic finite automata.

```text
#states
s0
s1
s2
#initial
s0
#accepting
s2
#alphabet
0
1
#transitions
s0:0>s1
s0:1>s0
s1:0>s1
s1:1>s2
s2:0>s1
s2:1>s2
```

It is supposed to recognize the set of all strings over {0,1} that end with 01, except exactly one transition arrow is incorrect. Below, enter the incorrect transition and its correction. (For each answer, enter using the exact format given above for transitions, something like "s4:b>s3".

**Incorrect transition**:

> **`s2:1>s2`**

**Correct transition**:

> **`s2:1>s0`**

## Question 06

Open a new browser window to the FA simulator we have been using in class (<http://ivanzuzak.info/noam/webapps/fsm_simulator>) and paste the following nondeterministic finite automata (NFA).

```text
#states
a
b
c
d
#initial
a
#accepting
d
#alphabet
0
1
#transitions
a:0>a
a:1>a
a:1>b
b:1>c
c:0>d
c:1>d
```

Follow the NFA to DFA algorithm learned in class to convert it to a deterministic finite automata (DFA). Use the labeling convention seen in class where each DFA label indicates which states the NFA could be in and the letters are written in increasing order (eg, abc would indicate the NFA could be in state a, b or c). Answer the following questions. (Type only lower-case letters; no punctuation or spaces.)

**6.1 - How many states are in your DFA**?

> **`5`**

**6.2 - How many accept states are in your DFA**?

> **`2`**

**6.3 - When in state ad what state do you go to when consuming a 0**?

> **`a`**

**6.4 - When in state ad what state do you go to when consuming a 1**?

> **`ab`**

**6.5 - When in state abcd what state do you go to when consuming a 0**?

> **`ad`**

**6.6 -When in state abcd what state do you go to when consuming a 1**?

> **`abcd`**

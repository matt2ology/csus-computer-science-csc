# functional_concepts

Answer the following questions about functional programming.

The third question refers to the following function double_all:

```python
# Doubles the values of all elements in a list.
def double_all(a):
    for i in range(len(a)):
        a[i] = 2 * a[i]
The 5th question refers to the following lambda code:

a = 1
b = 2
lambda b, c: c + b - a
```

## 1) Why do functional programmers want to avoid side effects?

- [ ] ( A ) Functions without side effects are easy to reason about, reuse, combine, and parallelize.
- [ ] ( B ) Side effects make a function run more slowly.
- [ ] ( C ) A side effect makes a function unable to be understood by the programmer.
- [ ] ( D ) Side effects are bugs that should never occur.

## 2) Which of the following would be considered a side effect? (Check all that apply.)

- [ ] ( A ) Producing console output with the print() function.
- [ ] ( B ) Modifying the value of a global variable.
- [ ] ( C ) Modifying a parameter value by reference, such as a list.
- [ ] ( D ) Returning a value.
- [ ] ( E ) Writing data to a file.

## 3) What side effect does the `double_all` function have?

- [ ] ( A ) It modifies the list that was passed in.
- [ ] ( B ) It does not print the list at the end.
- [ ] ( C ) Calling the range() function produces a side effect.
- [ ] ( D ) It is not allowed to have a loop.

## 4) What is the difference between a free variable and a bound variable?

- [ ] ( A ) A bound variable is inside the lambda, and a free variable is declared outside the lambda.
- [ ] ( B ) A bound variable is constant and a free variable can be changed.
- [ ] ( C ) A bound variable is a simple type like int, and a free variable is an object.
- [ ] ( D ) A bound variable is out of scope in a function.
- [ ] ( E ) They are the same.

## 5) What are the free variables in the lambda function in the code? (Check all that apply.)

```python
a = 1
b = 2
lambda b, c: c + b - a
```

- [ ] ( A ) a
- [ ] ( B ) b (first one)
- [ ] ( C ) b (second one)
- [ ] ( D ) c
- [ ] ( E ) none of the above

## 6) What are the bound variables in the lambda function in the code? (Check all that apply.)

```python
a = 1
b = 2
lambda b, c: c + b - a
```

- [ ] ( A ) a
- [ ] ( B ) b (first one)
- [ ] ( C ) b (second one)
- [ ] ( D ) c
- [ ] ( E ) none of the above

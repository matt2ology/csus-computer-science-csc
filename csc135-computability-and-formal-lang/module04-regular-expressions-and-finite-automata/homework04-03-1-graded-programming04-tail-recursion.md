# Tail Recursion

Due: 5pm Fri Mar 18. Assignment will appear on Mimir shortly before it is due. Test as you see fit until then.

In class we saw that if the last operation in a recursive branch is a recursive call, then the recursive call can be transformed into a loop. (Many compilers do this for you behind the scenes.) For example consider this pseudocode

and this actual code

In both cases the code does no additional work in the recursive branch after the recursive call. They can be mechanically translated into

and

Sometimes a function without a "tail call" can be made into one by using an accumulator. For example, this version of factorial does not have a tail call because the multiplication is done after the recursive call is complete.

But, it can be refactored into a version with a tail call by passing an updated accumulator with each call.

When accumulators are used with recursion, they often satisfy an "invariant". (An invariant is something that is always true at the beginning of each call.) The invariant in \_fact is that x! \* acc is always the result of the original x!. It's true when acc is initialized to 1 (and x is still its original value), and it's true when x! is 1 (and acc has accumulated all its multiplications).

## Homework

For the homework, you will need the list135 definition. [This is the one](https://krovetz.net/135/module_reg/list135.py) I will use when testing your code.

1. Write a tail recursive function "reverse" that takes a list135 parameter and returns a list135 that is the same as the parameter but in reverse order. For example \[1,2,3\] would reverse to \[3,2,1\].

    Your solution should use a design similar to fact and \_fact shown above. The accumulator should be initialized as an empty list, and the invariant that you maintain should be that the reversal of the list parameter followed by the accumulator should equal the reversal of the original list.

    Do not place this method in your class. Instead it should use the list135 public interface to manipulate the old and new lists.

2. Beginning with your tail recursive solution to \_reverse, convert it to a loop version following the pattern shown above for foo and gcd.

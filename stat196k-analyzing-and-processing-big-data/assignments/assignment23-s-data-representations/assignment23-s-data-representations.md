# Exercise23: S - Data Representations

---

## Question 1 (1 pts)

    Suppose you have a 131 by 128 matrix of Float64 numbers. Each Float64 number is
    8 bytes in memory. What is the size of this object in memory, in bytes?

(131 \* 128 \* 8) = 134144

> 134,144

## Question 2 (1 pts)

    Which of the following are true about sparse data structures?

- [ ] They are usually slower than their dense counterparts
- [x] You shouldn't convert them to dense unless it's strictly necessary.
- [ ] They are always implemented as efficiently as possible.
- [x] They use less memory than their dense counterparts

## Question 3 (1 pts)

    Suppose you have an 147 by 148 matrix containing 170 nonzero entries. Suppose
    the sparse matrix is stored in triplet form, which means if we store the 1st row
    and the 3rd column x[1, 3] = 400, then we store the triplet (1, 3, 400), where
    the indices and the values are all Int64, 8 byte integers.

    What is the size of the sparse matrix divided by the size of the dense matrix?
    This is a proportion between 0 and 1.

(170 \* 8 \* 3)/(147 \* 148 \* 8) = 0.02344180915

> 0.0234

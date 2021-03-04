# assignment07-h-sampling-stream

- [assignment07-h-sampling-stream](#assignment07-h-sampling-stream)
  - [Questions](#questions)
    - [1 - Warm Up (3 pts)](#1---warm-up-3-pts)
      - [1.1 Why is it better to take a simple random sample, instead of just the first _k_ rows?](#11-why-is-it-better-to-take-a-simple-random-sample-instead-of-just-the-first-k-rows)
      - [1.2 Suppose we halt reservoir sampling at element _m_, with _m < n_, where _n_ is the size of the entire stream. Can this be a sample of the entire data? Explain](#12-suppose-we-halt-reservoir-sampling-at-element-m-with-m--n-where-n-is-the-size-of-the-entire-stream-can-this-be-a-sample-of-the-entire-data-explain)
      - [1.3 I read on the internet that `shuf -n 100 data.txt` uses reservoir sampling. The following commands each produce 100 lines from `data.txt`. For each command, will it produce a simple random sample of the lines of the file `data.txt`? Why or why not?](#13-i-read-on-the-internet-that-shuf--n-100-datatxt-uses-reservoir-sampling-the-following-commands-each-produce-100-lines-from-datatxt-for-each-command-will-it-produce-a-simple-random-sample-of-the-lines-of-the-file-datatxt-why-or-why-not)
    - [2 - Implement Reservoir Sampling (10 pts)](#2---implement-reservoir-sampling-10-pts)
      - [2.1 `seq 10 | julia shuf.jl` shuffles the integers from 1 to 10](#21-seq-10--julia-shufjl-shuffles-the-integers-from-1-to-10)
      - [2.2 `seq 10 | shuf | julia shuf.jl` shuffles the integers from 1 to 10](#22-seq-10--shuf--julia-shufjl-shuffles-the-integers-from-1-to-10)
      - [2.3 `seq 100 | julia shuf.jl 20` samples 20 random integers without replacement from 1 to 100](#23-seq-100--julia-shufjl-20-samples-20-random-integers-without-replacement-from-1-to-100)
      - [2.4 `seq 1000 | julia shuf.jl` samples 100 random integers without replacement from 1 to 1000](#24-seq-1000--julia-shufjl-samples-100-random-integers-without-replacement-from-1-to-1000)
      - [2.5 `seq -f "%.0f" 1e7 | julia shuf.jl` samples 100 random integers without replacement from 1 to 10 million](#25-seq--f-0f-1e7--julia-shufjl-samples-100-random-integers-without-replacement-from-1-to-10-million)
      - [2.6 `time seq 1e9 | julia shuf.jl` samples 100 integers from 1 to 1 billion](#26-time-seq-1e9--julia-shufjl-samples-100-integers-from-1-to-1-billion)
      - [2.7 `seq 20 | sed "s/1/one/" | julia shuf.jl` shuffles non integer input lines](#27-seq-20--sed-s1one--julia-shufjl-shuffles-non-integer-input-lines)
      - [2.8 `seq 10 | julia shuf.jl 10` shuffles the integers from 1 to 10](#28-seq-10--julia-shufjl-10-shuffles-the-integers-from-1-to-10)
      - [2.9 `seq 11 | julia shuf.jl 10` samples and shuffles 10 integers without replacement from 1 to 11](#29-seq-11--julia-shufjl-10-samples-and-shuffles-10-integers-without-replacement-from-1-to-11)
    - [3 - Hypothesis Testing (7 pts)](#3---hypothesis-testing-7-pts)
      - [3.1 Use the Chi Square test or Kolmogorov Smirnov test together with `seq` to check if your implementation of reservoir sampling differs from the uniform distribution on the integers 1 to n](#31-use-the-chi-square-test-or-kolmogorov-smirnov-test-together-with-seq-to-check-if-your-implementation-of-reservoir-sampling-differs-from-the-uniform-distribution-on-the-integers-1-to-n)
      - [3.2 Describe how you designed the test, state the null hypothesis, show your calculations, and explain your conclusion](#32-describe-how-you-designed-the-test-state-the-null-hypothesis-show-your-calculations-and-explain-your-conclusion)
    - [4 - Extra Credit - Minimal points, maximal glory (1 pt)](#4---extra-credit---minimal-points-maximal-glory-1-pt)
      - [4.1 Math option: Prove that reservoir sampling produces simple random samples](#41-math-option-prove-that-reservoir-sampling-produces-simple-random-samples)
      - [4.2 Programming option: Wikipedia claims simple reservoir sampling is slow. Is it? Check by implementing another variation of reservoir sampling and comparing speeds](#42-programming-option-wikipedia-claims-simple-reservoir-sampling-is-slow-is-it-check-by-implementing-another-variation-of-reservoir-sampling-and-comparing-speeds)

## Questions

Turn in:

1. A pdf or html file with your written answers to these questions.
2. A file named `shuf.jl.txt` containing your implementation of reservoir sampling.
3. Optionally, a script in any language calculating the hypothesis test statistics.
   This is optional because you can include these calculations in an Rmarkdown or Jupyter notebook.

### 1 - Warm Up (3 pts)

#### 1.1 Why is it better to take a simple random sample, instead of just the first _k_ rows?

A **simple random sample** of size _n_ is a sample chosen by a method in which each collection of _n_ population items is equally likely to comprise the sample, just as in the lottery; as a result, if the data were to be sorted numbers from least to greatest if taken just the first _k_ rows you'd only have a sample of the lower bound numbers and not the sample of population of numbers in the list.

#### 1.2 Suppose we halt reservoir sampling at element _m_, with _m < n_, where _n_ is the size of the entire stream. Can this be a sample of the entire data? Explain

Yes, so as long as the streamed input is randomized; for, as noted in answer to question one, you'd want a sample that is true to entire population at a smaller scale than a sample of a particular component of the population.

#### 1.3 I [read on the internet](https://unix.stackexchange.com/a/108604/456485) that `shuf -n 100 data.txt` uses reservoir sampling. The following commands each produce 100 lines from `data.txt`. For each command, will it produce a simple random sample of the lines of the file `data.txt`? Why or why not?

```bash
For example:
$ head -n 100 data.txt | shuf         # 1
$ shuf -n 100 data.txt | head -n 100  # 2
$ shuf -n 200 data.txt | head -n 100  # 3
$ shuf -n 100 data.txt | head -n 100  | sort  # 4
```

Running the command above as-is will produce the following

```bash
$ shuf -n 100 data.txt
# shuf: data.txt: No such file or directory
```

The `shuf` program only operates on files already existing. One can do so by doing one of the two commands

ONE

`seq` prints the numbers from _first_ to _last_ by _increment_. By default, each number is printed on a separate line.
When _increment_ is not specified, it defaults to ‘1’.

```bash
$ seq 100 > data.txt
# streams natural numbers from 1 (head of file) to 100 (tail of file) into data.txt
```

OR

TWO

`shuf` with argument `-i lo-hi` or `--input-range=lo-hi`

Act as if input came from a file containing the range of unsigned decimal integers lo…hi, one per line.

```bash
$ shuf -i 1-100 > data.txt
# streams "shuffled" natural numbers from one to one hundred into data.txt
```

Now they can run the following

```bash
$ head -n 100 data.txt | shuf         # 1
$ shuf -n 100 data.txt | head -n 100  # 2
$ shuf -n 200 data.txt | head -n 100  # 3
$ shuf -n 100 data.txt | head -n 100  | sort  # 4
$ cat data.txt | uniq -c | wc -l
# sanity check to see that just shuffled the listed numbers and not delete/add new ones
```

In addition, on line four all the produced simple random sample from numbers one to one hundred will be sorted from least to gratest based on the leading digit.

```bash
$ shuf -n 100 data.txt | head -n 100  | sort  # 4
# 1
# 10
# 100
# 11
# 12
# 13
# 14
# 15
# ⋮
# 88
# 89
# 9
# 90
# 91
# 92
# 93
# 94
# 95
# 96
# 97
# 98
# 99
```

### 2 - Implement Reservoir Sampling (10 pts)

Implement simple or optimal [reservoir sampling](https://en.wikipedia.org/wiki/Reservoir_sampling) by writing a program in Julia called `shuf.jl` that works like a simple version of `shuf`.
It should accept one positional argument with the number of elements to sample, and default to 100.

Verify that it works for the following cases:

#### 2.1 `seq 10 | julia shuf.jl` shuffles the integers from 1 to 10

#### 2.2 `seq 10 | shuf | julia shuf.jl` shuffles the integers from 1 to 10

#### 2.3 `seq 100 | julia shuf.jl 20` samples 20 random integers without replacement from 1 to 100

#### 2.4 `seq 1000 | julia shuf.jl` samples 100 random integers without replacement from 1 to 1000

#### 2.5 `seq -f "%.0f" 1e7 | julia shuf.jl` samples 100 random integers without replacement from 1 to 10 million

#### 2.6 `time seq 1e9 | julia shuf.jl` samples 100 integers from 1 to 1 billion

#### 2.7 `seq 20 | sed "s/1/one/" | julia shuf.jl` shuffles non integer input lines

#### 2.8 `seq 10 | julia shuf.jl 10` shuffles the integers from 1 to 10

#### 2.9 `seq 11 | julia shuf.jl 10` samples and shuffles 10 integers without replacement from 1 to 11

### 3 - Hypothesis Testing (7 pts)

**_Note: I will explain this step further in subsequent classes._**

#### 3.1 Use the Chi Square test or Kolmogorov Smirnov test together with `seq` to check if your implementation of reservoir sampling differs from the uniform distribution on the integers 1 to n

#### 3.2 Describe how you designed the test, state the null hypothesis, show your calculations, and explain your conclusion

### 4 - Extra Credit - Minimal points, maximal glory (1 pt)

#### 4.1 Math option: Prove that reservoir sampling produces simple random samples

#### 4.2 Programming option: Wikipedia claims simple reservoir sampling is slow. Is it? Check by implementing another variation of reservoir sampling and comparing speeds

# Homework - Sampling Stream

**Due** Feb 28 by 11:59pm | **Points** 20 | **Submitting** a file upload | **File Types** pdf and txt

Do the exercise on the bottom of [Homework Sampling Stream](http://webpages.csus.edu/fitzgerald/homework-sampling-stream/#questions)

- [Homework - Sampling Stream](#homework---sampling-stream)
  - [Announcements](#announcements)
    - [Grading](#grading)
    - [Shell pipelines always have a bottleneck](#shell-pipelines-always-have-a-bottleneck)
  - [Resources](#resources)
  - [Background](#background)
  - [Questions](#questions)
    - [1 - Warm Up](#1---warm-up)
    - [2 - Implement Reservoir Sampling](#2---implement-reservoir-sampling)
    - [3 - Hypothesis Testing](#3---hypothesis-testing)
    - [4 - Extra Credit](#4---extra-credit)
  - [References](#references)

---

- Implement a streaming algorithm
- Create a custom step for a shell pipeline
- Test for a distribution

## Announcements

- You can now pin and delete messages on Discord.
  Please don't delete other people's messages without talking to me.

123 GO - what's the last book you opened?

### Grading

I'm trying to figure out a better way to grade homework.

| style           | due date        | turnaround | feedback detail              | revisions allowed |
| :-------------- | :-------------- | :--------- | :--------------------------- | :---------------- |
| **Traditional** | fixed           | long       | variable                     | no                |
| **Iterative**   | revision window | short      | mostly office hours, Discord | yes               |

Hypothetical Discord feedback example with iterative grading style.

Student: _In the following code I lost points for hardcoding, and I'm not sure what this means._

```bash
    gunzip   |
    cut -f31 |
    awk ...
```

Clark: ... detailed explanation of hardcoding in this example, and how to improve it ...

... other students chime in and explain further, angels sing, yada yada ...

### Shell pipelines always have a bottleneck

Detailed notes available at the bottom of [Homework streaming large text file]({% link _posts/2021-02-05-homework-streaming-large-text-file.md %}).

## Resources

- [reservoir sampling](https://en.wikipedia.org/wiki/Reservoir_sampling) Wikipedia
- [chi-square test](https://www.itl.nist.gov/div898/handbook/eda/section3/eda35f.htm) National Institute of Standards and Technology (NIST)
- The Art of Computer Programming, Knuth, Vol 2, [3.3.1. General Test Procedures for Studying Random Data](https://learning.oreilly.com/library/view/art-of-computer/9780321635778/ch03a.xhtml)

## Background

When we meet a fresh, unfamiliar data set, the first thing to do is some basic Exploratory Data Analysis (EDA).
EDA means to familiarize ourselves with the structure, and make lots and lots of plots to see what's going on.
We need to do this before we go nuts with all our statistics and machine learning toolboxes.
The problem is that EDA with big, remote data sets is clumsy.
The simplest solution to this problem is to download a simple random sample of our data, and work with that.

[Reservoir sampling](https://en.wikipedia.org/wiki/Reservoir_sampling) is one technique for selecting a simple random sample from a data stream.
It's useful when the number of elements in the stream is unknown ahead of time.

## Questions

Turn in:

1. A pdf or html file with your written answers to these questions.
2. A file named `shuf.jl.txt` containing your implementation of reservoir sampling.
3. Optionally, a script in any language calculating the hypothesis test statistics.
   This is optional because you can include these calculations in an Rmarkdown or Jupyter notebook.

### 1 - Warm Up

(3 pts)

1. Why is it better to take a simple random sample, instead of just the first k rows?
1. Suppose we halt reservoir sampling at element m, with m < n, where n is the size of the entire stream.
   Can this be a sample of the entire data?
   Explain.
1. I [read on the internet](https://unix.stackexchange.com/a/108604/456485) that `shuf -n 100 data.txt` uses reservoir sampling.
   The following commands each produce 100 lines from `data.txt`.
   For each command, will it produce a simple random sample of the lines of the file `data.txt`?
   Why or why not?

```bash
head -n 100 data.txt | shuf         # 1
shuf -n 100 data.txt | head -n 100  # 2
shuf -n 200 data.txt | head -n 100  # 3
shuf -n 100 data.txt | head -n 100  | sort  # 4
```

### 2 - Implement Reservoir Sampling

(10 pts)

Implement simple or optimal [reservoir sampling](https://en.wikipedia.org/wiki/Reservoir_sampling) by writing a program in Julia called `shuf.jl` that works like a simple version of `shuf`.
It should accept one positional argument with the number of elements to sample, and default to 100.

Verify that it works for the following cases:

1. `seq 10 | julia shuf.jl` shuffles the integers from 1 to 10.
1. `seq 10 | shuf | julia shuf.jl` shuffles the integers from 1 to 10.
1. `seq 100 | julia shuf.jl 20` samples 20 random integers without replacement from 1 to 100.
1. `seq 1000 | julia shuf.jl` samples 100 random integers without replacement from 1 to 1000.
1. `seq -f "%.0f" 1e7 | julia shuf.jl` samples 100 random integers without replacement from 1 to 10 million.

### 3 - Hypothesis Testing

(7 pts)

**_Note: I will explain this step further in subsequent classes._**

Use the Chi Square test or Kolmogorov Smirnov test together with `seq` to check if your implementation of reservoir sampling differs from the uniform distribution on the integers 1 to n.
Describe how you designed the test, state the null hypothesis, show your calculations, and explain your conclusion.

### 4 - Extra Credit

(1 pt)

Minimal points, maximal glory.

Math option:
Prove that reservoir sampling produces simple random samples.

Programming option:
Wikipedia claims simple reservoir sampling is slow.
Is it?
Check by implementing another variation of reservoir sampling and comparing speeds.

## References

- [How to randomly sample a subset of a file](https://unix.stackexchange.com/questions/108581/how-to-randomly-sample-a-subset-of-a-file/108604#108604)
- [Reservoir sampling](https://en.wikipedia.org/wiki/Reservoir_sampling)
- [Shuf: Shuffling text](https://www.gnu.org/software/coreutils/manual/html_node/shuf-invocation.html#shuf-invocation)
- [Shuffle a given array using Fisher–Yates shuffle Algorithm](https://www.geeksforgeeks.org/shuffle-a-given-array-using-fisher-yates-shuffle-algorithm/)
- [Shuffle or Randomize a list in Java](https://www.geeksforgeeks.org/shuffle-or-randomize-a-list-in-java/?ref=rp)
- [Unit Testing](https://docs.julialang.org/en/v1/stdlib/Test/)
- [Getting Familiar With Loops In Julia](https://towardsdatascience.com/getting-familiar-with-loops-in-julia-cfbcc344728c)
- [A Fast Method to Stream Data from Big Data Sources](https://indico.io/blog/fast-method-stream-data-from-big-data-sources/)
- [julia-base-scheduling-tasks-yield](https://docs.julialang.org/en/v1/base/parallel/#Scheduling)
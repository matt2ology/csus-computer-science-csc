# Assignment 15 - Homework - Clustering

**Due** Apr 19 by 11:59pm | **Points** 20 | **Submitting** a file upload | **File Types** pdf

- [Assignment 15 - Homework - Clustering](#assignment-15---homework---clustering)
  - [Some Rubric](#some-rubric)
  - [Dates](#dates)
  - [Resources](#resources)
  - [Data](#data)
  - [1 Exploratory Data Analysis](#1-exploratory-data-analysis)
  - [2 Selecting a Subset](#2-selecting-a-subset)
  - [3 Principal Components Analysis](#3-principal-components-analysis)
  - [4 Clustering](#4-clustering)
  - [5 Extra Credit](#5-extra-credit)

## Some Rubric

| Criteria  | Ratings    |             |             |                |                 |          | Pts              |
| :-------- | :--------- | :---------- | :---------- | :------------- | :-------------- | :------- | :--------------- |
| OutcomeQ1 | 5 pts      | 4 pts       | 3 pts       | 2 pts          | 1 pts           | 0 pts    | 5 pts            |
|           | Full Marks | minor issue | some issues | serious issues | tried something | No Marks |                  |
| OutcomeQ2 | 5 pts      | 4 pts       | 3 pts       | 2 pts          | 1 pts           | 0 pts    | 5 pts            |
|           | Full Marks | minor issue | some issues | serious issues | tried something | No Marks |                  |
| OutcomeQ3 | 5 pts      | 4 pts       | 3 pts       | 2 pts          | 1 pts           | 0 pts    | 5 pts            |
|           | Full Marks | minor issue | some issues | serious issues | tried something | No Marks |                  |
| OutcomeQ4 | 5 pts      | 4 pts       | 3 pts       | 2 pts          | 1 pts           | 0 pts    | 5 pts            |
|           | Full Marks | minor issue | some issues | serious issues | tried something | No Marks |                  |
|           |            |             |             |                |                 |          | Total Points: 20 |

---

- Apply and interpret k means clustering
- Apply and interpret principal components analysis

123 GO - What are you excited for this summer?

The plan for next week is to go carefully through software for PCA and kmeans.

## Dates

- Wednesday, April 14th submit early for early grading/feedback
- Due Monday, April 19th

Can always ask for feedback on Discord.

## Resources

1. [Google machine learning](https://developers.google.com/machine-learning/clustering/algorithm/advantages-disadvantages)
2. Julia [MultivariateStats](https://multivariatestatsjl.readthedocs.io/en/stable/index.html)

## Data

The data is available in S3, and the following command will download it.

```bash
aws s3 cp s3://stat196k-data-examples/processed990.zip ./ --no-sign-request
```

Alternatively, you can download it from the browser: [processed990.zip](https://stat196k-data-examples.s3.amazonaws.com/processed990.zip).

This zip file contains three Julia files containing data we produced in the [XML to matrix assignment]( {% link _posts/2021-03-11-homework-xml-to-matrix.md %}).

1. `irs990extract.jldata` contains summary statistics computed from each of the XML files.
1. `terms.jldata` contains all the terms in the term document matrix.
1. `termfreq.jldata` contains the term frequency matrix.
   The rows correspond to the indexes of `irs990extract`, the XML files.
   The columns correspond to the indexes of `terms`, the dictionary of all possible words.
   Each row represents the relative frequency of each word in the mission statement.

Once you unzip the file, you can load each object into Julia as follows.

```julia
terms = Serialization.deserialize("terms.jldata")
```

## 1 Exploratory Data Analysis

(5 pts)

1. Relatively how many terms appear in exactly one document?
2. Relatively how many terms appear at least 5 times?
3. Show the 20 most frequent words.
   Words like "and", "to", "the" aren't especially meaningful.
   Which is the first word that you feel may be meaningful for characterizing the nonprofit?
   Why?
4. How many documents contain "sacramento"?
5. What's one element in `irs990extract` where the mission contains "sacramento"?

Come up with your own question similar to the questions above, and answer it.

## 2 Selecting a Subset

(5 pts)

What do you do when your program doesn't run?
Try using a subset of the data, the most important subset.

1. Use one or more of the fields in `irs990extract` to define and pick the 10,000 largest nonprofits.
2. What's the largest nonprofit based on your definition? Does it seem reasonable?
3. Drop all words that don't appear at least twice in this subset.

We'll use this subset for the remainder of the assignment.

## 3 Principal Components Analysis

(5 pts)

Fit the first 10 principal components, i.e. project the data down into a 10 dimensional subspace.

1. Interpret the principal ratio.
   What does it mean?
1. Plot the variances of the first 10 principal components as a function of the principal component number.
   What do you observe?
1. Which words have the relatively largest loadings in the first principal component?
   (These the absolute values of the entries of `projection()`.)
   Are these the kinds of words you expected?
   Explain.

Hints:

1. Resources for interpreting principal components: [Making sense of principal component analysis, eigenvectors & eigenvalues](https://stats.stackexchange.com/q/2691/103118) [PCA and proportion of variance explained](https://stats.stackexchange.com/q/22569/103118)
1. Transpose the matrix to follow the structure described in the [MultivariateStats documentation](https://multivariatestatsjl.readthedocs.io/en/stable/pca.html#fit)
1. If the program is too slow, try converting from a dense to a sparse matrix.

## 4 Clustering

(5 pts)

Apply k means with k = 3 to the principal components of the subset of data.
This means you should be fitting k means to a data matrix with 10,000 observations, and 10 features, which are the scores for each of the 10 principal components.

1. How many elements are in each group?
2. Which nonprofits are closest to the centroids?
   Feel free to use the function below.
3. k means should find a group of mission statements that are very similar.
   What happened?
   Is it reasonable?
   If we were to continue this analysis, what would you do next?

```julia
"""
    Find the indices of the data points that are closest to the centroids defined by the kmeans clustering.
"""
function close_centroids(knn_model)
    groups = knn_model.assignments
    k = length(unique(groups))
    n = length(groups)
    result = fill(0, k)
    for ki in 1:k
        cost_i = fill(Inf, n)
        group_i = ki .== groups
        cost_i[group_i] = knn_model.costs[group_i]
        result[ki] = argmin(cost_i)
    end
    result
end
```

## 5 Extra Credit

(1 pt)

Fit k means with k = 3 to the entire original `termfreq` data.
This takes around 18 hours to run.
Did k means again find a group of mission statements that are very similar, following the same pattern as in the previous question?

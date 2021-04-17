# Assignment 15 - Homework - Clustering

**Due** Apr 19 by 11:59pm | **Points** 20 | **Submitting** a file upload | **File Types** pdf

- [Assignment 15 - Homework - Clustering](#assignment-15---homework---clustering)
  - [1 Exploratory Data Analysis](#1-exploratory-data-analysis)
  - [2 Selecting a Subset](#2-selecting-a-subset)
  - [3 Principal Components Analysis](#3-principal-components-analysis)
    - [Hints](#hints)
  - [4 Clustering](#4-clustering)
  - [5 Extra Credit](#5-extra-credit)

## 1 Exploratory Data Analysis

(5 pts)

1. Relatively how many terms appear in exactly one document?
   > PLACE_HOLDER
2. Relatively how many terms appear at least 5 times?
   > PLACE_HOLDER
3. Show the 20 most frequent words.
   Words like "and", "to", "the" aren't especially meaningful.
   Which is the first word that you feel may be meaningful for characterizing the nonprofit?
   Why?
   > PLACE_HOLDER
4. How many documents contain "sacramento"?
   > PLACE_HOLDER
5. What's one element in `irs990extract` where the mission contains "sacramento"?
   > PLACE_HOLDER

Come up with your own question similar to the questions above, and answer it.

## 2 Selecting a Subset

(5 pts)

What do you do when your program doesn't run?
Try using a subset of the data, the most important subset.

1. Use one or more of the fields in `irs990extract` to define and pick the 10,000 largest nonprofits.
   > PLACE_HOLDER
2. What's the largest nonprofit based on your definition? Does it seem reasonable?
   > PLACE_HOLDER
3. Drop all words that don't appear at least twice in this subset.
   > PLACE_HOLDER

We'll use this subset for the remainder of the assignment.

## 3 Principal Components Analysis

(5 pts)

Fit the first 10 principal components, i.e. project the data down into a 10 dimensional subspace.

1. Interpret the principal ratio.
   What does it mean?
   > PLACE_HOLDER
2. Plot the variances of the first 10 principal components as a function of the principal component number.
   What do you observe?
   > PLACE_HOLDER
3. Which words have the relatively largest loadings in the first principal component?
   (These the absolute values of the entries of `projection()`.)
   Are these the kinds of words you expected?
   Explain.
   > PLACE_HOLDER

### Hints

1. Resources for interpreting principal components: [Making sense of principal component analysis, eigenvectors & eigenvalues](https://stats.stackexchange.com/q/2691/103118) [PCA and proportion of variance explained](https://stats.stackexchange.com/q/22569/103118)
1. Transpose the matrix to follow the structure described in the [MultivariateStats documentation](https://multivariatestatsjl.readthedocs.io/en/stable/pca.html#fit)
1. If the program is too slow, try converting from a dense to a sparse matrix.

## 4 Clustering

(5 pts)

Apply k means with k = 3 to the principal components of the subset of data.
This means you should be fitting k means to a data matrix with 10,000 observations, and 10 features, which are the scores for each of the 10 principal components.

1. How many elements are in each group?

   > PLACE_HOLDER

2. Which nonprofits are closest to the centroids?
   Feel free to use the function below.

   > PLACE_HOLDER

3. k means should find a group of mission statements that are very similar.
   What happened?

   > PLACE_HOLDER

   Is it reasonable?

   > PLACE_HOLDER

   If we were to continue this analysis, what would you do next?

   > PLACE_HOLDER

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

> PLACE_HOLDER
# S - Natural Language Processing

- [S - Natural Language Processing](#s---natural-language-processing)
  - [Question 1](#question-1)
  - [Question 2](#question-2)
  - [Question 3](#question-3)
  - [Question 4](#question-4)
  - [Question 5](#question-5)
  - [References](#references)

## Question 1

The seven bit binary ASCII code for A is "100 0001", referring to Wikipedia's
control code chart 
[Wikipedia's control code chart](https://en.wikipedia.org/wiki/ASCII#Printable_characters).

What is the seven bit binary ASCII code for S?

    101 0011

## Question 2

A \_\_ consists of a collection of \_\_

| A \_\_\_\_           | of \_\_\_\_ |
| :------------------- | :---------- |
| document             | matrices    |
| corpus               | corpora     |
| term document matrix | documents   |
| bag of words         |             |

    A corpus consists of a collection of documents.

## Question 3

Consider this string:

> "Wear a mask. Masks help."

Use Julia's TextAnalysis package to strip punctuation, replace upper case with
lower case, and stem all words. What is the resulting text?

    wear a mask mask help

## Question 4

Suppose we process the following documents by removing punctuation, replacing
upper case with lower case, and stemming all words.

1. "Wear a mask. Masks help."
2. "Masks are useless."

How many rows will the document term matrix have?

```julia
TEXT_STRING01 = "Wear a mask. Masks help."
TEXT_STRING02 = "Masks are useless."
DOCUMENT01 = StringDocument(TEXT_STRING01)
DOCUMENT02 = StringDocument(TEXT_STRING02)
CORPUS = Corpus([DOCUMENT01, DOCUMENT02])
#= Preprocess document or corpus based on the input flags: strip punctuation,
replace upper case with lower case, and stem all words =#
prepare!(CORPUS, strip_punctuation | strip_case | stem_words)
#= Often we want to represent documents as a matrix of word counts so that we
can apply linear algebra operations and statistical techniques. Before we do
this, we need to update the lexicon: =#
update_lexicon!(CORPUS)
# DocumentTermMatrix(CORPUS) <-- A DocumentTermMatrix object is a special type:
document_term_matrix = DocumentTermMatrix(CORPUS)
#= If you would like to use a dense matrix instead, you can pass this as an
argument to the dtm function: =#
dtm(document_term_matrix)
# If you would like to use a simple sparse matrix, call dtm() on this object:
dtm(document_term_matrix, :dense)
```

    ┌ Info: If you would like to use a dense matrix instead, you can pass this
    | as an argument to the dtm function:
    │   dtm(document_term_matrix) =
    │    2×6 SparseArrays.SparseMatrixCSC{Int64,Int64} with 7 stored entries:
    │      [1, 1]  =  1
    │      [2, 2]  =  1
    │      [1, 3]  =  1
    │      [1, 4]  =  2
    │      [2, 4]  =  1
    │      [2, 5]  =  1
    └      [1, 6]  =  1
    ┌ Info: If you would like to use a simple sparse matrix, call dtm() on this
    | object:
    │   dtm(document_term_matrix, :dense) =
    │    2×6 Array{Int64,2}:
    │     1  0  1  2  0  1
    └     0  1  0  1  1  0

    Two

## Question 5

Suppose we process the following documents by removing punctuation, replacing
upper case with lower case, and stemming all words.

1. "Wear a mask. Masks help."
2. "Masks are useless."

How many columns will the document term matrix have?

```julia
println("How many columns will the document term matrix have?")
TEXT_SAMPLE01 = "Wear a mask. Masks help."
TEXT_SAMPLE02 = "Masks are useless."
println("Original Text: " * TEXT_SAMPLE01)
println("Original Text: " * TEXT_SAMPLE02)
DOCUMENT01 = StringDocument(TEXT_SAMPLE01)
DOCUMENT02 = StringDocument(TEXT_SAMPLE02)
println("strip punctuation, replace upper case with lower case, and stem all words")
prepare!(DOCUMENT01, strip_punctuation | strip_case | stem_words)
prepare!(DOCUMENT02, strip_punctuation | strip_case | stem_words)
println(text(DOCUMENT01))
println(text(DOCUMENT02))
crps = Corpus([StringDocument(text(DOCUMENT01)), StringDocument(text(DOCUMENT02))])
update_lexicon!(crps)
document_term_matrix = DocumentTermMatrix(crps)
dtm(document_term_matrix)
dtm(document_term_matrix, :dense)
```

    ┌ Info: If you would like to use a simple sparse matrix, call dtm() on this
    | object:
    │   dtm(document_term_matrix, :dense) =
    │    2×6 Array{Int64,2}:
    │     1  0  1  2  0  1
    └     0  1  0  1  1  0
    Six

## References

- [Document-term matrix](https://en.wikipedia.org/wiki/Document-term_matrix#:~:text=A%20document%2Dterm%20matrix%20is,in%20a%20collection%20of%20documents.&text=In%20such%20a%20case%2C%20this,the%20words%20in%20the%20document.)
- [juliahub: API References](https://juliahub.com/docs/TextAnalysis/5Mwet/0.7.2/APIReference/#TextAnalysis.dtm-Tuple{DocumentTermMatrix,Symbol})
- [juliahub: Creating a Document Term Matrix](https://juliahub.com/docs/TextAnalysis/5Mwet/0.7.2/features/#Creating-a-Document-Term-Matrix)
- [juliatext.github.io : Creating a Document Term Matrix](https://juliatext.github.io/TextAnalysis.jl/latest/features/)

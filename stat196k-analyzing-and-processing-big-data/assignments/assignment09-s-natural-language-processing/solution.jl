# https://juliahub.com/docs/TextAnalysis/5Mwet/0.7.2/APIReference/#TextAnalysis.prepare!-Tuple{Corpus,UInt32}
# first install via repel 'import Pkg; Pkg.add("TextAnalysis")'
# Loading
# In all of the examples that follow, we'll assume that you have the TextAnalysis
# package fully loaded. This means that we think you've implicitly typed before
# every snippet of code.
using TextAnalysis
"""
Consider this string:

Wear a mask. Masks help.

Use Julia's TextAnalysis package to strip punctuation, replace upper case with
lower case, and stem all words. What is the resulting text?
"""
function question3()
    println("QUESTION 3:\nWhat is the resulting text?")
    TEXT_SAMPLE = "Wear a mask. Masks help."
    @info "ORIGINAL TEXT: " TEXT_SAMPLE
    DOCUMENT = StringDocument(TEXT_SAMPLE)
    @info "TEXT_SAMPLE TO DOCUMENT StringDocument():" DOCUMENT
    @info "strip punctuation, replace upper case with lower case, and stem all words:" prepare!(DOCUMENT, strip_punctuation | strip_case | stem_words)
    @info "TEXT RESULTS" text(DOCUMENT)
end

"""
Suppose we process the following documents by removing punctuation, replacing 
upper case with lower case, and stemming all words.

1. "Wear a mask. Masks help."
2. "Masks are useless."

How many rows will the document term matrix have?
"""
function question4()
    println("QUESTION 4:\nHow many rows will the document term matrix have?")
    TEXT_STRING01 = "Wear a mask. Masks help."
    TEXT_STRING02 = "Masks are useless."
    @info "TEXT ASSIGNED" TEXT_STRING01 TEXT_STRING02
    DOCUMENT01 = StringDocument(TEXT_STRING01)
    DOCUMENT02 = StringDocument(TEXT_STRING02)
    @info "DOCUMENTS ASSIGNED <-- TEXT INPUTS PLACED IN StringDocument() FUNCTION" StringDocument(TEXT_STRING01) StringDocument(TEXT_STRING02)
    CORPUS = Corpus([DOCUMENT01, DOCUMENT02])
    @info "DOCUMENT INPUTS PLACED IN Corpus([]) FUNCTION" Corpus([DOCUMENT01, DOCUMENT02])
    @info "CORPUS ASSIGNED" CORPUS
    prepare!(CORPUS, strip_punctuation | strip_case | stem_words)
    @info "Preprocess document or corpus based on the input flags: strip punctuation, replace upper case with lower case, and stem all words" prepare!(CORPUS, strip_punctuation | strip_case | stem_words)
    update_lexicon!(CORPUS)
    @info "update_lexicon!(CORPUS)" update_lexicon!(CORPUS)
    @info "CORPUS WITH update_lexicon" CORPUS
    document_term_matrix = DocumentTermMatrix(CORPUS)
    @info "DocumentTermMatrix(CORPUS) <-- A DocumentTermMatrix object is a special type: " document_term_matrix
    dtm(document_term_matrix)
    @info "If you would like to use a dense matrix instead, you can pass this as an argument to the dtm function:" dtm(document_term_matrix)
    @info "If you would like to use a simple sparse matrix, call dtm() on this object:" dtm(document_term_matrix, :dense)
end

"""
Suppose we process the following documents by removing punctuation, replacing 
upper case with lower case, and stemming all words.

1. "Wear a mask. Masks help."
2. "Masks are useless."

How many columns will the document term matrix have?
"""
function question5()
    println("QUESTION 5:\nHow many columns will the document term matrix have?")
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
    crps = Corpus([StringDocument(text(DOCUMENT01)),
                             StringDocument(text(DOCUMENT02))])
    update_lexicon!(crps)
    document_term_matrix = DocumentTermMatrix(crps)
    @info "A DocumentTermMatrix object is a special type. If you would like to use a simple sparse matrix, call dtm() on this object:" dtm(document_term_matrix)
    @info "If you would like to use a dense matrix instead, you can pass this as an argument to the dtm function:" dtm(document_term_matrix, :dense)
end

function main()
    question3()
    println("\n")
    question4()
    println("\n")
    question5()
end

if abspath(PROGRAM_FILE) == @__FILE__
    main()
end
using TextAnalysis
s1 = "Bash has been processing big data forever."
s2 = "Don't bash big data. It's big fun!"
@info "A document is one unit of text, for example:" s1 s2

d1 = StringDocument(s1)
d2 = StringDocument(s2)
@info "Printing shows some metadata." d1 d2

c = Corpus([d1, d2])
@info "A corpus is a collection of documents. The plural form is corpora." c

println("Processing")

@info "tokens are the semantically meaningful elements of the text, often just 
single words. tokenization, aka lexing breaks a document 
down into tokens" tokens(d1)

@info "prepare strip_punctuation" prepare!(d1, strip_punctuation) d1

@info "remove_case" remove_case!(d1) d1

@info "Let’s look at the corpus" text(c[1]) text(c[2])

@info "“The lexicon of a corpus consists of all the terms that occur in any 
document in the corpus.”" update_lexicon!(c) lexicon(c) c

d3 = StringDocument("help helpful helper helping person")

@info "How many unique words are in the following example?" d3

@info "Stemming means converting multiple words to one representative word
stem." stem!(d3) text(d3)

@info "Let’s stem the whole corpus." stem!(c) text(c[1])

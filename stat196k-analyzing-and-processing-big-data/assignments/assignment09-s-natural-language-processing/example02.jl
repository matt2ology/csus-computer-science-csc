using TextAnalysis
println("Document Term Matrix")
println("Let’s bring it all together now.")

c = Corpus([StringDocument("Bash has been processing big data forever."),
                    StringDocument("Don't bash big data. It's big fun!")])

@info "corpus is a collection of documents" c

@info "remove_case" remove_case!(c) c

@info "prepare by striping punctuation" prepare!(c, strip_punctuation) c

@info "stem" stem!(c) c

@info "update_lexicon" update_lexicon!(c) c

@info "lexicon results" lexicon(c) c

@info "Let’s look at the corpus" text(c[1]) text(c[2])

d = DocumentTermMatrix(c)

@info "d = DocumentTermMatrix(c)" d

@info "A DocumentTermMatrix object is a special type. If you would like to use 
a simple sparse matrix, call dtm() on this object:" dtm(d)

@info "If you would like to use a dense matrix instead, you can pass this as 
an argument to the dtm function:" dtm(d, :dense)
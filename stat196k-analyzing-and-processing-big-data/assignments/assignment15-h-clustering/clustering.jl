using Serialization
using Statistics
function main()
    irs990extract = Serialization.deserialize("./data/irs990extract.jldata")
    termfreq = Serialization.deserialize("./data/termfreq.jldata")
    terms = Serialization.deserialize("./data/terms.jldata")
    number_of_terms_in_document = []
    number_of_documents = length(irs990extract)
    for row_of_documents in 1:number_of_documents
        row = termfreq[row_of_documents,1:end].nzind
        println(length(row))
        push!(number_of_terms_in_document,length(row))
    end
    println("***")
    println("Minimum: ",Statistics.minimum(number_of_terms_in_document))
    println("Maximum: ",Statistics.maximum(number_of_terms_in_document))
    println("Average: ",Statistics.mean(number_of_terms_in_document))
    println("***")
end

if abspath(PROGRAM_FILE) == @__FILE__
    main()
end
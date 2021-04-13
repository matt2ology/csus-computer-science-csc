using Serialization

function main()
    irs990extract = Serialization.deserialize("./data/irs990extract.jldata")
    termfreq = Serialization.deserialize("./data/termfreq.jldata")
    terms = Serialization.deserialize("./data/terms.jldata")
    
    @info "" length(irs990extract) size(termfreq) length(terms)
    println()
    
    println(join(terms[termfreq[55, 1:end].nzind]," "))
    println()
    println(lowercase(irs990extract[55]["mission"]))

end

if abspath(PROGRAM_FILE) == @__FILE__
    main()
end
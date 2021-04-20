using Serialization
using Statistics
function main()
    irs990extract = Serialization.deserialize("./data/irs990extract.jldata")
    termfreq = Serialization.deserialize("./data/termfreq.jldata")
    terms = Serialization.deserialize("./data/terms.jldata")

    first10k = 1:10_000
    termfreq10k = termfreq[first10k,:]
    termAppeared = 0 .< termfreq10k # So if these terms are positive and the term did appear
    wordAppearanceCount = sum(termAppeared, dims = 1)
end # end function main()

if abspath(PROGRAM_FILE) == @__FILE__
    main()
end # end if abspath(PROGRAM_FILE) == @__FILE__

#= 
Assignment 10 - Homework XML To Matrix
Use NLP to convert the text descriptions of each nonprofit into the rows of one
big document term matrix. The resulting matrix will have one row for every 990
form that has a description, and one column for every word in the lexicon. In
the next assignment we will use this matrix to cluster the nonprofits based on
their descriptions. 
=#

using EzXML # For XML/HTML handling tools for primates

function main()
    # do stuff
end

if abspath(PROGRAM_FILE) == @__FILE__
    main()
end
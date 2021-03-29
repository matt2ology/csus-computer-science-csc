#= 
Assignment 10 - Homework XML To Matrix
Use NLP to convert the text descriptions of each nonprofit into the rows of one
big document term matrix. The resulting matrix will have one row for every 990
form that has a description, and one column for every word in the lexicon. In
the next assignment we will use this matrix to cluster the nonprofits based on
their descriptions. =#

using EzXML # For XML/HTML handling tools for primates

function main()
    IRS990_FILEPATHS = readdir("data/2019", join=true) # Array of file paths
    # reads the entire XML file
    document = readxml("example/201900079349100000_public.xml")
    for file in IRS990_FILEPATHS
        println(file)
    end
end

if abspath(PROGRAM_FILE) == @__FILE__
    main()
end

# //BusinessNameLine1Txt1/text()
# //Desc/text()
## //IRS990/Description/text()
## //ActivityOrMissionDesc/text()
# //CYTotalRevenueAmnt
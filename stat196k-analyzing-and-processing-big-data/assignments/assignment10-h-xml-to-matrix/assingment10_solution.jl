#= 
Assignment 10 - Homework XML To Matrix
Use NLP to convert the text descriptions of each nonprofit into the rows of one
big document term matrix. The resulting matrix will have one row for every 990
form that has a description, and one column for every word in the lexicon. In
the next assignment we will use this matrix to cluster the nonprofits based on
their descriptions. =#

using EzXML # For XML/HTML handling tools for primates
using TextAnalysis
using Serialization

"""
    get_content(xml_file)
A wrapper function to collect the respective data and place results into a dictionary
"""
function get_content(xml_file)
    @info "Getting content"
    document = readxml(xml_file)
    organization_name = get_organization_name(document, 
                                ["//ReturnHeader/Filer/BusinessName/BusinessNameLine1Txt",
                                 "//IRS990/DoingBusinessAsName/BusinessNameLine1Txt"])
    organization_description = get_nonprofit_description(document, 
                                ["//IRS990/ActivityOrMissionDesc",
                                 "//IRS990/Desc",
                                 "//IRS990EZ/ProgramSrvcAccomplishmentGrp/DescriptionProgramSrvcAccomTxt"])
    organization_revenue = get_revenue(document, 
                                ["//IRS990/RevenueAmt",
                                 "//IRS990/TotalRevenueGrp/TotalRevenueColumnAmt"])
    @info "Building dictionary"
    Dict("file" => xml_file,
         "organization" => organization_name,
         "description" => organization_description,
         "size_proxy" => organization_revenue)
end

"""
    get_organization_name(document,array_of_xpath_strings)
Takes in a document and an array of _Organization Name_ Xpath strings to find,
and returns the first one that matches the document. If Xpath not found will
return `missing`
"""
function get_organization_name(document, array_of_xpath_strings)
    @info "Searching for organization_name"
    for xpath in array_of_xpath_strings
        found_xml_node = findfirst(xpath, document)
        """
        Evaluates `found_xml_node` if the value is not `nothing` the respective
            Xpath value will be assigned
        """
        if !isnothing(found_xml_node)
            @info "FOUND: organization_name" nodecontent(found_xml_node)
            return nodecontent(found_xml_node)
        end
    end
    @warn "NOT FOUND: organization_name"
    # If none of the Xpath values are found `missing` will be returned
    return missing
end

"""
    get_nonprofit_description(document,array_of_xpath_strings)
Takes in a document and an array of _Nonprofit Description_ Xpath strings to find,
and returns the first one that matches the document. If Xpath not found will
return `missing`
"""
function get_nonprofit_description(document, array_of_xpath_strings)
    @info "Searching for nonprofit_description"
    for xpath in array_of_xpath_strings
        found_xml_node = findfirst(xpath, document)
        """
        Evaluates `found_xml_node` if the value is not `nothing` the respective
            Xpath value will be assigned
        """
        if !isnothing(found_xml_node)
            @info "FOUND: nonprofit_description" nodecontent(found_xml_node)
            return nodecontent(found_xml_node)
        end
    end
    @warn "NOT FOUND: nonprofit_description"
    # If none of the Xpath values are found `missing` will be returned
    return missing
end

"""
    get_revenue(document,array_of_xpath_strings)
Takes in a document and an array of _Revenue_ Xpath strings to find,
and returns the first one that matches the document. If Xpath not found will
return `missing`
"""
function get_revenue(document, array_of_xpath_strings)
    @info "Searching for revenue"
    for xpath in array_of_xpath_strings
        found_xml_node = findfirst(xpath, document)
        """
        Evaluates `found_xml_node` if the value is not `nothing` the respective
            Xpath value will be assigned
        """
        if !isnothing(found_xml_node)
            @info "FOUND: revenue" nodecontent(found_xml_node)
            return nodecontent(found_xml_node)
        end
    end
    @warn "NOT FOUND: revenue"
    # If none of the Xpath values are found `missing` will be returned
    return missing
end

"""
    get_number_of_employees(document,array_of_xpath_strings)
Takes in a document and an array of _Number of Employees_ Xpath strings to find,
and returns the first one that matches the document. If Xpath not found will
return `missing`
"""
function get_number_of_employees(document, array_of_xpath_strings)
    @info "Searching for number_of_employees"
    for xpath in array_of_xpath_strings
        found_xml_node = findfirst(xpath, document)
        """
        Evaluates `found_xml_node` if the value is not `nothing` the respective
            Xpath value will be assigned
        """
        if !isnothing(found_xml_node)
            @info "FOUND: number_of_employees" nodecontent(found_xml_node)
            return nodecontent(found_xml_node)
        end
    end
    @warn "NOT FOUND: number_of_employees"
    # If none of the Xpath values are found `missing` will be returned
    return missing
end

function main()
    IRS990_2019_FILES = readdir("data/2019/", join=true) # Array of file paths
    
    dictionary_of_xml_node_text = Dict()
    dictionary_of_xml_node_text = map(get_content, IRS990_2019_FILES)

    @info "Processing description text"
    description = [entry["organization_description"] for entry in dictionary_of_xml_node_text]
    
    string_test = [StringDocument(" ")]
    collection_of_files_processed = collect(Int, size(IRS990_2019_FILES))
    for file in 1:collection_of_files_processed[1]
        push!(string_test, StringDocument(description[file]))
    end

    println("The total number of processed description text: ", collection_of_files_processed[1])

    @info "Creating the term document matrix"
    CORPUS = Corpus(testStrings)
    remove_case!(CORPUS)
    prepare!(CORPUS, strip_punctuation)
    stem!(CORPUS)
    standardize!(CORPUS, StringDocument)
    update_lexicon!(CORPUS)
    document_term_matrix = DocumentTermMatrix(CORPUS)
    serialize("corpus.jldata", CORPUS)
end

if abspath(PROGRAM_FILE) == @__FILE__
    main()
end
#= 
Assignment 10 - Homework XML To Matrix
Use NLP to convert the text descriptions of each nonprofit into the rows of one
big document term matrix. The resulting matrix will have one row for every 990
form that has a description, and one column for every word in the lexicon. In
the next assignment we will use this matrix to cluster the nonprofits based on
their descriptions. =#

using EzXML # For XML/HTML handling tools for primates

function main()
    IRS990_FILE = readdir("data/2019/", join=true) # Array of file paths

end

if abspath(PROGRAM_FILE) == @__FILE__
    main()
end
## for file in IRS990_FILE[1:5]
##     println(file)
##     document = readxml(file)
##     c1 = getcontent(document, "BusinessNameLine1Txt/text()")
## end

"""
    get_organization_name(document,array_of_xpath_strings)
Takes in a document and an array of _Organization Name_ Xpath strings to find,
and returns the first one that matches the document. If Xpath not found will
return `missing`
"""
function get_organization_name(document, array_of_xpath_strings)
    @info "Searching for organization_name..."
    for xpath in array_of_xpath_strings
        found_xml_node = findfirst(xpath, document)
        """
        Evaluates `found_xml_node` if the value is not `nothing` the respective
            Xpath value will be assigned
        """
        if !isnothing(found_xml_node)
            @info "FOUND: organization_name"
            return nodecontent(found_xml_node)
        end
    end
    @info "NOT FOUND: organization_name"
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
    @info "Searching for nonprofit_description..."
    for xpath in array_of_xpath_strings
        found_xml_node = findfirst(xpath, document)
        """
        Evaluates `found_xml_node` if the value is not `nothing` the respective
            Xpath value will be assigned
        """
        if !isnothing(found_xml_node)
            @info "FOUND: nonprofit_description"
            return nodecontent(found_xml_node)
        end
    end
    @info "NOT FOUND: nonprofit_description"
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
    @info "Searching for revenue..."
    for xpath in array_of_xpath_strings
        found_xml_node = findfirst(xpath, document)
        """
        Evaluates `found_xml_node` if the value is not `nothing` the respective
            Xpath value will be assigned
        """
        if !isnothing(found_xml_node)
            @info "FOUND: revenue"
            return nodecontent(found_xml_node)
        end
    end
    @info "NOT FOUND: revenue"
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
    @info "Searching for number_of_employees..."
    for xpath in array_of_xpath_strings
        found_xml_node = findfirst(xpath, document)
        """
        Evaluates `found_xml_node` if the value is not `nothing` the respective
            Xpath value will be assigned
        """
        if !isnothing(found_xml_node)
            @info "FOUND: number_of_employees"
            return nodecontent(found_xml_node)
        end
    end
    @info "NOT FOUND: number_of_employees"
    # If none of the Xpath values are found `missing` will be returned
    return missing
end

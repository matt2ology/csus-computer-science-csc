# Homework XML To Matrix

- [Homework XML To Matrix](#homework-xml-to-matrix)
  - [FOLDER STRUCTURE](#folder-structure)
  - [Assignment](#assignment)
    - [Your program should do the following](#your-program-should-do-the-following)
    - [Run your program, and report the following](#run-your-program-and-report-the-following)
  - [References](#references)
  - [Script](#script)

---

## FOLDER STRUCTURE

    D:.
    |   assingment10_solution.jl
    |   h-xml-to-matrix-submission.md
    |   Introduction Natural Language Processing - Clark Fitzgerald.pdf
    |   README.md
    |
    +---.vscode
    |       settings.json
    |
    +---data
    |   |   2019irs990.zip
    |   |
    |   \---2019
    |       201900079349100000_public.xml
    |       201900079349100050_public.xml
    |       201900079349100100_public.xml
    |       ⋮
    |       201943609349300804_public.xml
    |       201943609349300809_public.xml
    |       201943609349300904_public.xml
    |
    \---example
            201900079349100000_public.xml
            990_from_class_example.jl
            example_a.jl
            example_b.jl
            example_c.jl
            example_d.jl

---

## Assignment

Use NLP, Natural Language Processing, to convert the text descriptions of each
nonprofit into the rows of one big document term matrix. The resulting matrix
will have one row for every 990 form that has a description, and one column for
every word in the lexicon. In the next assignment we will use this matrix to
cluster the nonprofits based on their descriptions.

### Your program should do the following

1. Extract the organization name, one or more text elements that describe the
   nonprofit, and another element that can be used as a proxy for size, such as
   revenue, number of employees, etc.

   1. **Organization Name**
      1. Variable Name: `BsnssNm_BsnssNmLn1Txt`
         1. Variable Table: returnheader990x_part_i [ Schedule Part ]
         2. Line Number:
         3. Description: Business name line 1
         4. Type: String(length=75)
         5. **Xpath**: `//ReturnHeader/Filer/BusinessName/BusinessNameLine1Txt`
         6. Reference: <http://www.irsx.info/metadata/parts/returnheader990x_part_i.html>
      2. Variable Name: `DngBsnssAsNm_BsnssNmLn1Txt`
         1. Variable Table: part_0 [ Schedule Part ]
         2. Line Number: C
         3. Description: Doing business as; Business name line 1
         4. Type: String(length=75)
         5. **Xpath**: `//IRS990/DoingBusinessAsName/BusinessNameLine1Txt`
         6. Reference: <http://www.irsx.info/metadata/parts/part_0.html>
   2. **Nonprofit Description**\
      Other values have priority over "_SEE SCHEDULE O._" if nothing at all return "_N/A_"
      1. Variable Name: `ActvtyOrMssnDsc`
         1. Variable Table: part_i [ Schedule Part ]
         2. Line Number: Part I Line 1
         3. Description: Activity or mission description
         4. Type: Text
         5. **Xpath**: `//IRS990/ActivityOrMissionDesc`
         6. Reference: <http://www.irsx.info/metadata/parts/part_i.html>
      2. Variable Name: `Dsc`
         1. Variable Table: part_iii [ Schedule Part ]
         2. Line Number: Part III Line 4a
         3. Description: Description
         4. Type: Text
         5. **Xpath**: `//IRS990/Desc`
         6. Reference: <http://www.irsx.info/metadata/parts/part_iii.html>
      3. Variable Name: `DscrptnPrgrmSrvcAccmTxt`
         1. Variable Table: EZPrgrmSrvcAccmplshmnt [ Repeating Group - IRS990EZ]
         2. Line Number: Part III Line (28-31); Part III
         3. Description: Program service accomplishment; Description of program service accomplishments
         4. Type: Text
         5. **Xpath**: `//IRS990EZ/ProgramSrvcAccomplishmentGrp/DescriptionProgramSrvcAccomTxt`
         6. Reference: <http://www.irsx.info/metadata/groups/EZPrgrmSrvcAccmplshmnt.html>
   3. **Revenue** (proxy for size)
      1. Variable Name: `RvnAmt`
         1. Variable Table: part_iii [ Schedule Part ]
         2. Line Number: Part III Line 4a
         3. Description: Revenue
         4. Type: BigInteger
         5. **Xpath**: `//IRS990/RevenueAmt`
         6. Reference: <http://www.irsx.info/metadata/parts/part_iii.html>
      2. Variable Name: `TtlRvn_TtlRvnClmnAmt`
         1. Variable Table: part_viii [ Schedule Part ]
         2. Line Number: Part VIII Line 12; Part VIII Column (A)
         3. Description: Total Revenue; Total revenue
         4. Type: BigInteger
         5. **Xpath**: `//IRS990/TotalRevenueGrp/TotalRevenueColumnAmt`
         6. Reference: <http://www.irsx.info/metadata/parts/part_viii.html>
   4. **Number of Employees** (proxy for size)
      1. Variable Name: `EmplyCnt`
         1. Variable Table: part_v [ Schedule Part ]
         2. Line Number: Part V Line 2a
         3. Description: Number of employees
         4. Type: Integer
         5. **Xpath**: `//IRS990/EmployeeCnt`
         6. Reference: <http://www.irsx.info/metadata/parts/part_v.html>
      2. Variable Name: `TtlVlntrsCnt`
         1. Variable Table: part_i [ Schedule Part ]
         2. Line Number: Part I Line 6
         3. Description: Total number volunteers
         4. Type: BigInteger
         5. **Xpath**: `//IRS990/TotalVolunteersCnt`
         6. Reference: <http://www.irsx.info/metadata/parts/part_i.html>

   ```julia
   # Grab file
   xml_file = "sample-data/2019-sample/201900079349300005_public.xml"
   xpath = "//IRS990/MissionDesc"
   # Read the file into a document
   xml_document = readxml(xml_file)
   # Find first instance of Xpath with XML tags
   xml_node = findfirst("xpath",xml_document)
   # with `/text()` it removes XML tags
   # xpath_text = "//IRS990/MissionDesc/text()"
   # xml_node = findfirst("//IRS990/MissionDesc/text()",xml_document)
   """
   XML node is given rather than text contained in the node what is given is
   the XML node meaning that entire XML document continues to exist in memory,
   which will use up all the memory, even if you have an instance with 32 GB of memory.
   """
   xml_node_content = nodecontent(xml_node)
   ```

2. Process the text descriptions using a similar process as [described in class](Introduction%20Natural%20Language%20Processing%20-%20Clark%20Fitzgerald.pdf).

   ```julia
   @info "Processing description text"
   description = [entry["organization_description"] for entry in dictionary_of_xml_node_text]

   string_test = [StringDocument(" ")]
   collection_of_files_processed = collect(Int, size(IRS990_2019_FILES))
   for file in 1:collection_of_files_processed[1]
       push!(string_test, StringDocument(description[file]))
   end

   println("The total number of processed description text: ", collection_of_files_processed[1])
   ```

3. Create and save the term document matrix.

### Run your program, and report the following

1. How many of the returns were you able to process?
   > test
2. Show one explicit example of how you processed the text.
   What was the input and output?
   > test
3. What are the dimensions of your term document matrix?
   > test
4. How long did your program take to run? (It should be less than half an hour,
   but no problem if it takes longer, either.)
   > test
5. Which part of the program took the longest?
   > test

## References

- [Installing, updating, and uninstalling the AWS CLI version 2 on Linux](https://docs.aws.amazon.com/cli/latest/userguide/install-cliv2-linux.html)
- [JuliaIO/EzXML - XML/HTML handling tools for primates](https://juliahub.com/ui/Packages/EzXML/Hh8vo/1.1.0)
  - Install EzXML.jl as follows:
    > julia -e 'using Pkg; Pkg.add("EzXML")'
- [XPath Syntax](https://www.w3schools.com/xml/xpath_syntax.asp)
- [Search for files in a folder](https://stackoverflow.com/questions/20484581/search-for-files-in-a-folder)
- [Julia: OOP or not](https://stackoverflow.com/questions/33755737/julia-oop-or-not#:~:text=Julia%20is%20not%20object%2Doriented,very%20similar%20to%20objects%20though.&text=So%20you%20can%20do%20a,distinctly%20different%20than%20OOP%20languages.)
  - SO FUSTRATING THIS ASSIGNMENT WOULD BE A LOT EASIER IF I CAN UTILIZE  
    POLYMORPHISM
- [Class demonstration](990_from_class_example.jl)
  - If you assign/return `findfirst("//Desc/text()", doc)` the XML node is given.
    So, rather than text contained in the node what is given is the XML node
    meaning that entire XML document continues to exist in memory, which will
    use up all the memory, even if you have an instance with 32 GB of memory.
    - The way to fix this is to return only
      `nodecontent(findfirst("//Desc/text()", doc))`
- [rofinn/FilePaths ](https://juliahub.com/ui/Packages/FilePaths/PrU4O/0.8.2)
  - A type based approach to working with filesystem paths in julia
- [About IRSx.info](http://www.irsx.info/metadata/forms.html)
  - This project was originally built for ProPublica, an independent, nonprofit
    newsroom that runs NonProfit Explorer, a database of nonprofit organizations,
    their tax returns, and federal audits of them when available.
- [Form 990 - Return of Organization Exempt From Income Tax](https://www.irs.gov/pub/irs-pdf/f990.pdf)
  - 2020 IRS Form 990

## Script

```julia
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
        @info "xpath" xpath
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
        @info "xpath" xpath
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
        @info "xpath" xpath
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
        @info "xpath" xpath
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
    prepare!(CORPUS,strip_punctuation)
    stem!(CORPUS)
    standardize!(CORPUS, StringDocument)
    update_lexicon!(CORPUS)
    document_term_matrix = DocumentTermMatrix(CORPUS)
    serialize("corpus.jldata", CORPUS)
end

if abspath(PROGRAM_FILE) == @__FILE__
    main()
end
```

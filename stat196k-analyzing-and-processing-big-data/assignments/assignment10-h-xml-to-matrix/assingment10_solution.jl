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
    println(getcontent3("example/201900079349100000_public.xml", "//Desc/text()"))

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
    get_BsnssNm_BsnssNmLn1Txt(xmlfile)
Try several Xpaths strings and returns one; otherwise, missing.
    Xpath: //ReturnHeader/Filer/BusinessName/BusinessNameLine1Txt\n
Returns: Business name line 1
"""
function get_BsnssNm_BsnssNmLn1Txt(xmlfile)
    @info "Fetching Business name line 1"
    xml_document = readxml(xmlfile)
    xml_node_found = findfirst("//ReturnHeader/Filer/BusinessName/BusinessNameLine1Txt", xml_document)
    if isnothing(xml_node_found)
        @info "Business name line 1 NOT FOUND"
        BsnssNm_BsnssNmLn1Txt = "N/A"
    else
        BsnssNm_BsnssNmLn1Txt = nodecontent(xml_node_found)
        @info "FOUND: " BsnssNm_BsnssNmLn1Txt
    end
    return BsnssNm_BsnssNmLn1Txt
end

"""
    get_DngBsnssAsNm_BsnssNmLn1Txt(xmlfile)
Try several Xpaths strings and returns one; otherwise, missing.
    Xpath: //IRS990/DoingBusinessAsName/BusinessNameLine1Txt\n
Returns: Doing business as; Business name line 1
"""
function get_DngBsnssAsNm_BsnssNmLn1Txt(xmlfile)
    @info "Fetching Doing business as; Business name line 1"
    xml_document = readxml(xmlfile)
    xml_node_found = findfirst("//IRS990/DoingBusinessAsName/BusinessNameLine1Txt", xml_document)
    if isnothing(xml_node_found)
        @info "Doing business as; Business name line 1 NOT FOUND"
        DngBsnssAsNm_BsnssNmLn1Txt = "N/A"
    else
        DngBsnssAsNm_BsnssNmLn1Txt = nodecontent(xml_node_found)
        @info "FOUND: "  DngBsnssAsNm_BsnssNmLn1Txt
    end
    return DngBsnssAsNm_BsnssNmLn1Txt
end

"""
    get_ActvtyOrMssnDsc(xmlfile)
Try several Xpaths strings and returns one; otherwise, missing.
    Xpath: //IRS990/ActivityOrMissionDesc\n
Returns: Activity or mission description
"""
function get_ActvtyOrMssnDsc(xmlfile)
    @info "Fetching Activity or mission description"
    xml_document = readxml(xmlfile)
    xml_node_found = findfirst("//IRS990/ActivityOrMissionDesc", xml_document)
    if isnothing(xml_node_found)
        @info "Activity or mission description NOT FOUND"
        ActvtyOrMssnDsc = "N/A"
    else
        ActvtyOrMssnDsc = nodecontent(xml_node_found)
        @info "FOUND: "  ActvtyOrMssnDsc
    end
    return ActvtyOrMssnDsc
end

"""
    get_Dsc(xmlfile)
Try several Xpaths strings and returns one; otherwise, missing.
    Xpath: //IRS990/Desc\n
Returns: Description
"""
function get_Dsc(xmlfile)
    @info "Fetching Description"
    xml_document = readxml(xmlfile)
    xml_node_found = findfirst("//IRS990/Desc", xml_document)
    if isnothing(xml_node_found)
        @info "Description NOT FOUND"
        Dsc = "N/A"
    else
        Dsc = nodecontent(xml_node_found)
        @info "FOUND: " Dscfo
    end
    return Dsc
end

"""
    get_RvnAmt(xmlfile)
Try several Xpaths strings and returns one; otherwise, missing.
    Xpath: //IRS990/RevenueAmt\n
Returns: Revenue
"""
function get_RvnAmt(xmlfile)
    @info "Fetching Revenue"
    xml_document = readxml(xmlfile)
    xml_node_found = findfirst("//IRS990/RevenueAmt", xml_document)
    if isnothing(xml_node_found)
        @info "Revenue NOT FOUND"
        RvnAmt = "N/A"
    else
        RvnAmt = nodecontent(xml_node_found)
        @info "FOUND: " RvnAmt
    end
    return RvnAmt
end

"""
    get_TtlRvn_TtlRvnClmnAmt(xmlfile)
Try several Xpaths strings and returns one; otherwise, missing.
    Xpath: //IRS990/TotalRevenueGrp/TotalRevenueColumnAmt\n
Returns: Total Revenue; Total revenue
"""
function get_TtlRvn_TtlRvnClmnAmt(xmlfile)
    @info "Fetching Total Revenue; Total revenue"
    xml_document = readxml(xmlfile)
    xml_node_found = findfirst("//IRS990/TotalRevenueGrp/TotalRevenueColumnAmt", xml_document)
    if isnothing(xml_node_found)
        @info "Total Revenue; Total revenue NOT FOUND"
        TtlRvn_TtlRvnClmnAmt = "N/A"
    else
        TtlRvn_TtlRvnClmnAmt = nodecontent(xml_node_found)
        @info "FOUND: "  TtlRvn_TtlRvnClmnAmt
    end
    return TtlRvn_TtlRvnClmnAmt
end

"""
    get_EmplyCnt(xmlfile)
Try several Xpaths strings and returns one; otherwise, missing.
    Xpath: //IRS990/EmployeeCnt\n
Returns: Number of employees
"""
function get_EmplyCnt(xmlfile)
    @info "Fetching Number of employees"
    xml_document = readxml(xmlfile)
    xml_node_found = findfirst("//IRS990/EmployeeCnt", xml_document)
    if isnothing(xml_node_found)
        @info "Number of employees NOT FOUND"
        EmplyCnt = "N/A"
    else
        EmplyCnt = nodecontent(xml_node_found)
        @info "F EmplyCntOUND: "
    end
    return EmplyCnt
end

"""
    get_TtlVlntrsCnt(xmlfile)
Try several Xpaths strings and returns one; otherwise, missing.
    Xpath: //IRS990/TotalVolunteersCnt\n
Returns: Total number volunteers
"""
function get_TtlVlntrsCnt(xmlfile)
    @info "Fetching Total number volunteers"
    xml_document = readxml(xmlfile)
    xml_node_found = findfirst("//IRS990/TotalVolunteersCnt", xml_document)
    if isnothing(xml_node_found)
        @info "Total number volunteers NOT FOUND"
        TtlVlntrsCnt = "N/A"
    else
        TtlVlntrsCnt = nodecontent(xml_node_found)
        @info "FOUND TtlVlntrsCnt: "
    end
    return TtlVlntrsCnt
end

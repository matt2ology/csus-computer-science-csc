using EzXML

"""
    Read an XML file and extract text for a node of interest
"""
function getcontent2(xmlfile, xpath)
    doc = readxml(xmlfile)
    d = findfirst(xpath, doc)
    nodecontent(d)
end

function main()
    file = "201900079349100000_public.xml"
    c2 = getcontent2(file, "//Desc/text()")
end

if abspath(PROGRAM_FILE) == @__FILE__
    main()
end

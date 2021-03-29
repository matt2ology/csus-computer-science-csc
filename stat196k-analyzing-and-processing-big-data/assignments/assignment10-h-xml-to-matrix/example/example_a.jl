using EzXML

"""
    Extract xpath from the doc
"""
function getcontent(doc, xpath)  # <- function signature
    d = findfirst(xpath, doc)
    nodecontent(d)
end

function main()
    file = "201900079349100000_public.xml"
    doc = readxml(file)
    c1 = getcontent(doc, "//Desc/text()")
end

if abspath(PROGRAM_FILE) == @__FILE__
    main()
end

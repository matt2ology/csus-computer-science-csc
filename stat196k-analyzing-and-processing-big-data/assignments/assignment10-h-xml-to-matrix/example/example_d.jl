using EzXML
using Debugger
break_on(:error)

"""
    Read an XML file and extract text for a node of interest
"""
function getcontent3(xmlfile, xpath="//Desc/text()")
    doc = readxml(xmlfile)
    d = findfirst(xpath, doc)
    nodecontent(d)
end

files2019 = readdir("data/2019/", join=true)

# Is this the same error? No.
@run descriptions = map(getcontent3, files2019)

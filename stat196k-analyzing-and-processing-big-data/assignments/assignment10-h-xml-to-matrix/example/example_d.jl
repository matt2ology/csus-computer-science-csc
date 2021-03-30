using EzXML
## using Debugger
## break_on(:error)

"""
    Read an XML file and extract text for a node of interest
"""
function getcontent3(xmlfile, xpath="//Desc/text()")
    doc = readxml(xmlfile)
    d = findfirst(xpath, doc)
    return nodecontent(d)
end

files2019 = readdir("sample-data/2019-sample", join=true)

## @run descriptions = map(getcontent3, files2019)
descriptions = map(getcontent3, files2019)

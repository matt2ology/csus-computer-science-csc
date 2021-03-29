using EzXML
using Debugger
break_on(:error)

function getcontent2(xmlfile, xpath)
    doc = readxml(xmlfile)
    d = findfirst(xpath, doc)
    nodecontent(d)
end

# another option:
# process all the files that we have.

files2019 = readdir("data/2019/", join=true)

# How to process the files? <--
# 
# Will getcontent work directly on these files?
# 123 GO- yes, no, idk

# Goal: apply getcontent2 to all of our files
@run descriptions = map(getcontent2, files2019, "//Desc/text()")

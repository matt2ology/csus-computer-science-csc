using EzXML
## using Debugger
## break_on(:error)

function getcontent2(xmlfile, xpath)
    doc = readxml(xmlfile)
    d = findfirst(xpath, doc)
    nodecontent(d)
end

files2019 = readdir("sample-data/2019-sample/", join=true)
file = "201900079349100000_public.xml"
## @run descriptions = map(getcontent2, files2019, "//Desc/text()")
descriptions = map(getcontent2, file, "//Desc/text()")

@info "example_c.jl" file descriptions
@info "example_c.jl" typeof(file) typeof(descriptions)
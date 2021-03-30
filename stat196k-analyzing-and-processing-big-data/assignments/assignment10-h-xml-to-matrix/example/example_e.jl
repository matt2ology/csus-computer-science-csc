using EzXML

"""
    Read an XML file and extract text for a node of interest
"""
function getcontent4(xmlfile)
    doc = readxml(xmlfile)

    d = findfirst("//Desc/text()", doc)

    # <Description>PROVIDED FOOD, CLOTHING, SHELTER AND EDUCATION FOR HUNDREDS OF HOMELESS WOMEN AND CHILDREN IN AFGHANISTAN</Description>
    if isnothing(d)
        d = findfirst("//Description/text()", doc)
    end

    nodecontent(d)
end

files2019 = readdir("sample-data/2019-sample/", join=true)

descriptions = map(getcontent4, files2019)

@info "example_e.jl" files2019 descriptions
@info "example_e.jl" typeof(files2019) typeof(descriptions)

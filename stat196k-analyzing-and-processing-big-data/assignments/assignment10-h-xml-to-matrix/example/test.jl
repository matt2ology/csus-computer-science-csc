using EzXML
using TextAnalysis
using Serialization

#	Read an XML file and extract text for a node of interest
#	Possibly just add in all the descripters you need in here for each file


function getcontent(xmlFile)
    doc = readxml(xmlFile)
    
    #Org Name
    orgName = findfirst("//BusinessNameLine1Txt", doc)
    
    #Num of Employees or Revenue
    size = findfirst("//TotalRevenueAmt",doc)
    if isnothing(size)
        size = findfirst("//CYTotalRevenueAmt", doc)
    end    
    
    
    
    # Mission statement/Description
    d = findfirst("//Desc", doc)
    if isnothing(d)
        d = findfirst("//Description", doc)
    end
    
    if isnothing(d)
        d = findfirst("//MissionDesc", doc)
    end
    
    if isnothing(d)
        d = findfirst("//DescriptionProgramSrvcAccomTxt", doc)
    end
    
	
	if !isnothing(orgName)
		orgName = nodecontent(orgName)
	end
	if isnothing(orgName)
		orgName = "Org Name not found"
	end 
	
	
	if !isnothing(size)
		size = nodecontent(size)
	end
	if isnothing(size)
		size = "size not found"
	end 
	
	
	if !isnothing(d)
		d = nodecontent(d)
	end
	if isnothing(d)
		d = "Mission Statement not found"
	end 
	
	
    Dict("file"=>xmlFile, "org"=>orgName, "mission"=>d, "sizeProxy"=>size)
end

files2019 = readdir("sample-data/2019-sample", join=true)

# When this is done, the dictionary will be filled to be processed
# Getting all text from files into Dict
dictionaryOfXMLtext = Dict()
@time dictionaryOfXMLtext = map(getcontent, files2019)



# Return all missions to be able to process
m = [x["mission"] for x in dictionaryOfXMLtext]

testStrings = [StringDocument(" ")]
x = collect(Int, size(files2019))
for i in 1:x[1]
    push!(testStrings,  StringDocument( m[i] )  )
end    

println("The count of how many were processed was: ", x[1])

c = Corpus(testStrings)
remove_case!(c)
prepare!(c,strip_punctuation)
stem!(c)
standardize!(c, StringDocument)
update_lexicon!(c)
d = DocumentTermMatrix(c)
serialize("corpus.jldata", c)


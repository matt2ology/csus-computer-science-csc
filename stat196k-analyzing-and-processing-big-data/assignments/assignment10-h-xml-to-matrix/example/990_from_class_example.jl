# Skills:
# 
# designing functions
# debugging
# 
# Notes: 
# http://webpages.csus.edu/fitzgerald/julia-debugger-tutorial/
# 
# 
# Side note: for interview:
# Make sure you have ready answers for these questions:
# 
# Prepare like 5 or so examples in your head.
# 
# 1. Why do you want to come / work here?
# 2. What does your development process look like when analyzing data?
# 3. Tell us about a time you failed.
# 4. 
# 
# What does your development process look like when analyzing data?
# For example:
# 
# How do you write code?
# When do you write a function?
# How do you write a function?
# What do you do when you encounter an error?
# 
# 
# 
# Debuggers save you time, and improve your mental model of the language.


using EzXML

"""
    Extract xpath from the doc
"""
function getcontent(doc, xpath)  # <- function signature
    d = findfirst(xpath, doc)
    nodecontent(d)
end

f = "2019irs990/201932259349302043_public.xml"

doc = readxml(f)

c1 = getcontent(doc, "//Desc/text()")


"""
    Read an XML file and extract text for a node of interest
"""
function getcontent2(xmlfile, xpath)
    doc = readxml(xmlfile)
    d = findfirst(xpath, doc)
    nodecontent(d)
end

c2 = getcontent2(f, "//Desc/text()")


# another option:
# process all the files that we have.

files2019 = readdir("2019irs990/", join=true)

# How to process the files? <--
# 
# Will getcontent work directly on these files?
# 123 GO- yes, no, idk

using Debugger

break_on(:error)

# Goal: apply getcontent2 to all of our files
@run descriptions = map(getcontent2, files2019, "//Desc/text()")

# 123 GO: which variables are local to this function call?
# fr:
# xmlfile
# xpath
# doc
# 
# 

"""
    Read an XML file and extract text for a node of interest
"""
function getcontent3(xmlfile, xpath="//Desc/text()")
    doc = readxml(xmlfile)
    d = findfirst(xpath, doc)
    nodecontent(d)
end


# Is this the same error? No.
@run descriptions = map(getcontent3, files2019)


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


@run descriptions = map(getcontent4, files2019)

descriptions = map(getcontent4, files2019)
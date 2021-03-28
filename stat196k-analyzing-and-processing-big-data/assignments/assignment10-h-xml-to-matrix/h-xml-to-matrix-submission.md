# Homework XML To Matrix

- [Homework XML To Matrix](#homework-xml-to-matrix)
  - [FOLDER STRUCTURE](#folder-structure)
  - [Assignment](#assignment)
    - [Your program should do the following](#your-program-should-do-the-following)
    - [Run your program, and report the following](#run-your-program-and-report-the-following)
  - [References](#references)

---

## FOLDER STRUCTURE

    D:.
    |   h-xml-to-matrix-submission.md
    |   Introduction Natural Language Processing - Clark Fitzgerald.pdf
    |   README.md
    |
    \---data
        |   2019irs990.zip
        |
        \---2019
                201900079349100000_public.xml
                201900079349100050_public.xml
                201900079349100100_public.xml
                ⋮
                201943609349300804_public.xml
                201943609349300809_public.xml
                201943609349300904_public.xml

---

## Assignment

Use NLP, Natural Language Processing, to convert the text descriptions of each
nonprofit into the rows of one big document term matrix. The resulting matrix
will have one row for every 990 form that has a description, and one column for
every word in the lexicon. In the next assignment we will use this matrix to
cluster the nonprofits based on their descriptions.

### Your program should do the following

1. Extract the organization name, one or more text elements that describe the
   nonprofit, and another element that can be used as a proxy for size, such as
   revenue, number of employees, etc.

   1. Organization name
      1. `<BusinessName>`
   2. Nonprofit description
   3. Revenue
   4. Number of employees

2. Process the text descriptions using a similar process as [described in class](Introduction%20Natural%20Language%20Processing%20-%20Clark%20Fitzgerald.pdf).
3. Create and save the term document matrix.

### Run your program, and report the following

1. How many of the returns were you able to process?
2. Show one explicit example of how you processed the text.
   What was the input and output?
3. What are the dimensions of your term document matrix?
4. How long did your program take to run? (It should be less than half an hour,
   but no problem if it takes longer, either.)
5. Which part of the program took the longest?

## References

- [Installing, updating, and uninstalling the AWS CLI version 2 on Linux](https://docs.aws.amazon.com/cli/latest/userguide/install-cliv2-linux.html)
- [JuliaIO/EzXML - XML/HTML handling tools for primates](https://juliahub.com/ui/Packages/EzXML/Hh8vo/1.1.0)
  - Install EzXML.jl as follows:
    > julia -e 'using Pkg; Pkg.add("EzXML")'
- [XPath Syntax](https://www.w3schools.com/xml/xpath_syntax.asp)
- [Search for files in a folder](https://stackoverflow.com/questions/20484581/search-for-files-in-a-folder)
- [Julia: OOP or not](https://stackoverflow.com/questions/33755737/julia-oop-or-not#:~:text=Julia%20is%20not%20object%2Doriented,very%20similar%20to%20objects%20though.&text=So%20you%20can%20do%20a,distinctly%20different%20than%20OOP%20languages.)
  - SO FUSTRATING THIS ASSIGNMENT WOULD BE A LOT EASIER IF I CAN UTILIZE  
    POLYMORPHISM
- [Class demonstration](990_from_class_example.jl)
  - If you assign/return `findfirst("//Desc/text()", doc)` the XML node is given.
    So, rather than text contained in the node what is given is the XML node
    meaning that entire XML document continues to exist in memory, which will
    use up all the memory, even if you have an instance with 32 GB of memory.
    - The way to fix this is to return only
      `nodecontent(findfirst("//Desc/text()", doc))`
- [rofinn/FilePaths ](https://juliahub.com/ui/Packages/FilePaths/PrU4O/0.8.2)
  - A type based approach to working with filesystem paths in julia
- [About IRSx.info](http://www.irsx.info/metadata/forms.html)
  - This project was originally built for ProPublica, an independent, nonprofit
    newsroom that runs NonProfit Explorer, a database of nonprofit organizations,
    their tax returns, and federal audits of them when available.

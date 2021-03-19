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

1. Extract the organization name, one or more text elements that describe the nonprofit, and another element that can be used as a proxy for size, such as revenue, number of employees, etc.
   1. Organization name `<BusinessName>`
   2. Nonprofit description

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

- [JuliaIO/EzXML - XML/HTML handling tools for primates](https://juliahub.com/ui/Packages/EzXML/Hh8vo/1.1.0)
  - Install EzXML.jl as follows:
    > julia -e 'using Pkg; Pkg.add("EzXML")'
- [XPath Syntax](https://www.w3schools.com/xml/xpath_syntax.asp)
- [Search for files in a folder](https://stackoverflow.com/questions/20484581/search-for-files-in-a-folder)

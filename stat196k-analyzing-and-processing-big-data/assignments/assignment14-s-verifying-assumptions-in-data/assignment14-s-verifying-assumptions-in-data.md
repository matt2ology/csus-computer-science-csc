# Assignment 14 - Skill - verifying assumptions in data

**Due** Tuesday by 11:59pm | **Points** 5 | **Submitting** a text entry box

- [Assignment 14 - Skill - verifying assumptions in data](#assignment-14---skill---verifying-assumptions-in-data)
  - [Code](#code)
  - [Output](#output)
  - [References](#references)

Verify the correspondence between `irs990extract`, `terms`, and `termfreq` described in the [clustering homework](./assignment15-h-clustering.md) by picking a random index from irs990extract and checking that the terms in termfreq are actually in the corresponding mission description.

Turn in code with output from the Julia REPL demonstrating this. Each student should have a different example.

---

## Code

```julia
using Serialization
function main()
    irs990extract = Serialization.deserialize("./data/irs990extract.jldata")
    termfreq = Serialization.deserialize("./data/termfreq.jldata")
    terms = Serialization.deserialize("./data/terms.jldata")
    
    @info "" length(irs990extract) size(termfreq) length(terms)
    println() # Blank lines for white space between outputs
    
    println(join(terms[termfreq[55, 1:end].nzind]," "))
    println() # Blank lines for white space between outputs
    println(lowercase(irs990extract[55]["mission"]))
end # end main()

if abspath(PROGRAM_FILE) == @__FILE__
    main()
end
```

## Output

> `println(join(terms[termfreq[55, 1:end].nzind]," "))`

accid acitiv activ among and ani area auto better breast cancer canceraid care clot combinedit control day deep determin die dvt effort emboli ever exact format foundat from given hematolog increas investig is may mechan of oncolog patholog patientsmor pe peon peopl perform plan prevent problem pulmonari select size studi support surgic than that the thrombosi thrombus thru to understand various venous what

> `println(lowercase(irs990extract[55]["mission"]))`


the foundation performs deep studies of selected areas of oncology and
hematological investigation and care. the foundation supports efforts to better
understand the mechanism and prevention of the ever increasing problem of
pathological venous thrombosis (dvt) and pulmonary emboli (pe) among cancer and
surgical patients.more people die from pe than from breast cancer,aids and auto
accidents combined.it is the foundation plan to determine thru various activities
the exact mechanisms that acitivates the formation of the pathological thrombus
(pe)on any given day and what may control the size of the clot.


## References

- [versions of julia used to serialize and deserialize are not the same](https://discourse.julialang.org/t/argumenterror-array-must-be-non-empty-while-calling-serialization-deserialize-f-function/28508/2)
- [How to install “official” release of Julia in your WSL](https://olejorik.github.io/post/juliawsl/)

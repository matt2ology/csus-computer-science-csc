function main()
    # do stuff
end

#= 
When a file is run as the main script using julia file.jl one might want to 
activate extra functionality like command line argument handling. A way to 
determine that a file is run in this fashion is to check 
if abspath(PROGRAM_FILE) == @__FILE__ is true.
---
https://docs.julialang.org/en/v1/manual/faq/#How-do-I-check-if-the-current-file-is-being-run-as-the-main-script?
=#
if abspath(PROGRAM_FILE) == @__FILE__
    main()
end
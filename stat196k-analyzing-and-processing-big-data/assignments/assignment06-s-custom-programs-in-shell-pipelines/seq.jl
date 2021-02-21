###############################################################################
# assignment06-exercise #######################################################
###############################################################################
# Exercise
# Modify the above Julia program to create a script / command line program that
# behaves like seq when used with one argument
# $ seq 3
# 1
# 2
# 3
###############################################################################
# script usage ################################################################
###############################################################################
# Call your file seq.jl and verify it behaves as follows 
# (for any positive integer, not just 4):
# $ seq 3 | seq.jl 4
# 1
# 2
# 3
# 4
###############################################################################

"""
    count_number_of_lines_piped_in()

**Returns** number of lines piped into script as type `int`
# Examples
```julia-repl
    1. \$ seq 5 | seq.jl
    # 5
    2. \$ seq 42 | seq.jl
    # 42
    3. \$ seq 9001 | seq.jl
    # 9001
```
"""
function count_number_of_lines_piped_in()
    lineCount = 0
    for line in eachline()
        lineCount += 1
    end
    return lineCount
end

"""
    get_user_argument_number()

**Returns** the numbered argument for script as type `int`
# Examples
```julia-repl
    1. \$ seq.jl 4
    # 4
    2. \$ seq.jl 20
    # 20
    3. \$ seq.jl 9001
    # 9001
```
"""
function get_user_argument_number()
    return parse(Int64, ARGS[1])
end

function main()
    numberOfLines = count_number_of_lines_piped_in()
    @info "Data:" get_user_argument_number() typeof(get_user_argument_number()) numberOfLines typeof(numberOfLines)
    for number in collect(1:get_user_argument_number())
        println(number)
    end
end

if abspath(PROGRAM_FILE) == @__FILE__
    main()
end
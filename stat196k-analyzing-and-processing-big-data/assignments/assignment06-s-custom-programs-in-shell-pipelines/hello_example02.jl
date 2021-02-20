# Example02 usage:
#
# $ seq 3 | julia hello_example02.jl bye
# hello 1 bye
# hello 2 bye
# hello 3 bye


function greet(x, after = "")
    println("hello " * x * " " * after)
end


# Process stdin
function main()
    user_after = ARGS[1]
    for line in eachline()
        greet(line, user_after)
    end
end


if abspath(PROGRAM_FILE) == @__FILE__
    main()
end
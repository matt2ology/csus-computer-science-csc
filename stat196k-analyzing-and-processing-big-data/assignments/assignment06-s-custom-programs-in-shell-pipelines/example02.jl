# Example usage:
#
# $ seq 3 | julia hello2.jl bye
# hello 1bye
# hello 2bye
# hello 3bye


function greet(x, after = "")
    println("hello " * x * after)
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
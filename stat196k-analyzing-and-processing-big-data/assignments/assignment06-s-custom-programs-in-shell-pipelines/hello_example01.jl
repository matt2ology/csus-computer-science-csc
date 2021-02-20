# Example01 usage:
#
# $ seq 3 | julia hello_example01.jl
# hello 1
# hello 2
# hello 3


"""
    greet(x)

Greet `x` with a hello.
"""
function greet(x)
    println("hello " * x)
end


# Process stdin
for line in eachline()
    greet(line)
end
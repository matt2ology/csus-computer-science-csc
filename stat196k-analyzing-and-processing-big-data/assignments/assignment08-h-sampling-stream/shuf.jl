using Logging

"""
    shuf.jl
works for the following cases:

```julia-repl
\$ seq 10 | julia shuf.jl
# shuffles the integers from 1 to 10
\$ seq 10 | shuf | julia shuf.jl
# shuffles the integers from 1 to 10
\$ seq 100 | julia shuf.jl 20
# samples 20 random integers without replacement from 1 to 100
\$ seq 1000 | julia shuf.jl
# samples 100 random integers without replacement from 1 to 1000
\$ seq -f "%.0f" 1e7 | julia shuf.jl
# samples 100 random integers without replacement from 1 to 10 million
```
New test cases :
```bash
\$ time seq 1e9 | julia shuf.jl samples 100 integers from 1 to 1 billion
```
"""

function reservoir_sample_simple(inputStream, reservoir_size=100)
    reservoirArray = Any[]
    # fill the reservoir array
    for line in eachline(inputStream)
        push!(reservoirArray, line)
    end
    return reservoirArray
end

function main()
    for element in reservoir_sample_simple(stdin)
        println(element)
    end
end

if abspath(PROGRAM_FILE) == @__FILE__
    main()
end

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
$ time seq 1e9 | julia shuf.jl samples 100 integers from 1 to 1 billion
```
"""

function reservoir_sample_simple()
    reservoirArray = [] # 0-element Array{Int64,1}
    resultArray = [] # 0-element Array{Int64,1}
    # fill the reservoir array
    for line in eachline()
        push!(reservoirArray, line)
        @info "Data streamed-in " * line, reservoirArray
    end
    lengthOfReservoirArray = length(reservoirArray)
    count = lengthOfReservoirArray + 1
    @info "Data: " lengthOfReservoirArray random_index
    # replace elements with gradually decreasing probability
    
end

function reservoir_sample_simple02(stream, size=100)
    sample = Array{eltype(stream)}(size)
    for i in 1:size
        sample[i] = splice!(stream, rand(eachindex(stream)))
    end
    return sample
end

function main()
    println(reservoir_sample_simple02(stdin))
    
end

if abspath(PROGRAM_FILE) == @__FILE__
    main()
end

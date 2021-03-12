using Logging
using ArgParse
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

function get_user_sample_size()
    return parse(Int, ARGS[1])
end

# Separate function into something that works on any data stream
function reservoir_sample_simple(stream_of_inputs, reservoir_size=100)
    numberOfLines = 0

    reservoirArray = Any[zeros(Int,1,reservoir_size)]

    @info reservoirArray size(reservoirArray)
    # fill the reservoir array
    for (index,line) in eachline(stream_of_inputs)
        if index <= reservoir_size
            #push!(reservoirArray, line)
            numberOfLines += 1
        else
            break
        end
    end
    println(length(reservoirArray))
    # replace elements with gradually decreasing probability
    ## i = 0
    ## for element in reservoirArray
    ##     randomNumber = rand(1:length(reservoirArray))
    ##     if randomNumber < numberOfLines
    ##         push!(resultArray, element)
    ##     end
    ## end
    ## return resultArray
end

function main()
    try
        reservoir_sample_simple(stdin,get_user_argument_number())
    catch 
        reservoir_sample_simple(stdin)
    end
    #for element in reservoir_sample_simple(stdin)
    #    println(element)
    #end
    # reservoir_sample_simple(stdin)
end

if abspath(PROGRAM_FILE) == @__FILE__
    main()
end


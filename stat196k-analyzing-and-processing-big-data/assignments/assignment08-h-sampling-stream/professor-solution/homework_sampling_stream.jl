# Homework Sampling Stream
# http://webpages.csus.edu/fitzgerald/homework-sampling-stream/
# These are Dr. Clark Fitzgerald brief sketches of the core parts of each assignment.
import Random

"""
    reservoir_sample(stream,  n)
"""
function reservoir_sample(stream,  n)
    sample = fill("", n)
    count = 0
    for line in stream
        count += 1
        if count <= n
            sample[count] = line
        else
            random_index = rand(1:count)
            if random_index <= n
                sample[random_index] = line
            end
        end
    end
    if count < n
        # Not enough input to fill the array
        sample = sample[1:count]
    end
    Random.shuffle!(sample)
end


function main()
    if 0 < length(ARGS)
        n = parse(Int, ARGS[1])
    else
        n = 100
    end
    sample = reservoir_sample(eachline(stdin), n)
    for line in sample
        println(line)
    end
end


if abspath(PROGRAM_FILE) == @__FILE__
    main()
end
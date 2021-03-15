using Random
using Distributions
using StatsPlots
# A utility function
# to print an array
function printArray(stream,n)
    for i in 1:n
        print(stream[i])
        print(" ")
       end
    println() # new line
end

# A function to randomly select
# k items from stream[0..n-1].
function selectKItems(stream, n, k)
        index=1
        reservoir = zeros(Int64,k)
        for index in 1:k
            reservoir[index] = stream[index]
        end
        # Iterate from the (k+1)th
        # element to nth element
        for index in (k+1):n
            # while(index < n)
            # Pick a random index
            # from 0 to i.
            j = rand(1:index)
            if(j <= k)
                reservoir[j] = stream[index]
            index=index+1
        end
    end
        reservoir = shuffle!(reservoir)
        print("Following are k randomly selected items ")
        printArray(reservoir, k)
        x = reservoir
        y = Uniform(1,n)
        qqplot(x,y)
        savefig("qqplot.png")
    end
# Driver Code

function main()

    stream = Int64[]
   for line in eachline(stdin)
       push!(stream,parse(Int64,line)) # append new val to stream array, coverting vals
   end
    # stream = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
    # where n is the size of the stream
    n = size(stream,1)
    # where k is the size of the reservoir
    #k = 5 # FIX THIS! need to check if we are getting value from the stream
    if isempty(ARGS)
        k = 7  #default sample size
    else
        k = parse(Int64, ARGS[1])
    end
    selectKItems(stream, n, k)
end
#main()
if abspath(PROGRAM_FILE) == @__FILE__
    # Run the main script
    main()
end

# This code is contributed by mits

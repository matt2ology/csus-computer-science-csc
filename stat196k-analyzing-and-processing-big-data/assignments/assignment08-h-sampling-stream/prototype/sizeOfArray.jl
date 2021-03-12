function example01()
    array = [2,5,8,4]
    i = 0
    for index in array
        i += 1
        println(i * " <-")
    end
end

function example02()
    array = Any[]
    println(length(array))
end

function example03()
    array = Any[zeros(Int,1,5)]
    @info array
    println(length(array))
    for element in array
        println(element)
    end
end

function main()
    example03()
end

if abspath(PROGRAM_FILE) == @__FILE__
    main()
end

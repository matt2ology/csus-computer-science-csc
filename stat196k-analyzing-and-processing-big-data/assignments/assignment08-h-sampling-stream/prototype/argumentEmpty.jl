function get_user_argument_number()
    return parse(Int64, ARGS[1])
    end

function reservoir_sample_simple(inputStream, reservoir_size=100)
    @info reservoir_size
end

function main()

    try
        reservoir_sample_simple(stdin,get_user_argument_number())
    catch 
        reservoir_sample_simple(stdin)
    end
end



if abspath(PROGRAM_FILE) == @__FILE__
    main()
end

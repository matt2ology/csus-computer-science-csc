using Random
function main()
    # Code here
    print(rand(1:5)) # generates rand integers 1-5 inclusive
end

if abspath(PROGRAM_FILE) == @__FILE__
    main()
end

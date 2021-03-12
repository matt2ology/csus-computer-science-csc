using ArgParse

function parse_commandline()
    s = ArgParseSettings()

    @add_arg_table! s begin
        "arg1"
            help = "a positional argument"
            arg_type = Int
            default = 0
    end

    return parse_args(s)
end

function main()
    parsed_args = parse_commandline()
    println("Parsed args:")
    println(parse_args["arg1"])
end

if abspath(PROGRAM_FILE) == @__FILE__
    main()
end

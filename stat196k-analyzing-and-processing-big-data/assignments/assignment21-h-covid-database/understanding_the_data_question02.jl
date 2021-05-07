function main()
    # do stuff
    value = 15.9247137
    p_value = 15.9247137/100
    z_confidence_level_value = 1.959964
    s_sample_standard_deviation = 0.2631875
    n_sample_size = 19329.0
    square_root_of_the_sample_size = 100*sqrt((p_value*(1-p_value))/n_sample_size)
    lower_bound = value-(2*square_root_of_the_sample_size)
    upper_bound = value+(2*square_root_of_the_sample_size)
    println("(",lower_bound, ",", upper_bound,")")
    
end

if abspath(PROGRAM_FILE) == @__FILE__
    main()
end
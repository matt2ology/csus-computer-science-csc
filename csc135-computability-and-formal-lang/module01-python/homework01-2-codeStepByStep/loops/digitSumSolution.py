def digit_sum(int_param):
    result = 0
    list_of_int = [i for i in str(int_param)]
    for i in int(list_of_int):
        result += list_of_int[i]
    return result

def all_less(list_a, list_b):
    if(len(list_a) != len(list_b)):
        return False

    for item in range(len(list_a)):
        if list_a[item] > list_b[item]:
            return False

    return True

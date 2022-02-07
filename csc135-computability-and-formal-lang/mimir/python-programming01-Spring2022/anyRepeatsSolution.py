def any_repeats(string_tuple):
    # Does the list exist
    if not string_tuple:
        return False
    # If length of list matches the set no duplicates present
    elif len(string_tuple) == len(set(string_tuple)):
        return False
    else:
        return True

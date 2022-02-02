def main():
    pass


def has_duplicate_value(dictionary_of_names: dict):
    result = False
    dictionary_of_names_inverse_map = {}

    # convert dictionary values to keys with the inverse mapping
    for key, value in dictionary_of_names.items():
        dictionary_of_names_inverse_map.setdefault(value, set()).add(key)

    # if the length of values is greater than one then the lenght number is added
    # to the list via list comprehension
    # [expression for item in iterable if condition == True]
    number_of_duplicate_values = [
        key for key, values in dictionary_of_names_inverse_map.items() if len(values) > 1]

    # if the duplicate value list exist then we know we have duplicate values
    if number_of_duplicate_values:
        result = True

    return result


if __name__ == "__main__":
    main()

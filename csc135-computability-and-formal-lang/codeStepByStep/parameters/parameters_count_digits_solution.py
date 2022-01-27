def main():
    print(count_digits(38015))
    print(count_digits(-72))


def count_digits(integer_parameter: int) -> int:
    """
    Returns the number of digits in that integer.\n
    For negative numbers, return the same value as if the number were positive.

        Parameters:
                integer_parameter (int): An integer

        Returns:
                integer_length (int): number of digits of integer_parameter
    """
    # Normilize input - make sure all numbers are positive
    positive_integer = abs(integer_parameter)

    integer_length = int(len(str(positive_integer)))

    return integer_length


# Misunderstanding of prompt
def grab_last_digit(integer_parameter: int) -> int:
    """
    Returns the last digits in that integer.\n
    For negative numbers, return last digit as if the number were positive.

        Parameters:
                integer_parameter (int): An integer

        Returns:
                integer_length (int): last digit of integer_parameter
    """
    # Normilize input - make sure all numbers are positive
    positive_integer = abs(integer_parameter)

    # Using list comprehension: Convert number to list of integers
    list_of_positive_integers = [int(index) for index in str(positive_integer)]

    # Grab element by indexing from the end of list
    last_digit_of_number = int((list_of_positive_integers)[-1])

    return last_digit_of_number


if __name__ == "__main__":
    main()

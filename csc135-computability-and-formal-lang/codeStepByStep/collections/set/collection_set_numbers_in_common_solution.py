from enum import unique
from typing import List

from pyparsing import empty


def main():
    # list_B = [-5, 15, 2, -1, 7, 15, 36]
    # list_A = [3, 7, 3, -1, 2, 3, 7, 2, 15, 15]

    list_A = [10, 20, 30, 40, 50]
    list_B = [50, 40, 30, 20, 10]

    list_C = []
    list_of_unique_numbers = []

    for element in list_B:
        if element in list_A:
            list_C.append(element)

    for element in list_C:
        print(element)

    [list_of_unique_numbers.append(
        element) for element in list_C if element not in list_of_unique_numbers]

    for element in list_of_unique_numbers:
        print("list_of_unique_numbers", element)

    print("len:", len(list_of_unique_numbers))


def num_in_common(integer_list_A: List[int], integer_list_B: List[int]) -> int:
    """
    Returns the count of how many unique integers occur in two lists without
    modifying the lists passed in

        Parameters:
            integer_list_A (int): An integer list
            integer_list_B (int): An integer list

        Returns:
            frequency_of_common_numbers (int): the count of how many unique
            integers occur in both lists
    """
    list_of_common_integers = []
    frequency_of_common_numbers = None

    # If either of the lists are empty - they will have no numbers in common
    if not integer_list_A or not integer_list_B:
        frequency_of_common_numbers = 0

    # Place recurring numbers in both lists into a new one (includes duplicates)
    for element in integer_list_A:
        if element in integer_list_B:
            list_of_common_integers.append(element)

    frequency_of_common_numbers = len(list(set(list_of_common_integers)))

    return frequency_of_common_numbers


def num_in_common_version_2(list_A: List[int], list_B: List[int]) -> int:
    return len(list(set(list_A) & set(list_B)))


if __name__ == "__main__":
    main()

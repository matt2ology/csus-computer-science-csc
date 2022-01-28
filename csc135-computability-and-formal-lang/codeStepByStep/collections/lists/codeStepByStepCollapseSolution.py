from itertools import zip_longest


def main():
    # lista = collapse([7, 2, 8, 9, 4, 13, 7, 1, 9, 10])  # [9, 17, 17, 8, 19]

    collapse([1, 2, 3, 4, 5])  # [3, 7, 5]
    #         0  1  2  3  4    1+2, 3+4, 5
    #         0  1  2  3  4    a+b, a+b, 4
    #         0  1  2  3  4    0+1, 2+3, 4


def collapse(integer_list: int) -> int:
    integer_list_summation = []

    return integer_list_summation


def cheat_lazy_collapse(integer_list: int) -> int:
    temp_list_a = []
    temp_list_b = []
    integer_list_summation = []

    if not integer_list:
        integer_list_summation = []

    # Grab offset stepped elements starting at the first element in list
    for element in integer_list[0::2]:
        temp_list_a.append(element)

    # Grab offset stepped elements starting at the second element in list
    for element in integer_list[1::2]:
        temp_list_b.append(element)

    # zip with a list comprehension
    [integer_list_summation.append(sum(element_tuple)) for element_tuple in zip_longest(
        temp_list_a, temp_list_b, fillvalue=0)]

    for element in integer_list_summation:
        print("integer_list_summation:", element)

    return integer_list_summation


if __name__ == "__main__":
    main()

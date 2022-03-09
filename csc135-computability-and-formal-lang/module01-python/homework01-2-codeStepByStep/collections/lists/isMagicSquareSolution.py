def main():
    #           15
    #          /
    #  2  7  6 > 15
    #  9  5  1 > 15
    #  4  3  8 > 15
    #  v  v  v \
    # 15 15 15  15
    pass


def is_magic_square(two_dimensional_list_of_integers):
    result = True
    sum_set = set()

    # is square shape
    number_of_columns = len(two_dimensional_list_of_integers)
    for column in range(number_of_columns):
        if len(two_dimensional_list_of_integers[column]) is not number_of_columns:
            return False

    # sum of the values in the given row
    for row in two_dimensional_list_of_integers:
        sum_of_row = 0
        for column in row:
            sum_of_row += column
        sum_set.add(sum_of_row)

    # sum of the values in the give columns
    for row in range(len(two_dimensional_list_of_integers)):
        sum_of_column = 0
        for column in range(len(two_dimensional_list_of_integers[row])):
            sum_of_column += two_dimensional_list_of_integers[column][row]
        sum_set.add(sum_of_column)

    # sum of the values in the main ("positive") diagonal
    sum_of_positive_slope = 0
    column = len(two_dimensional_list_of_integers) - 1
    for row in range(len(two_dimensional_list_of_integers)):
        sum_of_positive_slope += two_dimensional_list_of_integers[row][column]
        column -= 1
    sum_set.add(sum_of_positive_slope)

    # sum of the values in the other ("negative") diagonal
    sum_of_negative_slope = 0
    column = 0
    for row in range(len(two_dimensional_list_of_integers)):
        sum_of_negative_slope += two_dimensional_list_of_integers[row][column]
        column += 1
    sum_set.add(sum_of_negative_slope)

    if len(sum_set) != 1:
        result = False

    return result


if __name__ == "__main__":
    main()

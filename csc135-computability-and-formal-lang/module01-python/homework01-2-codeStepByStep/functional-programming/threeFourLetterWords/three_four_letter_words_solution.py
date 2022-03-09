def three_four_letter_words(list_of_strings: list[str]) -> list[str]:
    return [element for element in list_of_strings if len(element) == 3 or len(element) == 4]

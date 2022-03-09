from functools import reduce


def glue_reverse_simple_approach(list_of_strings: list[str]) -> str:
    return ''.join(reversed(list_of_strings))


def glue_reverse_silly_version(list_of_strings: list[str]) -> str:
    return str(reduce(lambda x, y: x + y, reversed(list_of_strings)) if list_of_strings else "")


def glue_reverse(list_of_strings: list[str]) -> str:
    return reduce(lambda x, y: x + y, reversed(list_of_strings), "")

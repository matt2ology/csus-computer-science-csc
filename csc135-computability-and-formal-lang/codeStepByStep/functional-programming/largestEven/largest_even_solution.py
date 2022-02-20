def largest_even(list_of_integers: list[int]) -> int:
    return max(list(filter(lambda element: element%2 == 0,list_of_integers)))
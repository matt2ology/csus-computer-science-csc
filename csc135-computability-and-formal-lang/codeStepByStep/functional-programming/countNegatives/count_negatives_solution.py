class CountNegatives:
    def count_negatives(list_of_integers: list[int]) -> int:
        return len(list(filter(lambda x: x < 0, list_of_integers)))
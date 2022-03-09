class CountNegatives:
    def count_negatives(list_of_integers: list[int]) -> int:
        """
        Takes a list of integers as a parameter\n
        Returns: how many numbers in the list are negative\n
        Example:
        [5, -1, -3, 20, 47, -10, -8, -4, 0, -6, -6] returns 7
        """
        return len(list(filter(lambda x: x < 0, list_of_integers)))
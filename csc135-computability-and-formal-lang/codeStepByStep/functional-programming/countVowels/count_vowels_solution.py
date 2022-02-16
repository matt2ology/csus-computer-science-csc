class CountVowels:
    def count_vowels(given_string: str) -> int:
        vowels = "AEIOU"
        return len(list(filter(lambda letter: letter in vowels, given_string.upper())))

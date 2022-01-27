import parameters_count_digits_solution as soln

def test_count_digits_38015():
    assert soln.count_digits(38015) == 5


def test_count_digits_neg_72():
    assert soln.count_digits(-72) == 2


def test_count_digits_29107():
    soln.count_digits(29107) == 5


def test_count_digits_456():
    soln.count_digits(456) == 3


def test_count_digits_9999999():
    soln.count_digits(9999999) == 7


def test_count_digits_48():
    soln.count_digits(48) == 2


def test_count_digits_120011021():
    soln.count_digits(120011021) == 9


def test_count_digits_2000000000():
    soln.count_digits(2000000000) == 10


def test_count_digits_5():
    soln.count_digits(5) == 1


def test_count_digits_neg_3():
    soln.count_digits(-3) == 1


def test_count_digits_neg_15():
    soln.count_digits(-15) == 2


def test_count_digits_neg_29107():
    soln.count_digits(-29107) == 5

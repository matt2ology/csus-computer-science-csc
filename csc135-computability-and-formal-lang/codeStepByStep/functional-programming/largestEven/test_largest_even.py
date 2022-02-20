import largest_even_solution as soln


def test_largest_even_case01():
    assert soln.largest_even([5, -1, 12, 10, 2, 8]) == 12


def test_largest_even_case02():
    assert soln.largest_even([-1, 2, -4, 6, -9]) == 6


def test_largest_even_case03():
    assert soln.largest_even([2, -1, 16, 4]) == 16


def test_largest_even_case04():
    assert soln.largest_even([10, 20, 30, 40, 50, 60, 70]) == 70


def test_largest_even_case05():
    assert soln.largest_even([70, 60, 50, 40, 30, 20, 10]) == 70


def test_largest_even_case06():
    assert soln.largest_even([-3, -1, -2, 9, -4, -10]) == -2


def test_largest_even_case07():
    assert soln.largest_even([6, -1, 4, 0, 2, 5]) == 6


def test_largest_even_case08():
    assert soln.largest_even([42]) == 42

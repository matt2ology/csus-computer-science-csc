# From file import class as soln
from count_negatives_solution import CountNegatives as soln


def test_case_01():
    assert soln.count_negatives(
        [5, -1, -3, 20, 47, -10, -8, -4, 0, -6, -6]) == 7


def test_case_02():
    assert soln.count_negatives([2, -1, 4, 16]) == 1


def test_case_03():
    assert soln.count_negatives([10, 20, 30, 40, 50, 60, 70]) == 0


def test_case_04():
    assert soln.count_negatives([-3, -1, 0, 9, -2, -10]) == 4


def test_case_05():
    assert soln.count_negatives([-1, -2, -3]) == 3


def test_case_06():
    assert soln.count_negatives([21]) == 0


def test_case_07():
    assert soln.count_negatives([-42]) == 1


def test_case_08():
    assert soln.count_negatives([]) == 0

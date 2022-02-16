import abs_sum_solution as soln


def test_case_01():
    assert soln.abs_sum([-1, 2, -4, 6, -9]) == 22


def test_case_02():
    assert soln.abs_sum([12, -1, 54, 16]) == 83


def test_case_03():
    assert soln.abs_sum([10, 20, 30, 40, 50, 60, 70]) == 280


def test_case_04():
    assert soln.abs_sum([-3, -1, 0, 9, -12, -10]) == 35


def test_case_05():
    assert soln.abs_sum([21]) == 21

from double_list_solution import DoubleList as soln

def test_case_01():
    assert soln.double_list([2, -1, 4, 16]) == [4, -2, 8, 32]

def test_case_02():
    assert soln.double_list([10, 20, 30, 40, 50, 60, 70]) == [20, 40, 60, 80, 100, 120, 140]

def test_case_03():
    assert soln.double_list([-3, -1, 0, 9, -2, -10]) == [-6, -2, 0, 18, -4, -20]

def test_case_04():
    assert soln.double_list([21]) == [42]

def test_case_05():
    assert soln.double_list([]) == []

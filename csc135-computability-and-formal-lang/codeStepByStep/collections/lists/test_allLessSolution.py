import allLessSolution as soln


def test_all_less_case_01():
    assert soln.all_less([1, 2, 3], [4, 5, 6]) == True


def test_all_less_case_02():
    assert soln.all_less([45, 20, 300], [50, 41, 600]) == True


def test_all_less_case_03():
    assert soln.all_less([67, 11, 98, -4], [50, 41, 600, 1]) == False


def test_all_less_case_04():
    assert soln.all_less([45, 20, 300], [50, 41, 600, 12]) == False


def test_all_less_case_05():
    assert soln.all_less([45, 20, 300, 4, 88], [50, 41, 600, 12]) == False


def test_all_less_case_06():
    assert soln.all_less([1, 2, 3], [4, 5, 1]) == False

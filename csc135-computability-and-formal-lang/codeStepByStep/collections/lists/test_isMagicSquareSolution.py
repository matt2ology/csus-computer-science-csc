import isMagicSquareSolution as soln


def test_is_magic_square_case_01():
    assert soln.is_magic_square([[2, 7, 6], [9, 5, 1], [4, 3, 8]]) == True


def test_is_magic_square_case_02():
    assert soln.is_magic_square(
        [[1, 1, 1, 1], [1, 1, 1, 1], [1, 1, 1, 1], [1, 1, 1, 1]]) == True


def test_is_magic_square_case_03():
    assert soln.is_magic_square([[42]]) == True


def test_is_magic_square_case_04():
    assert soln.is_magic_square([]) == True


def test_is_magic_square_case_05():
    assert soln.is_magic_square(
        [[2, 7, 6], [9, 5, 1, 777], [4, 3, 8]]) == False


def test_is_magic_square_case_06():
    assert soln.is_magic_square([[2, 7, 6], [9, 5, 1], [4, 1, 8]]) == False


def test_case_07():
    assert soln.is_magic_square(
        [[1, 1, 1, 1], [1, 1, 1, 1], [1, 1, 1, 1]]) == False


def test_case_08():
    assert soln.is_magic_square(
        [[1, 1, 1, 2], [1, 1, 1, 1], [1, 1, 1, 1], [1, 1, 1, 1]]) == False


def test_case_09():
    assert soln.is_magic_square([[2, 7, 6], [9, 5, 1], [5, 3, 8]]) == False


def test_case_10():
    assert soln.is_magic_square([[2, 7, 6], [9, 5, 1], [4, 3]]) == False


def test_case_11():
    assert soln.is_magic_square([[2, 7, 6], [9, 5, 1, 0], [4, 3, 8]]) == False


def test_case_12():
    assert soln.is_magic_square([[2, 7], [9, 5, 1], [4, 3, 8]]) == False


def test_case_13():
    assert soln.is_magic_square([[1, 1, 1, 1], [1, 1, 1, 1], [1, 1, 1, 1], [
                                1, 1, 1, 1], [1, 1, 1, 1]]) == False

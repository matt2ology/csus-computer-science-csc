import collection_set_numbers_in_common_solution as soln


def test_num_in_common_case_01():
    assert soln.num_in_common(
        [3, 7, 3, -1, 2, 3, 7, 2, 15, 15], [-5, 15, 2, -1, 7, 15, 36]) == 4


def test_num_in_common_case_02():
    assert soln.num_in_common([1, 2, 3], [3, 4, 5]) == 1


def test_num_in_common_case_03():
    assert soln.num_in_common([1, 2, 3], [2, 3, 4]) == 2


def test_num_in_common_case_04():
    assert soln.num_in_common([10, 20, 30, 40, 50], [50, 40, 30, 20, 10]) == 5


def test_num_in_common_case_05():
    assert soln.num_in_common([4], [1, 3, 5]) == 0


def test_num_in_common_case_06():
    assert soln.num_in_common([], []) == 0


def test_num_in_common_case_07():
    assert soln.num_in_common([42], []) == 0


def test_num_in_common_case_08():
    assert soln.num_in_common([], [42]) == 0


def test_num_in_common_version_2_case_01():
    assert soln.num_in_common_version_2(
        [3, 7, 3, -1, 2, 3, 7, 2, 15, 15], [-5, 15, 2, -1, 7, 15, 36]) == 4


def test_num_in_common_version_2_case_02():
    assert soln.num_in_common_version_2([1, 2, 3], [3, 4, 5]) == 1


def test_num_in_common_version_2_case_03():
    assert soln.num_in_common_version_2([1, 2, 3], [2, 3, 4]) == 2


def test_num_in_common_version_2_case_04():
    assert soln.num_in_common_version_2(
        [10, 20, 30, 40, 50], [50, 40, 30, 20, 10]) == 5


def test_num_in_common_version_2_case_05():
    assert soln.num_in_common_version_2([4], [1, 3, 5]) == 0


def test_num_in_common_version_2_case_06():
    assert soln.num_in_common_version_2([], []) == 0


def test_num_in_common_version_2_case_07():
    assert soln.num_in_common_version_2([42], []) == 0


def test_num_in_common_version_2_case_08():
    assert soln.num_in_common_version_2([], [42]) == 0

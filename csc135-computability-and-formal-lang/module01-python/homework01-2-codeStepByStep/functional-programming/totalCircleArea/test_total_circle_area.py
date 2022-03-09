import total_circle_area_solution as soln


def test_total_circle_area_case01():
    assert soln.total_circle_area([3.0, 1.0, 7.2, 5.5]) == 289


def test_total_circle_area_case02():
    assert soln.total_circle_area([5.5, 1.3, 12.6, 10.2, 2.3, 8.9]) == 1191


def test_total_circle_area_case03():
    assert soln.total_circle_area([1.0, 2.0, 4.0, 6.0, 9.0]) == 434


def test_total_circle_area_case04():
    assert soln.total_circle_area([4.2]) == 55


def test_total_circle_area_case05():
    assert soln.total_circle_area([]) == 0

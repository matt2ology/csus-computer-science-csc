import lambda_square_solution as soln


def test_lambda_square_case01():

    assert soln.f(4) == 16


def test_lambda_square_case02():

    assert soln.f(10) == 100


def test_lambda_square_case03():

    assert soln.f(-3) == 9


def test_lambda_square_case04():

    assert soln.f(1234) == 1522756


def test_lambda_square_case05():

    assert soln.f(0) == 0

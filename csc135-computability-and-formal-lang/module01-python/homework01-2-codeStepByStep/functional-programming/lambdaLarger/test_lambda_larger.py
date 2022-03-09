import lambda_larger_solution as soln


def test_lambda_larger_solution1():
    assert soln.f(4, 11) == 11

def test_lambda_larger_solution2():
    assert soln.f(7, 2) == 7

def test_lambda_larger_solution3():
    assert soln.f(3, 5) == 5

def test_lambda_larger_solution4():
    assert soln.f(42, 42) == 42

def test_lambda_larger_solution5():
    assert soln.f(-2, -4) == -2

def test_lambda_larger_solution6():
    assert soln.f(-1, 0) == 0

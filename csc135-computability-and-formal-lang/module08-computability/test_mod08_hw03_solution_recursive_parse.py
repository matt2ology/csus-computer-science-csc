import mod08_hw03_solution_recursive_parse


def test_parse_case_01():
    assert mod08_hw03_solution_recursive_parse.parse("a")


def test_parse_case_02():
    assert mod08_hw03_solution_recursive_parse.parse("(a)")


def test_parse_case_03():
    assert mod08_hw03_solution_recursive_parse.parse("((a))")


def test_parse_case_04():
    assert mod08_hw03_solution_recursive_parse.parse("a+a")


def test_parse_case_05():
    assert mod08_hw03_solution_recursive_parse.parse("a*a")


def test_parse_case_06():
    assert mod08_hw03_solution_recursive_parse.parse("((a)/(a)-(a))")


def test_parse_case_07():
    assert mod08_hw03_solution_recursive_parse.parse(
        "((a)/(a)-(a))*((a)/(a)-(a))")


def test_parse_case_08():
    assert mod08_hw03_solution_recursive_parse.parse("a+a*a-a/a")


def test_parse_case_09():
    assert mod08_hw03_solution_recursive_parse.parse("a/a-a*a+a")


def test_parse_case_10():
    assert mod08_hw03_solution_recursive_parse.parse("(a+a*a-a/a)")


def test_parse_case_11():
    assert mod08_hw03_solution_recursive_parse.parse("(a/a-a*a+a)")


def test_parse_case_12():
    assert mod08_hw03_solution_recursive_parse.parse("(a+(a*a*a)+a+a)")


def test_parse_case_13():
    assert mod08_hw03_solution_recursive_parse.parse("(a*(a+a+a)*a*a)")

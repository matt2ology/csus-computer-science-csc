import check_duplicate_value as soln


def test_check_duplicate_value_case_01():
    assert soln.has_duplicate_value({'Marty': 'Stepp', 'Stuart': 'Reges',
                                     'Jessica': 'Miller', 'Amanda': 'Camp',
                                     'Hal': 'Perkins'}) == False


def test_check_duplicate_value_case_02():
    assert soln.has_duplicate_value({'Marty': 'Stepp', 'Stuart': 'Reges',
                                    'Jessica': 'Miller', 'Amanda': 'Camp',
                                    'Meghan': 'Miller', 'Hal': 'Perkins'}) == True


def test_check_duplicate_value_case_03():
    assert soln.has_duplicate_value({'Kendrick': 'Perkins', 'Stuart': 'Reges',
                                     'Jessica': 'Miller', 'Bruce': 'Reges',
                                     'Hal': 'Perkins'}) == True


def test_check_duplicate_value_case_04():
    assert soln.has_duplicate_value({'Mario': 'Mario'}) == False


def test_check_duplicate_value_case_05():
    assert soln.has_duplicate_value({}) == False

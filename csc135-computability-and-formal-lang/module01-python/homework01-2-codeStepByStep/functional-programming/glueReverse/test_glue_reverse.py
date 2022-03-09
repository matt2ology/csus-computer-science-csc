import glue_reverse_solution as soln


def test_case_01():
    assert soln.glue_reverse(
        ["the", "quick", "brown", "fox"]) == "foxbrownquickthe"


def test_case_02():
    assert soln.glue_reverse(
        ["go", "seattle", "mariners"]) == "marinersseattlego"


def test_case_03():
    assert soln.glue_reverse(["TEENAGE", "MUTANT", "NINJA", "TURTLES",
                             "TURTLE", "POWER"]) == "POWERTURTLETURTLESNINJAMUTANTTEENAGE"


def test_case_04():
    assert soln.glue_reverse(["hello", "WORLD"]) == "WORLDhello"


def test_case_05():
    assert soln.glue_reverse(["goodbye"]) == "goodbye"


def test_case_06():
    assert soln.glue_reverse([]) == ""

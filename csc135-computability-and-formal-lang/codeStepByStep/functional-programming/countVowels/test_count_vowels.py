from count_vowels_solution import CountVowels as soln


def test_case_01():
    assert soln.count_vowels("SOO beautiful") == 7

def test_case_02():
    assert soln.count_vowels("go seattle mariners") == 7
    
def test_case_03():
    assert soln.count_vowels("TEENAGE MUTANT NINJA TURTLES") == 10
    
def test_case_04():
    assert soln.count_vowels("Rubber BABY buggy BUMPERS") == 6
    
def test_case_05():
    assert soln.count_vowels("hello WORLD!") == 3
    
def test_case_06():
    assert soln.count_vowels("goodbye") == 3
    
def test_case_07():
    assert soln.count_vowels("rhythm") == 0
    
def test_case_08():
    assert soln.count_vowels("XYZZY") == 0
    
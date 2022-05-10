import mod08_hw03_solution_recursive_parse

class test_parse_solution:

    def parseD(self, toks):
        tok = toks.next()
        if (tok == 'a'):
            toks.match(tok)
        elif tok == '(':
            toks.match(tok)
            self.parseS(toks)
        elif (tok in ('+', '-', ')', 'a') or tok == None):
            pass
        else:
            raise Exception


    def parseC(self, toks):
        tok = toks.next()
        if tok in ('*', '/'):
            toks.match(tok)
            self.parseD(toks)
            self.parseC(toks)
            toks.match(')')
        elif (tok in ('+', '-', ')', 'a') or tok == None):
            pass
        else:
            raise Exception

    def parseB(self, toks):
        tok = toks.next()
        if tok in ('a', ')'):
            toks.match(tok)
            self.parseD(toks)
            self.parseC(toks)
        else:
            raise Exception

    def parseA(self, toks):
        tok = toks.next()
        if tok in ('+', '-'):
            toks.match(tok)
            self.parseB(toks)
            self.parseA(toks)
            toks.match(')')
        elif (tok == None) or tok in ('a', ')'):
            pass
        else:
            raise Exception

    def parseS(self, toks):
        tok = toks.next()
        if tok in ('a', '('):
            self.parseB(toks)
            self.parseA(toks)
        else:
            raise Exception


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

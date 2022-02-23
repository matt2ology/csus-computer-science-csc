from hamt_solution import hamt


class TestHamtSolution:

    a = hamt("A", "a")
    b = a.set("B", "b")
    c = b.set("C", "c")
    d = c.set("D", "d")
    e = d.set("E", "e")
    f = e.set("F", "f")
    iu = f.set("IU", "BBIBBI")
    jrock = f.set("ONEOKROCK", "Wherever you are")
    kpop = iu.set("2NE1", 21)

    def test_get_key_A_value_a(self):
        assert self.a.get("A") == 'a'

    def test_get_key_B_value_b(self):
        assert self.b.get("B") == 'b'

    def test_get_key_C_value_c(self):
        assert self.c.get("C") == 'c'

    def test_get_key_D_value_d(self):
        assert self.d.get("D") == 'd'

    def test_get_key_E_value_e(self):
        assert self.e.get("E") == 'e'

    def test_get_key_F_value_f(self):
        assert self.f.get("F") == 'f'

    def test_get_key_Z_value_none(self):
        assert self.f.get("Z") == None

    def test_get_key_IU_value_BBIBBI(self):
        assert self.iu.get("IU") == 'BBIBBI'

    def test_get_key_ONEOKROCK_value_WhereverYouAre(self):
        assert self.jrock.get("ONEOKROCK") == "Wherever you are"

    def test_get_key_2NE1_value_21(self):
        assert self.kpop.get("2NE1") == 21

    def test_len_3_keys(self):
        assert self.c.len() == 3

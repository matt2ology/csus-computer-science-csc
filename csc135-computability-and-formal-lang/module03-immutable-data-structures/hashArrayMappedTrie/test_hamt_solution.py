from hamt_solution import hamt


class TestHamtSolution:

    a = hamt("A", "a")  # 1
    b = a.set("B", "b") # 2
    c = b.set("C", "c") # 3
    d = c.set("D", "d") # 4
    e = d.set("E", "e") # 5
    f = e.set("F", "f") # 6
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

    def test_len_1_keys(self):
        assert self.a.len() == 1
        
    def test_len_2_keys(self):
        assert self.b.len() == 2
        
    def test_len_3_keys(self):
        assert self.c.len() == 3

    def test_len_4_keys(self):
        assert self.d.len() == 4
        
    def test_len_5_keys(self):
        assert self.e.len() == 5
        
    def test_len_6_keys(self):
        assert self.f.len() == 6
        
    def test_len_7_keys(self):
        assert self.jrock.len() == 7
        assert self.iu.len() == 7
        
    def test_len_8_keys(self):
        assert self.kpop.len() == 8

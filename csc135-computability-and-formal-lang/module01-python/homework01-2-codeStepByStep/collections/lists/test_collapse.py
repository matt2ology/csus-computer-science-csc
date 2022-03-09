import codeStepByStepCollapseSolution as soln
import unittest


class TestCollapse(unittest.TestCase):

    def test_collapse_case_1(self):
        result = soln.collapse([7, 2, 8, 9, 4, 13, 7, 1, 9, 10])
        self.assertCountEqual(result, [9, 17, 17, 8, 19])

    def test_collapse_case_2(self):
        result = soln.collapse([1, 2, 3, 4, 5])
        self.assertCountEqual(result, [3, 7, 5])

    def test_collapse_case_3(self):
        result = soln.collapse([100, -100])
        self.assertCountEqual(result, [0])

    def test_collapse_case_4(self):
        result = soln.collapse([1, 2, 3])
        self.assertCountEqual(result, [3, 3])

    def test_collapse_case_5(self):
        result = soln.collapse([1])
        self.assertCountEqual(result, [1])

    def test_collapse_case_6(self):
        result = soln.collapse([])
        self.assertCountEqual(result, [])

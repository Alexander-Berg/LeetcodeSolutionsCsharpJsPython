import unittest
from typing import List
from ExpressionAddOperators import ExpressionAddOperators


class TestExpressionAddOperators(unittest.TestCase):

        def test_addoperators(self):
           eao = ExpressionAddOperators()
           s1 = "123"
           target1 = 6
           expected1 = ["1+2+3", "1*2*3"]
           self.assertEqual(eao.addOperators(s1, target1), expected1)

        def test_addoperators2(self):
           eao = ExpressionAddOperators()
           s2 = "232"
           target2 = 8
           expected2 = ["2+3*2", "2*3+2"]
           self.assertEqual(eao.addOperators(s2, target2), expected2)

        def test_addoperators3(self):
           eao = ExpressionAddOperators()
           s3 = "105"
           target3 = 5
           expected3 = ["1*0+5","10-5"]
           self.assertEqual(eao.addOperators(s3, target3), expected3)

        def test_addoperators4(self):
           eao = ExpressionAddOperators()
           s4 = "00"
           target4 = 0
           expected4 = ["0+0", "0-0", "0*0"]
           self.assertEqual(eao.addOperators(s4, target4), expected4)

        def test_addoperators5(self):
           eao = ExpressionAddOperators()
           s5 = "3456237490"
           target5 = 9191
           expected5 = []
           self.assertEqual(eao.addOperators(s5, target5), expected5)


if __name__ == '__main__':
    unittest.main()


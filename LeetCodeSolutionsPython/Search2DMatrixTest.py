import unittest
from typing import List

from Search2DMatrix import Search2DMatrix


class TestSolution(unittest.TestCase):
    def test_searchMatrix(self):
        s = Search2DMatrix()
        matrix = [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]]
        self.assertTrue(s.searchMatrix(matrix, 3))
        self.assertFalse(s.searchMatrix(matrix, 13))
        self.assertTrue(s.searchMatrix(matrix, 34))
        self.assertFalse(s.searchMatrix(matrix, 70))
        self.assertFalse(s.searchMatrix(matrix, -1))

if __name__ == '__main__':
    unittest.main()


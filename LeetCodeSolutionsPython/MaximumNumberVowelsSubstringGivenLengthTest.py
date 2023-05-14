import unittest

from MaximumNumberVowelsSubstringGivenLength import Solution


class TestSolution(unittest.TestCase):
    def setUp(self):
        self.s = Solution()

    def test_maxVowels(self):
        self.assertEqual(self.s.maxVowels("abciiidef", 2), 2)
        self.assertEqual(self.s.maxVowels("aeiou", 2), 2)
        self.assertEqual(self.s.maxVowels("leetcode", 3), 2)
        self.assertEqual(self.s.maxVowels("rhythms", 4), 0)
        self.assertEqual(self.s.maxVowels("rhythmsaeiou", 1), 1)

if __name__ == '__main__':
    unittest.main()

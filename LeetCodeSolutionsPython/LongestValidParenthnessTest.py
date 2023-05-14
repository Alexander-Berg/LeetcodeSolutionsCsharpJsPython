import unittest

from LongestValidParentheses import LongestValidParenthness


class TestLongestValidParentheses(unittest.TestCase):
    def setUp(self):
        self.test_cases = [
            {"input": "(()", "output": 2},
            {"input": "())", "output": 2},
            {"input": "", "output": 0},
            {"input": "()()()", "output": 6},
            {"input": "()(()", "output": 2},
            {"input": ")()())", "output": 4}
        ]

    def test_longestValidParentheses(self):
        for case in self.test_cases:
            result = LongestValidParenthness().longestValidParentheses(case["input"])
            self.assertEqual(result, case["output"])


if __name__ == "__main__":
    unittest.main()

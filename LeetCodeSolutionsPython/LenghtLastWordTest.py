import unittest

from LengthLastWord import LengthLastWord


class TestLengthLastWord(unittest.TestCase):

    def setUp(self):
        self.llw = LengthLastWord()

    def test_lengthOfLastWord(self):
        # Test cases with single word strings
        self.assertEqual(self.llw.lengthOfLastWord("hello"), 5)
        self.assertEqual(self.llw.lengthOfLastWord("world"), 5)
        self.assertEqual(self.llw.lengthOfLastWord("python"), 6)

    def test_lengthOfLastWord2(self):
        # Test cases with multiple word strings
        self.assertEqual(self.llw.lengthOfLastWord("hello world"), 5)
        self.assertEqual(self.llw.lengthOfLastWord(" hello world "), 5)
        self.assertEqual(self.llw.lengthOfLastWord("   python is great   "), 5)

    def test_lengthOfLastWord3(self):
        # Test case with empty string
        self.assertEqual(self.llw.lengthOfLastWord(""), 0)

    def test_lengthOfLastWord4(self):
        # Test case with no word in string
        self.assertEqual(self.llw.lengthOfLastWord("  "), 0)

if __name__ == '__main__':
    unittest.main()

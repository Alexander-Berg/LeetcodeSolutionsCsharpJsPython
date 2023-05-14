import unittest

from ZigzagCoversion import ZigzagConcersion


class TestZigzagConcersion(unittest.TestCase):
    def setUp(self):
        self.converter = ZigzagConcersion()

    def test_convert_single_row(self):
        s = "hello"
        numRows = 1
        expected = "hello"
        self.assertEqual(self.converter.convert(s, numRows), expected)

    def test_convert_less_than_three_chars(self):
        s = "hi"
        numRows = 2
        expected = "hi"
        self.assertEqual(self.converter.convert(s, numRows), expected)

    def test_convert_three_chars(self):
        s = "abc"
        numRows = 2
        expected = "acb"
        self.assertEqual(self.converter.convert(s, numRows), expected)

    def test_convert_normal_case(self):
        s = "PAYPALISHIRING"
        numRows = 3
        expected = "PAHNAPLSIIGYIR"
        self.assertEqual(self.converter.convert(s, numRows), expected)

if __name__ == '__main__':
    unittest.main()


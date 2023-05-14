import unittest

from IntegertoEnglishWords import IntegertoEnglishWords

class MyTestCase(unittest.TestCase):
    def test_IntegertoEnglishWords(self):
       iew = IntegertoEnglishWords()

       # Test cases for numbers less than 1000
       assert iew.numberToWords(15) == "Fifteen"
       assert iew.numberToWords(78) == "Seventy Eight"
       assert iew.numberToWords(100) == "One Hundred"
       assert iew.numberToWords(123) == "One Hundred Twenty Three"
       assert iew.numberToWords(319) == "Three Hundred Nineteen"
       assert iew.numberToWords(999) == "Nine Hundred Ninety Nine"

    def test_IntegertoEnglishWordsLarge(self):
       iew = IntegertoEnglishWords()
       # Test cases for numbers greater than 1000
       assert iew.numberToWords(1000) == "One Thousand"
       assert iew.numberToWords(10000) == "Ten Thousand"
       assert iew.numberToWords(123456) == "One Hundred Twenty Three Thousand Four Hundred Fifty Six"
       assert iew.numberToWords(1000000) == "One Million"
       assert iew.numberToWords(123456789) == "One Hundred Twenty Three Million Four Hundred Fifty Six Thousand Seven Hundred Eighty Nine"
       assert iew.numberToWords(1000000000) == "One Billion"
       assert iew.numberToWords(1000000000000) == "One Trillion"
       assert iew.numberToWords(1000000000000000) == "One Quadrillion"
       assert iew.numberToWords(1000000000000000000) == "One Quintillion"

    def test_numberToWords(self):
       converter = IntegertoEnglishWords()

       # Test cases with simple numbers
       assert converter.numberToWords(0) == "Zero"
       assert converter.numberToWords(5) == "Five"
       assert converter.numberToWords(10) == "Ten"
       assert converter.numberToWords(20) == "Twenty"
       assert converter.numberToWords(45) == "Forty Five"
       assert converter.numberToWords(99) == "Ninety Nine"
       assert converter.numberToWords(100) == "One Hundred"
       assert converter.numberToWords(200) == "Two Hundred"
       assert converter.numberToWords(999) == "Nine Hundred Ninety Nine"

    def test_numberToWords(self):
       converter = IntegertoEnglishWords()
       # Test cases with larger numbers
       assert converter.numberToWords(1000) == "One Thousand"
       assert converter.numberToWords(1000000) == "One Million"
       assert converter.numberToWords(1000000000) == "One Billion"
       assert converter.numberToWords(123456789) == "One Hundred Twenty Three Million Four Hundred Fifty Six Thousand Seven Hundred Eighty Nine"
       assert converter.numberToWords(9876543210) == "Nine Billion Eight Hundred Seventy Six Million Five Hundred Forty Three Thousand Two Hundred Ten"

    def test_numberToWords(self):
       converter = IntegertoEnglishWords()
       # Test cases with edge numbers
       assert converter.numberToWords(2147483647) == "Two Billion One Hundred Forty Seven Million Four Hundred Eighty Three Thousand Six Hundred Forty Seven"
       assert converter.numberToWords(9223372036854775807) == "Nine Quintillion Two Hundred Twenty Three Quadrillion Three Hundred Seventy Two Trillion Thirty Six Billion Eight Hundred Fifty Four Million Seven Hundred Seventy Five Thousand Eight Hundred Seven"

if __name__ == '__main__':
    unittest.main()
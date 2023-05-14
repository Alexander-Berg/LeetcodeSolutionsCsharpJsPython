import unittest
from BinarySearch import BinarySearch

class TestBinarySearch(unittest.TestCase):
    def test_search_empty_list(self):
        bs = BinarySearch()
        self.assertEqual(bs.search([], 1), -1)

    def test_search_single_item_list(self):
        bs = BinarySearch()
        self.assertEqual(bs.search([1], 1), 0)

    def test_search_item_not_found(self):
        bs = BinarySearch()
        self.assertEqual(bs.search([1, 2, 3, 4, 5], 6), -1)

    def test_search_item_found(self):
        bs = BinarySearch()
        self.assertEqual(bs.search([1, 2, 3, 4, 5], 3), 2)

    def test_search_duplicate_items(self):
        bs = BinarySearch()
        self.assertEqual(bs.search([1, 2, 2, 2, 3], 2), 3)

if __name__ == '__main__':
    unittest.main()

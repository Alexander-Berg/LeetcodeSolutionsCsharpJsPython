import unittest
from typing import List

from SearchInsertPosition import SearchInsertPosition


class SearchInsertPositionTestCase(unittest.TestCase):
    def setUp(self):
        self.sip = SearchInsertPosition()

    def test_searchInsert_existing_number(self):
        nums = [1, 3, 5, 7]
        target = 3
        expected_output = 1
        self.assertEqual(self.sip.searchInsert(nums, target), expected_output)

    def test_searchInsert_not_existing_number(self):
        nums = [1, 3, 5, 7]
        target = 4
        expected_output = 2
        self.assertEqual(self.sip.searchInsert(nums, target), expected_output)

    def test_searchInsert_at_beginning(self):
        nums = [2, 3, 5, 7]
        target = 1
        expected_output = 0
        self.assertEqual(self.sip.searchInsert(nums, target), expected_output)

    def test_searchInsert_at_end(self):
        nums = [1, 3, 5, 6]
        target = 7
        expected_output = 4
        self.assertEqual(self.sip.searchInsert(nums, target), expected_output)

if __name__ == '__main__':
    unittest.main()

import unittest

from FindDifference2Arrays import FindDifference2Arrays


class TestFindDifference2Arrays(unittest.TestCase):
    def test_find_difference_with_common_elements(self):
        nums1 = [1, 2, 3, 4, 5]
        nums2 = [4, 5, 6, 7, 8]
        fd = FindDifference2Arrays()
        result = fd.findDifference(nums1, nums2)
        self.assertEqual(result, [[1, 2, 3], [8, 6, 7]])

    def test_find_difference_with_no_common_elements(self):
        nums1 = [1, 2, 3]
        nums2 = [4, 5, 6]
        fd = FindDifference2Arrays()
        result = fd.findDifference(nums1, nums2)
        self.assertEqual(result, [[1, 2, 3], [4, 5, 6]])

    def test_find_difference_with_identical_lists(self):
        nums1 = [1, 2, 3]
        nums2 = [1, 2, 3]
        fd = FindDifference2Arrays()
        result = fd.findDifference(nums1, nums2)
        self.assertEqual(result, [[], []])


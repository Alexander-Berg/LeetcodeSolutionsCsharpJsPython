from typing import List


class FindDifference2Arrays:
    def findDifference(self, nums1: List[int], nums2: List[int]) -> List[List[int]]:
        set_1 = list_to_set(nums1)
        set_2 = list_to_set(nums2)

        return remove_same_elements(set_1, set_2)


# Convert the lists into sets via helper method.
def list_to_set(arr: List[int]):
    s = set()

    for i in arr:
        s.add(i)

    return s


# Now when the two lists are sets, use the difference attribute to filter common elements of the two sets.
def remove_same_elements(x, y):
    x, y = list(x - y), list(y - x)

    return [x, y]

# Runtime: 185 ms, faster than 95.96% of Python3 online submissions for Find the Difference of Two Arrays.
# Memory Usage: 14.3 MB, less than 51.66% of Python3 online submissions for Find the Difference of Two Arrays.

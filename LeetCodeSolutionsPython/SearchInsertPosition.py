from typing import List


class SearchInsertPosition:
    def searchInsert(self, nums: List[int], target: int) -> int:
        n = 0
        for i in range(len(nums)):
            if target not in nums:
                nums.append(target)
                nums.sort()
                n = nums.index(target)
            else:
                n = nums.index(target)
        return n
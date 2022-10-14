class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        def bisearch_left(nums, target):
            low, high = 0, len(nums)
            while low < high:
                mid = (low + high) // 2
                if target > nums[mid]:
                    low = mid + 1
                else:
                    high = mid
            return low
        
        def bisearch_right(nums, target):
            low, high = 0, len(nums)
            while low < high:
                mid = (low + high) // 2
                if target >= nums[mid]:
                    low = mid + 1
                else:
                    high = mid
            return low
    
        left = bisearch_left(nums, target)
        right = bisearch_right(nums, target)
        
        if left >= right:
            return [-1, -1]

        
        return [left, right - 1]
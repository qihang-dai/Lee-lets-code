class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        def bisect_left(target):
            l, h = 0, len(nums)
            while l < h:
                mid = (l + h) // 2
                if nums[mid] < target:
                    l = mid + 1
                else:
                    h = mid
            return h
        
        def bisect_right(target):
            l, h = 0, len(nums)
            while l < h:
                mid = (l + h) // 2
                if nums[mid] <= target:
                    l = mid + 1
                else:
                    h = mid
            return h
        
        
        res = [bisect_left(target), bisect_right(target) - 1]
        left, right = res
        if left >= right + 1:
            return [-1 ,-1]
        else:
            return res
            
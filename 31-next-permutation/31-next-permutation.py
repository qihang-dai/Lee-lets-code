class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        i = len(nums) - 1
        
        while i - 1 >= 0 and nums[i - 1] >= nums[i]: 
            i -= 1
        
        if i == 0:
            nums.reverse()
            return
        
        #find the decreaseing sequence so its biggest ending, we have to change the previous one
        j = i
        
        
        
        #we want to reverse the ending to get the smalles tail. But we also want the swap to make the smallest tail.
        #so we want the fronter digits to be done (in reverse order). but in the original order, the rightmost larger num should be swapped
        while j + 1 < len(nums) and nums[j + 1] > nums[i - 1]:
            j += 1
        
        # j is the rightmost larger number, swap
        
        nums[j], nums[i - 1] = nums[i - 1], nums[j]
        nums[i:] = nums[i:][::-1]
        
        
        
        
        
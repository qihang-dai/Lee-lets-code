class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        stack = []
        mapping = {}
        res = []
        
        stack.append(nums2[0])
        
        for n in nums2:
            while stack and stack[-1] < n:
                mapping[stack[-1]] = n
                stack.pop()
            stack.append(n)
        
        for n in stack:
            mapping[n] = -1
            
        for n in nums1:
            res.append(mapping[n])
        
        return res
        
        
        
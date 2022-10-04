class Solution:
    def nextGreaterElement(self, n: int) -> int:
        digits = list(str(n))
        i = len(digits) - 1
        
        while i > 0 and digits[i - 1] >= digits[i]:
            i -= 1
        
        if i == 0:
            return -1
        
        j = i
        
        while j + 1 < len(digits) and digits[j + 1] > digits[i - 1]:
            j += 1
        
        digits[j], digits[i - 1] = digits[i - 1], digits[j]
        
        digits[i:] = digits[i:][::-1]
        
        res = int(''.join(digits))
        
        return res if res < 1 << 31 else -1
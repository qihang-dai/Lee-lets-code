class Solution:
    def minTimeToType(self, word: str) -> int:
        
        
        second = 0
        prev = 'a'
        
        for w in word:
            if prev != w:
                clock = abs(ord(w) - ord(prev))
                counterclock = abs(26 - clock)
                second += min(clock, counterclock) #move
            second += 1 #type
            prev = w
        
        return second
            
                
        
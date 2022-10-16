class Solution:
    def minTimeToType(self, word: str) -> int:
        
        
        second = len(word)
        prev = 'a'
        
        for w in word:
            
            clock = abs(ord(w) - ord(prev))
            counterclock = abs(26 - clock)
            second += min(clock, counterclock) #move
            prev = w
        
        return second
            
                
        
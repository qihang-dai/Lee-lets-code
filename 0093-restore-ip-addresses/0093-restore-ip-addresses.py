class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        

        
        res = []
        path = []
        
        if len(s) > 12:
            return res
        
        def backtrack(path, start):
            if len(path) == 4:
                if start == len(s):
                    pathString = ".".join(path)
                    res.append(pathString)
                    return
            for i in range(start + 1, min(len(s) + 1, start + 4)):
                tmp = s[start: i]                    
                if len(tmp) > 1 and int(tmp[0]) == 0:
                    break
                if len(tmp) > 2 and int(tmp) > 255:
                    break
                
                path.append(tmp)
                backtrack(path, i)
                path.pop()
        
        backtrack([], 0)
        return res
            
                    
                
                
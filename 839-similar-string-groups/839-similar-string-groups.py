class Solution:
    def numSimilarGroups(self, strs: List[str]) -> int:
        
        p = {x : x for x in strs}
        
        def find(x):
            if x != p[x]:
                p[x] = find(p[x])
            return p[x]
        
        def union(x, y):
            p[find(x)] = find(y)
        
        similar = lambda str1, str2: sum(a != b for a, b in zip(str1, str2)) <= 2
        
        
        #connect every node with no extra effort, and see how many root there is
        for i in range(len(strs)):
            for j in range(i):
                if similar(strs[i], strs[j]):
                    union(strs[i], strs[j])
        
        return len({find(x) for x in strs})
        
        
        
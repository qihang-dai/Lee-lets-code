class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        
        mapping = collections.defaultdict(list)
        
        for str in strs:
            mapping[tuple(sorted(str))].append(str)
            
        return mapping.values()
        
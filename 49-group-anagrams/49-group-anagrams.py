class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        
        mapping = collections.defaultdict(list)
        
        for str in strs:
            array = [0] * 26
            for w in str:
                array[ord(w) - ord('a')] += 1
            mapping[tuple(array)].append(str)
            
        return mapping.values()
        
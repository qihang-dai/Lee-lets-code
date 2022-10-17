class Solution:
    def isValidSerialization(self, preorder: str) -> bool:
        
        nodes = preorder.split(",")
        
        slot = 1
        
        for node in nodes:
            if slot == 0:
                return False
            if node == '#':
                slot -= 1
            else:
                slot += 1
        
        return slot == 0
        
        
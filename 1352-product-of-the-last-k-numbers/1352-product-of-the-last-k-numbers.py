class ProductOfNumbers:

    def __init__(self):
        self.A = [1] #get this as a base to help other. we want -1 / -1 - k to be the val so its reaonable to leave one as the extra prefix
        

    def add(self, num: int) -> None:
        if num == 0:
            self.A = [1]
        else:
            self.A.append(self.A[-1] * num)
            
    def getProduct(self, k: int) -> int:
        if len(self.A) <= k:
            return 0
        return self.A[-1] // self.A[-1-k]


# Your ProductOfNumbers object will be instantiated and called as such:
# obj = ProductOfNumbers()
# obj.add(num)
# param_2 = obj.getProduct(k)
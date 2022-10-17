class ProductOfNumbers:

    def __init__(self):
        self.stream = []
        self.product = []
        

    def add(self, num: int) -> None:

        self.stream.append(num)
        
        if not self.product:
            self.product.append(num)
        else:
            self.product.append(num * self.product[-1])
        
        if num == 0:
            self.product = []
        
        # print("stream", self.stream, "product", self.product)
        
        

    def getProduct(self, k: int) -> int:
        if len(self.product) < k:
            return 0
        if len(self.product) == k:
            return self.product[-1]
        return self.product[-1] // self.product[-1 - k]
        


# Your ProductOfNumbers object will be instantiated and called as such:
# obj = ProductOfNumbers()
# obj.add(num)
# param_2 = obj.getProduct(k)
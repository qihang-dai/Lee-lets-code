class CustomStack:

    def __init__(self, maxSize: int):
        self.maxSize = maxSize
        self.stack = [None] * maxSize
        self.top = 0
        

    def push(self, x: int) -> None:
        if self.top < self.maxSize:
            self.stack[self.top] = x
            self.top += 1
        # print(self.stack)
            

    def pop(self) -> int:
        if self.top == 0:
            return - 1
        self.top -= 1
        popval = self.stack[self.top]
        self.stack[self.top] = None
        # print(self.stack)
        return popval
        

    def increment(self, k: int, val: int) -> None:
        bound = min(k, self.top)
        # print(bound)
        for i in range(bound):
            self.stack[i] += val
        # print(self.stack)
        


# Your CustomStack object will be instantiated and called as such:
# obj = CustomStack(maxSize)
# obj.push(x)
# param_2 = obj.pop()
# obj.increment(k,val)
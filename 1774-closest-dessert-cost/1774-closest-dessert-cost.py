class Solution:
    def closestCost(self, baseCosts: List[int], toppingCosts: List[int], target: int) -> int:        
        costs = set(baseCosts)
        for topping in toppingCosts:
            withToppingCosts = []
            for c in costs:
                withToppingCosts.append(c)
                withToppingCosts.append(c+topping)
                withToppingCosts.append(c+topping*2)
            print(withToppingCosts)
            costs = set(withToppingCosts)
        print(costs)
        
        # Set now contains all the possibilitys. Pick the best one.
        best = baseCosts[0]
        for c in costs:
            if abs(c-target) < abs(best-target):
                best = c
            elif abs(c-target) == abs(best-target) and c < best:
                best = c
        return best

        
            
        
        
        
        
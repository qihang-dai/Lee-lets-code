class Solution:
    def closestCost(self, baseCosts: List[int], toppingCosts: List[int], target: int) -> int:        
        q = [target - basecost for basecost in baseCosts]

        for toppingcost in toppingCosts:
            q += [val - cost for val in q if val > 0 for cost in (toppingcost, toppingcost * 2)]
        
        print(q)
        return target - min(q, key=lambda x: 2 * abs(x) - (x > 0))
        
            
        
        
        
        
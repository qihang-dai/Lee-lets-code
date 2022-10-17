class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        
        graph = defaultdict(dict)
        for [f, t], v in zip(equations, values):
            graph[f][t] = v
            graph[t][f] = 1 / v
                
        def dfs(a, b, visited):
            if a not in graph or b not in graph:
                return -1
            
            if b in graph[a]:
                return graph[a][b]
            
            for end in graph[a]:
                if end not in visited:
                    visited.add(end)
                    tmp = dfs(end, b, visited)

                    if tmp == -1:
                        continue
                    else:
                        return graph[a][end] * tmp
            
            return -1
                    
        return [dfs(a, b, set()) for a, b in queries]
                    
                
                
                
            
        
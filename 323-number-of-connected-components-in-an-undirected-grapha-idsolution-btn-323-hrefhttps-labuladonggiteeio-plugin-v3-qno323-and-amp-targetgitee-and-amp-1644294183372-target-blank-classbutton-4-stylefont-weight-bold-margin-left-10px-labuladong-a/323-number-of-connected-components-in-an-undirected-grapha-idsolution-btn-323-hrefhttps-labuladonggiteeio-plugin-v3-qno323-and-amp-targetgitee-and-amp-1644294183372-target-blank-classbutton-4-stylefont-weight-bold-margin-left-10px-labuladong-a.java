class Solution {
    void dfs(List<Integer>[] adList, int[] visited, int node){
        visited[node] = 1;
        for(int i = 0; i< adList[node].size(); i++){
            if(visited[adList[node].get(i)] == 0){
                dfs(adList, visited, adList[node].get(i));
            }
        }
    }
    public int countComponents(int n, int[][] edges) {
        int res = 0;
        List<Integer>[] adList = new ArrayList[n];
        int[] visited = new int[n];
        for(int i = 0; i < n; i++){
            adList[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < edges.length; i++){
            adList[edges[i][0]].add(edges[i][1]);
            adList[edges[i][1]].add(edges[i][0]);

        }
        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                res++;
                dfs(adList, visited, i);
            }
                
        }
        return res;
        
    }
}
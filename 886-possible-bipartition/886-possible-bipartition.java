class Solution {
    boolean ok = true;
    boolean[] color;
    boolean[] visited;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        color = new boolean[n + 1];
        visited = new boolean[n + 1];
         List<Integer>[] graph = buildGraph(n, dislikes);
        for(int v = 1; v <= n; v++){
            if(!visited[v]){
                dfs(graph, v);
                if(ok == false) return false;
            }
        }

        return ok;
    }
    
    private List<Integer>[] buildGraph(int n, int[][] dislikes) {
        // 图节点编号为 1...n
        List<Integer>[] graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : dislikes) {
            int v = edge[1];
            int w = edge[0];
            // 「无向图」相当于「双向图」
            // v -> w
            graph[v].add(w);
            // w -> v
            graph[w].add(v);
        }
        return graph;
    }

    public void dfs(List<Integer>[] dislikes, int v){
        if(!ok) return;
        visited[v] = true;
        for(int w : dislikes[v]){
            if(!visited[w]){
                color[w] = !color[v];
                dfs(dislikes, w);
            }else{
                if(color[w] == color[v]){
                    ok = false;
                }
            }
        }
    }
}
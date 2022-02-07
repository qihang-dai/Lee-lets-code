class Solution {
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        Queue<Integer> q = new LinkedList();
        for(int i = 0; i < M.length; i++){
            if(visited[i] == 0){
                q.add(i);
                while(!q.isEmpty()){
                    int node = q.poll();
                    visited[node] = 1;
                    for(int j = 0; j < M.length; j++){
                        if(M[node][j] == 1 && visited[j] == 0)
                            q.add(j);
                    } 
                }
                count++;
            }
        }
        return count;
        
    }
}
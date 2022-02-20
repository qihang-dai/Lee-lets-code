class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k, (a,b) -> a - b);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j< matrix.length; j++){
                q.offer(matrix[i][j]);
            }
        }

        while(k-- > 1){
            q.poll();
        }
        return q.poll();
    }
}
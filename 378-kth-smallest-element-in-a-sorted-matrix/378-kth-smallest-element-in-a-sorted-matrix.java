class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> q = new PriorityQueue<Tuple>((a,b) -> a.val - b.val);
        for(int i = 0; i < n; i++){
            q.offer(new Tuple(0, i, matrix[0][i]));
        }
        
        for(int i = 0; i < k -1; i++){
            Tuple t = q.poll();
            if(t.x == n - 1) continue;
            q.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
        }
        return q.poll().val;
    }
}

class Tuple{
    int x, y, val;
    public Tuple(int x, int y, int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
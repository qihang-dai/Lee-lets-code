class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int rightbound = n - 1, leftbound = 0;
        int lowerbound = m - 1, upbound = 0;
        List<Integer> res = new ArrayList();
        while(res.size() < m * n){
            for(int i = leftbound; i <= rightbound && res.size() < n * m; i++){
                res.add(matrix[upbound][i]);
            }
            upbound++;

            for(int i = upbound; i <= lowerbound && res.size() < n * m; i++){
                res.add(matrix[i][rightbound]);
            }
            rightbound--;
            
            for(int i = rightbound; i >= leftbound && res.size() < n * m; i--){
                res.add(matrix[lowerbound][i]);
            }
            lowerbound--;
            
            for(int i = lowerbound; i >= upbound && res.size() < n * m; i--){
                res.add(matrix[i][leftbound]);
            }
            leftbound++;
        }
        return res;
        
        
    }
}
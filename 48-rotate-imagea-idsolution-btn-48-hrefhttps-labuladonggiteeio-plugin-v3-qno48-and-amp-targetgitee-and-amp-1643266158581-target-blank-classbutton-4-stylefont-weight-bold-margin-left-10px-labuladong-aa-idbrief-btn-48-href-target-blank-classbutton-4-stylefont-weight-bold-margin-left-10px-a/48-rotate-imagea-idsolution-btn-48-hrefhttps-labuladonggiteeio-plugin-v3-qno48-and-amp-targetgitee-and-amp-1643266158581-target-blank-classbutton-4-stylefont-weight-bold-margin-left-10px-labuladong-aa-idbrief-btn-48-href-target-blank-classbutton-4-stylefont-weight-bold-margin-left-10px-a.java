class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){ //镜像反转， 需要j < i 沿着对角线
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        
        for(int i = 0; i < n; i++){ 
            for(int j = 0; j < n/2; j++){ //对称反转， 奇数偶数都是小于2/n
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1]; // 也可以看做是 (n - 1) - j， 二者相加index为n-1，确实对称
                matrix[i][n - j - 1] = tmp;
            }
        }
        
        
    }
}
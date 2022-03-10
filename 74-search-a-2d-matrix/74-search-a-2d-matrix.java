class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = m * n;
        while(i < j){
            int mid = (i + j)/2;
            int x = mid / n, y = mid % n;
            if(matrix[x][y] > target){
                j = mid;
            }else if (matrix[x][y] < target){
                i = mid + 1;
            }else{
                return true;
            }
            
        }
        return false;
    }
}
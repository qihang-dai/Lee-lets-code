class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        
        maxLeft[0] = height[0];
        for(int i = 1; i < n; i++){
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }
        
        maxRight[n - 1] = height[n - 1];
        for(int i = n - 2; i >= 0; i--){
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }
        
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += Math.min(maxRight[i], maxLeft[i]) - height[i];
        }
        return sum;
        
    }
}
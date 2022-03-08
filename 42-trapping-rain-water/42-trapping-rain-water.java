class Solution {
    public int trap(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack();
        for(int i = 0; i < height.length; i++){
            //由此保证栈内小的都Pop掉，只有单调递减
            while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                int mid = stack.pop();
                if(stack.isEmpty()) break;
                int left = stack.peek();
                int right = i;
                sum += ((right - left) - 1) * (Math.min(height[left], height[right]) - height[mid]);
            }
            stack.push(i);
        }
        return sum;
        
    }
}
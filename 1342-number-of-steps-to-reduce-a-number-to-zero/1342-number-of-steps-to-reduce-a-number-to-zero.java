class Solution {
    public int numberOfSteps(int num) {
        if(num == 0) return 0;
        int res = 0;
        while(num > 0){
            res += (num & 1) == 0 ? 1 : 2;
            num = num >> 1;
        }
        
        //we will end up at 2/2 = 1, this step is odd, so extra 1 need to be substract
        return res - 1;
        
    }
}
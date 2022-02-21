class Solution {
    public double myPow(double x, int n) {
        long b = n;

        if(n < 0){
            b = -b;
            x = 1/x;
        }
        
        double res = 1;
        while(b > 0){
            if(b % 2 > 0){
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        
        return res;
    }
}
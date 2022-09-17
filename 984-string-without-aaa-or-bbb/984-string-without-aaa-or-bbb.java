class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder res = new StringBuilder();
        int totalLen = a + b;
        int A = 0, B = 0; //连续计数器
        for(int i = 0; i < totalLen; i++){
            if((a >= b) && A < 2 || a > 0 && B == 2){
                res.append('a');
                a--;
                A++;
                B = 0;
            }else if( b >= a && B != 2 || b > 0 && A == 2){
                res.append('b');
                b--;
                B++;
                A = 0;
            }
        }
        return res.toString();
        
    }
}
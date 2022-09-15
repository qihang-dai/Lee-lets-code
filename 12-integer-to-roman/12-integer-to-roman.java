class Solution {
    public String intToRoman(int num) {
        int[] val = new int[]{1000, 500, 100, 50, 10, 5, 1};
        char[] sig = new char[]{'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        
        StringBuilder res = new StringBuilder();
        
        for(int n = 0; n < 7; n+=2){
            int x = num/val[n];
            if(x < 4){
                for(int i = 1; i <= x; i++) res.append(sig[n]);
            }else if(x == 4){
                res.append(sig[n]).append(sig[n - 1]);
            }else if(x == 9){
                res.append(sig[n]).append(sig[n - 2]);
            }else{
                res.append(sig[n - 1]);
                for(int i = 6; i <= x; i++){
                    res.append(sig[n]);
                }
            }
            
            num %= val[n];
        }
        
        return res.toString();
    }
        
}
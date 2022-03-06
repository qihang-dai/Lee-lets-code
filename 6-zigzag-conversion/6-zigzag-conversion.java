class Solution {
    public String convert(String s, int numRows) {
        char[] A = s.toCharArray();
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++){
            sb[i] = new StringBuilder();
        }
        StringBuilder res = new StringBuilder();
        int i = 0;
        int len = s.length();
        while(i < len){
            for(int idx = 0; idx < numRows && i < len; idx ++){
                sb[idx].append(A[i++]);
            }
            for(int idx = numRows - 2; idx >= 1 && i < len; idx --){
                sb[idx].append(A[i++]);
            }      
        }
        for(StringBuilder t : sb){
            res.append(t);
        }
        return res.toString();

    }
}
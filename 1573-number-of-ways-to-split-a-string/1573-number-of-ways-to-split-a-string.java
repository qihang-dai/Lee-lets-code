class Solution {
    public int numWays(String s) {
        int m = 1_000_000_007;
        char[] A = s.toCharArray();
        int n = A.length;
        int ones = 0;
        for(int a : A){
            if(a - '0' == 1) ones++;
        }
        if(ones % 3 != 0) return 0;
        if(ones == 0) return (int) ((n - 1L) * (n - 2L)/2 % m);
        
        int count = 0, firstCut = ones/3;
        long waysFirst = 0, waysSecond = 0;
        for(int i = 0; i < n; i++){
            count += A[i] - '0';
            if(count == firstCut){
                waysFirst++;
            }else if (count == 2 * firstCut){
                waysSecond++;
            }
        }
        return (int) (waysFirst * waysSecond % m);
        
    }
}
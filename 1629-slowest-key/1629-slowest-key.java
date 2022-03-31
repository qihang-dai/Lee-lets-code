class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int n = releaseTimes.length;
        int[] pre = new int[n];
        int max = releaseTimes[0];
        for(int i = 1; i < n; i++){
            pre[i] = releaseTimes[i] - releaseTimes[i - 1];
            max = Math.max(pre[i], max);
        }
        pre[0] = releaseTimes[0];
        
        char res = 'a';
        for(int i = 0; i < n; i++){
            char c = keysPressed.charAt(i);
            if(pre[i] == max && c > res){
                res = c;
            }
        }
        return res;
        
    }
}
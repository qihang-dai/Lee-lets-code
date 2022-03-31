class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int n = releaseTimes.length;
        int[] pre = new int[n];
        int max = releaseTimes[0];
        pre[0] = releaseTimes[0];
        char res = keysPressed.charAt(0);
        for(int i = 1; i < n; i++){
            int diff = releaseTimes[i] - releaseTimes[i - 1];
            char c = keysPressed.charAt(i);

            if(diff > max){
                max = diff;
                res = c;
            }
            
            if(diff == max && c > res){
                res = c;
            }
        }
        return res;
        
    }
}
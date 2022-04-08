class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int n = sentence.length;
        int[] times = new int[n];
        int[] nextWord = new int[n];
        for(int i = 0; i < n; i++){
            int cur = i;
            int curLen = 0;
            int curTime = 0;
            while(curLen + sentence[cur].length() <= cols){
                curLen = curLen + sentence[cur].length() + 1;
                cur++;
                if(cur == n){
                    curTime++;
                    cur = 0;
                }
            }
            times[i] = curTime;
            nextWord[i] = cur;
        }
        
        int res = 0;
        int start = 0;
        for(int i = 0; i < rows; i++){
            res += times[start];
            start = nextWord[start];
        }
        
        return res;
    }
}
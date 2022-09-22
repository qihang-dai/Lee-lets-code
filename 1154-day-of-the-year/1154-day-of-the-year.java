class Solution {
    public int dayOfYear(String da) {
        int[] days=new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        String[] date = da.split("-");
        int y = Integer.valueOf(date[0]);
        int m = Integer.valueOf(date[1]);
        int d = Integer.valueOf(date[2]);
        
        int res = 0;
        
        for(int i = 1 ; i < m; i++){
            res += days[i - 1];
        }
        
        if(m > 2){
            if(y % 400 == 0 || (y % 4 == 0 && y % 100 != 0)) res++;
        }
        
        res += d;
        
        return res;

    }
}
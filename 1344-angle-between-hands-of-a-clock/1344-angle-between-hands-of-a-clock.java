class Solution {
    public double angleClock(int hour, int minutes) {
        double h = hour + minutes/60.0;
        double ah = h * 360/12;
        double am = minutes * 360/60;
        double res = Math.abs(ah - am);
        if(360 - res < res){
            return 360 - res;
        }else{
            return res;
        }
        
        
    }
}
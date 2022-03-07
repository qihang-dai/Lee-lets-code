class Solution {
    public int myAtoi(String s) {
        int i = 0, base = 0, len = s.length(), sign = 1;
        while(i < len && s.charAt(i) == ' '){
            i++;
        }
        if(i < len && (s.charAt(i) == '+' || s.charAt(i) == '-')){
            sign = s.charAt(i++) == '+' ? 1 : -1;
        }
        while(i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
            if(base > Integer.MAX_VALUE/10 || 
               (base == Integer.MAX_VALUE/10 && s.charAt(i) - '0' > Integer.MAX_VALUE%10)){
                return sign == 1? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            base = base * 10 +s.charAt(i++) - '0';
        }
        return base * sign;
        
    }
}
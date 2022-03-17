class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int m = s.length();
        for(int i = m/2; i > 0; i--){
            if(m % i == 0){
                int count = m / i;
                String sub = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                while(count > 0){
                    sb.append(sub);
                    count--;
                }
                if(sb.toString().equals(s)) return true;
            }
        }
        return false;
        
    }
}
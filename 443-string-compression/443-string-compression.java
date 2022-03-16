class Solution {
    public int compress(char[] chars) {
        int start = 0;
        int i = 0;
        while(i < chars.length){
            char curChar = chars[i];
            int count = 0;

            while(i < chars.length && chars[i] == curChar){
                count++;
                i++;
            }
            chars[start++] = curChar;

            if(count != 1){
                for(char c : Integer.toString(count).toCharArray()){
                    chars[start++] = c;
                }
            }
        }
        return start;
        
        
    }
}
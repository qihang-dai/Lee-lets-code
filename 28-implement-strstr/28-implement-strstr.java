class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0) return 0;
        for(int i = 0; i < haystack.length(); i++){
            int j = i;
            int index = 0;
            while(j < haystack.length() && index < needle.length() && haystack.charAt(j) == needle.charAt(index)){
                if(index == needle.length() - 1) return i;
                j++;
                index++;
            }
        }
        return -1;
        
    }
}
class Solution {
    String[] mapping = new String[] {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    
    List<String> res = new ArrayList();
    
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return res;
        }
        backtrack(digits, 0);
        return res;
    }
    
    public void backtrack(String digits, int start){
        if(start == digits.length()){
            res.add(sb.toString());
            return;
        }
        String cur = mapping[digits.charAt(start) - '0'];
        for(int j = 0; j < cur.length(); j++){
            sb.append(cur.charAt(j));
            backtrack(digits, start + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        
    }
}
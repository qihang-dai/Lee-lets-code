class Solution {
    String[] mapping = new String[] {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    
    List<String> res = new ArrayList();
    
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return res;
        }
        backtrack(digits, 0, new StringBuilder());
        return res;
    }
    
    public void backtrack(String digits, int start, StringBuilder sb){
        if(sb.length() == digits.length()){
            res.add(sb.toString());
            return;
        }
        for(int i = start; i < sb.length() + 1; i++){
            String cur = mapping[digits.charAt(i) - '0'];
            for(int j = 0; j < cur.length(); j++){
                sb.append(cur.charAt(j));
                backtrack(digits, start + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
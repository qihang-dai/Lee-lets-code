class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        dfs(res, "", 0, 0, n);
        return res;
    }
    public void dfs(List<String> res, String sb, int left, int right, int n){
        if(sb.length() == n * 2){
            res.add(sb);
            return;
        }
        if(left < n){
            dfs(res,sb + '(', left + 1, right, n);
        }
        if(right < left){
            dfs(res,sb + ')', left, right + 1, n);
        }
        
    }
}

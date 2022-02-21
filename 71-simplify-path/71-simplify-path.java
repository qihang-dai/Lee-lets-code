class Solution {
    public String simplifyPath(String path) {
        StringBuilder res = new StringBuilder();
        Stack<String> stack = new Stack();
        Set<String> skip = new HashSet(Arrays.asList("", ".", ".."));
        for(String s : path.split("/")){
            if(s.equals("..") && !stack.isEmpty()){
                stack.pop(); //stack适合这种末端删除
            }else if(!skip.contains(s)){
                stack.push(s);
            }
        }
        for(String s : stack){//FIFO traverse
            res.append("/").append(s);
        }
        if(res.length() == 0) return "/";
        return res.toString();
    }
}
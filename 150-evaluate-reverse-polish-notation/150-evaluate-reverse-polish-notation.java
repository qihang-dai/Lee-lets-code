class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for(String s : tokens){
            if(s.matches("-?\\d+")){
                stack.push(Integer.valueOf(s));
            }else{
                int second = stack.pop();
                int first = stack.pop();
                int tmp = 0;
                if(s.equals("+")){
                    tmp = first + second;
                }else if(s.equals("-")){
                    tmp = first - second;
                }else if(s.equals("/")){
                    tmp = first / second;
                }else if(s.equals("*")){
                    tmp = first * second;
                }else{
                    System.err.println("bad operator");
                }
                stack.push(tmp);
            }
        }
        return stack.pop();
    }
}
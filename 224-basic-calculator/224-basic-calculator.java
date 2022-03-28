class Solution {
    int i = 0;
    public int calculate(String s) {
        Deque<Character> deque = new ArrayDeque();
        for(char c: s.toCharArray())
            if(c != ' ') 
                deque.add(c);
        return helper(deque);
    }
    
    public int helper(Deque<Character> deque){
        int num = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<Integer>();
        while(!deque.isEmpty()){
            char c = deque.pollFirst();
            if(c == '(') 
                num = helper(deque);

            if(c >= '0' && c <= '9')
                num = num * 10 + (c - '0');
            
            if(!Character.isDigit(c) || deque.size() == 0){

                    //必须加括号
                if(sign == '+')
                    stack.push(num);
                else if(sign == '-')
                    stack.push(-num);
                else if(sign == '*')
                    stack.push(stack.pop() * num);
                else if(sign == '/')
                    stack.push(stack.pop() / num);
                
                num = 0;
                sign = c;
            }
            if(c == ')') 
                break;

        }
        
        int res = 0;
        for(int i : stack){
            res += i;
        }
        return res;
        
    }
    
    
}
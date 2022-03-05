class Solution {
    public int calculate(String s) {
        /*
Solution is correct, sign variable is updated after stack.push(stack.pop()*num);
sign is not reflecting the current sign but the previous one , so at that point num is already known.
lets say + a * b - c ... So it pushes +a into the stack when it encounters * and assign the sign to * after that , then it calculates b ...and when it encounters - it pops a out and does the multiplication and pushes it back into stack. Hope that helps.
        */
        int res = 0;
        Stack<Integer> stack = new Stack();
        char sign = '+';
        int i = 0;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                res = res * 10 + (c - '0');//处理连续数字
            }
            
            //然而空格会进入这个 if 语句，但是我们并不想让空格的情况进入这个 if，因为这里会更新sign并清零nums，空格根本就不是运算符，应该被忽略。
            if((!Character.isDigit(c) && c != ' ')|| i == s.length() - 1){
                //处理前一个符号和当前字符
                if(sign == '+'){
                    stack.push(res);
                }
                if(sign == '-'){
                    stack.push(-res);
                }

                //和stack前一个结果结合
                //乘除法优先于加减法体现在，乘除法可以和栈顶的数结合，而加减法只能把自己放入栈。
                if(sign == '*'){
                    stack.push(stack.pop()*res);
                }
                if(sign == '/'){
                    stack.push(stack.pop()/res);
                }

                res = 0;
                sign = c;
            }
            i++;

        }
        
        for(int j : stack){
            res += j;
        }
        return res;
        
    }
}
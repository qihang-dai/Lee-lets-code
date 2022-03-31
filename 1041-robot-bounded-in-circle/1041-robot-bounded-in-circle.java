class Solution {
    public boolean isRobotBounded(String instructions) {
        int i = 0;
        int x = 0;
        int y = 0;
        int[][] dir = {{0,1}, {1, 0}, {0, -1}, {-1, 0}};
        for(char c : instructions.toCharArray()){
            if(c == 'L'){
                i = (i + 1) % 4;
            }else if (c == 'R'){
                i = (i + 3) % 4;
            }else{
                x += dir[i][0];
                y += dir[i][1];
            }
            
        }
        
        return x==0 && y==0 || i != 0;
        
    }
}
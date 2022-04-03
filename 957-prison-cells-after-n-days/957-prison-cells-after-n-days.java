class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        
        boolean hasCycle = false;
        Set<String> set = new HashSet();
        int cycle = 0;
        for(int i = 0; i < n; i++){
            int[] next = next(cells);
            String key = Arrays.toString(next);
            if(set.contains(key)){
                hasCycle = true;
                break;
            }else{
                set.add(key);
                cycle++;
            }
            
            cells = next;
        }
        
        if(hasCycle){
            n%=cycle;
            for(int i=0;i<n;i++){
                cells = next(cells);
            }   
        }

        return cells;
        
    }
    
    
    private int[] next(int[] cells){
        int[] tmp = new int[cells.length];
        for(int i=1;i<cells.length-1;i++){
            tmp[i]=cells[i-1]==cells[i+1]?1:0;
        }
        return tmp;
    }
}
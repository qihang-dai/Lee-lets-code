class UF{
    int size;
    Map<Integer, Integer> father;
    
    UF(){
        father = new HashMap<Integer,Integer>();
        size = 0;
    }
    
    void add(int x){
        if(!father.containsKey(x)){
            father.put(x, null);
            size++;
        }
    }
    
    void merge(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY){
            father.put(rootX, rootY);
            size--;
        }
    }
    
    int find(int x){
        int root = x;
        while(father.get(root) != null){
            root = father.get(root);
        }
        while(x != root){
            int of = father.get(x);
            father.put(x, root);
            x = of;
        }
        return root;
    }
    
    boolean isConnected(int x, int y){
        return find(x) == find(y);
    }
    
    int size(){
        return size;
    }
    
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        UF uf = new UF();
        for(int i = 0; i < isConnected.length; i++){
            uf.add(i);
            for(int j = 0; j < i; j++){
                if(isConnected[i][j] == 1){
                    uf.merge(i, j);
                }
            }
        }
        return uf.size();
        
    }
}
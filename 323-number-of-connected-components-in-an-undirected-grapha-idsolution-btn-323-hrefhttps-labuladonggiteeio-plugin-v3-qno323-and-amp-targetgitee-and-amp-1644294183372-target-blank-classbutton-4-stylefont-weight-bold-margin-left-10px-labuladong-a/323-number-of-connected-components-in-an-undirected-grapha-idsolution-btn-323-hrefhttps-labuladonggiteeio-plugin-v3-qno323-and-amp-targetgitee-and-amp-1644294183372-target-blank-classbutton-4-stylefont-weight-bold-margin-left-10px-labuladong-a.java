class UF{
    int size;
    int[] root;
    int[] rank;
    UF(int n){
        size = n;
        root = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++){
            root[i] = i;
            rank[i] = i;
        }
    }
    
    int find(int x){
        if(root[x] == x){
            return x;
        }
        
        return root[x] = find(root[x]);
        
    }
    
    void union(int p, int q){
         int rootp = find(p);
        int rootq = find(q);
        if(rootp != rootq){
            size--;
            if(rank[rootp] > rank[rootq]){
                root[rootq] = rootp;
                
            }else if(rank[rootp] < rank[rootq]){
                root[rootp] = rootq;  
                
            }else{
                root[rootp] = rootq;
                rank[rootq]++;
            }
        }
        
    }
    
    int size(){
        return size;
    }
}
class Solution {
    public int countComponents(int n, int[][] edges) {
        UF uf = new UF(n);
        for(int[] edge : edges){
            uf.union(edge[0], edge[1]);
        }
        return uf.size();
        
    }
}
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int count = 0;
        Map<Integer,Integer> map = new HashMap();
        for(int i = 0; i < points.length; i++){
            for(int j = 0; j < points.length; j++){
                if(i == j) continue;
                int d = getDistance(points[i], points[j]);
                map.put(d, map.getOrDefault(d, 0) + 1);
            }
            for(int val : map.values()){
                count += val * (val - 1);
            }
            map.clear();
        }
        return count;
        
    }
    
    public int getDistance(int[] p1, int[] p2){
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
        
    }
}
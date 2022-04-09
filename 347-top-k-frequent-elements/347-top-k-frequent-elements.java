class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        List<Integer>[] buckets = new List[nums.length + 1];
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int val = entry.getValue();
            if(buckets[val] == null){
                buckets[val] = new LinkedList<>();
            }
            buckets[val].add(entry.getKey());
        }
        
        int[] res = new int[k];
        int id = 0;
        
        for(int i = buckets.length - 1; i > 0; i --){
            if(buckets[i] != null){
                for (int elem: buckets[i]){
                    res[id++] = elem;
                    if(id == k) return res;
                }  
            }
        }
        
        return res;
    }
}


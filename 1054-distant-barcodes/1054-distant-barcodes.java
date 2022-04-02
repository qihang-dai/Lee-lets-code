class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap();
        for(int i : barcodes){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> -a.getValue() + b.getValue());
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.add(entry);
        }
        int i = 0;
        while(!pq.isEmpty()){
            Map.Entry<Integer, Integer> entry = pq.poll();
            int key = entry.getKey();
            int val = entry.getValue();
            while(val > 0){
                barcodes[i] = key;
                i += 2;
                if(i >= barcodes.length){
                    i = 1;
                }
                val--;
            }
        }
        return barcodes;
    }
}
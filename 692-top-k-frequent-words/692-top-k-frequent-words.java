class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList();
        Map<String, Integer> result = new HashMap<>();
        for (String word : words) {
            if (result.containsKey(word)) {
                // the word is already in the map, increment the count
                int count = result.get(word) + 1;
                result.put(word, count);
            } else {
                result.put(word, 1);
            }
        }
        
        PriorityQueue<Map.Entry<String,Integer>> pq
            = new PriorityQueue<>((a,b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
        
        for(Map.Entry<String, Integer> entry : result.entrySet()){
            pq.add(entry);
        }
        
        while(k > 0 && !pq.isEmpty()){
            k--;
            res.add(pq.poll().getKey());
        }
        return res;
        
        
    }
    
}
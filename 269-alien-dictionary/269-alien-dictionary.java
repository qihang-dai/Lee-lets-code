class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap();
        Map<Character, Integer> degree = new HashMap();
        StringBuilder res = new StringBuilder();
        for(String word : words){
            for(char c : word.toCharArray()){
                degree.put(c, 0);
            }
        }
        
        for(int i = 0; i< words.length - 1; i++){
            String cur = words[i];
            String next = words[i + 1];
            if(cur.length() > next.length() && cur.startsWith(next)) return "";
            int len  = Math.min(cur.length(), next.length());
            for(int j = 0; j < len; j++){
                char c1 = cur.charAt(j);
                char c2 = next.charAt(j);

                if(c1 != c2){
                    Set set = map.get(c1);
                    if(set == null) set = new HashSet();
                    if(!set.contains(c2)){
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2) + 1);
                        
                    }
                    break;
                }
            }
        }
        
        Queue<Character> q = new LinkedList();
        for(char c : degree.keySet()){
            if(degree.get(c) == 0) q.offer(c);
        }
        
        while(!q.isEmpty()){
            char cur = q.poll();
            res.append(cur);
            if(map.containsKey(cur)){
                for(char c : map.get(cur)){
                    degree.put(c, degree.get(c) - 1);
                    if(degree.get(c) == 0) q.offer(c);
                }  
            }

        }
// res.length should equal the size of distinct characters, otherwise a cycle must exist 
        if(res.length() != degree.size()) return ""; 
        return res.toString();
        
        
    }
}
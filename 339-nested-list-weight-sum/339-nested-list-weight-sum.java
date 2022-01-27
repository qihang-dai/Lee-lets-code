/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    
    public int depthSum(List<NestedInteger> nestedList) {
        Queue<NestedInteger> que = new LinkedList();
        for(NestedInteger n : nestedList){
            que.offer(n);
        }
        int sum = 0;
        int depth = 0;
        while(!que.isEmpty()){
            int size = que.size();
            depth++;
            for (int i = 0; i < size; i++){
                NestedInteger cur = que.poll();
                if(cur.isInteger()){
                    sum += depth * cur.getInteger();
                }else{
                    List<NestedInteger> children = cur.getList();
                    for (NestedInteger child : children){
                        que.offer(child);
                    }
                }
            }
        }
        return sum;
        
    }
}
class Solution {
    //A priority queue is unbounded, but has an internal capacity governing the size of an array used to store the elements on the queue. It is always at least as large as the queue size. As elements are added to a priority queue, its capacity grows automatically.
    
    //https://stackoverflow.com/questions/67597571/initial-capacity-of-priority-queue-in-java
    public int findKthLargest(int[] nums, int k) {
        //pq默认是小顶堆，堆顶是最小元素。堆顶多了删除堆顶，留下的会越来越大，最后堆顶是倒数第K大的元素
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int n : nums){
            pq.add(n);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}
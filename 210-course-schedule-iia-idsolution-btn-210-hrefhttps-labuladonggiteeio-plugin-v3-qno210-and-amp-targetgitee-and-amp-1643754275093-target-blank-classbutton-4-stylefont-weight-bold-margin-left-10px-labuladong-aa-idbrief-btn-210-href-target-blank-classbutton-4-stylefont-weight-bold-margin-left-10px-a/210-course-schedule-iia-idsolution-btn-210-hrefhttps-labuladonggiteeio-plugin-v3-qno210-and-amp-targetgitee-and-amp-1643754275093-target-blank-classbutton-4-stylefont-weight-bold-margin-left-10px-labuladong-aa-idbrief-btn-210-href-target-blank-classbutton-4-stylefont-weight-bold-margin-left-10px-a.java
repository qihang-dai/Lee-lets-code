class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //https://zhuanlan.zhihu.com/p/135094687
        int[] res = new int[numCourses];
        int[] indegree = new int[numCourses]; 
        for(int[] pre : prerequisites){
            indegree[pre[0]]++;
        }
        
        Queue<Integer> que = new LinkedList();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) que.offer(i);
        }
        
        int i = 0;
        while(!que.isEmpty()){
            int cur = que.poll();
            res[i++] = cur;
            for(int[] pre : prerequisites){
                if(pre[1] == cur){
                    indegree[pre[0]]--;
                    if(indegree[pre[0]] == 0){
                        que.offer(pre[0]);
                    }
                }

            }
        }
        
        return i == numCourses ? res : new int[]{};
        
    }

}
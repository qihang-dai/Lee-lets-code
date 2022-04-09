class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList();
        int left = 0;
        int right = arr.length - 1;
        int center = -1;
        while(left < right - 1){
            int mid = left + (right - left)/2;
            if(arr[mid] == x){
                center = mid;
                break;
            }else if(arr[mid] > x){
                right = mid;
            }else{
                left = mid;
            }
        }
        
        if(center == -1){
            if(Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)){
                center = left;
            }else{
                center = right;
            }
        }

        
        int count = 0;
        int l = center - 1;
        int r = center + 1;
        while(count < k - 1){
            if(l < 0){
                r++;
            }else if(r >= arr.length){
                l--;
            }else if (Math.abs(arr[l] - x) <= Math.abs(arr[r] -x)){
                l--;
            }else{
                r++;
            }
            count++;
        }
        
        for(int i = l + 1; i < r ; i++){
            res.add(arr[i]);
        }
        return res;
    }
}
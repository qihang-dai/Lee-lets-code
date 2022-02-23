class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, h = arr.length - 1;
        while(l < h){
            int m = (l + h)/2;
            int m1 = m + 1;
            if(arr[m] < arr[m1]){
                l = m1;
            }else{
                h = m;
            }
        }
        return l;
    }
}
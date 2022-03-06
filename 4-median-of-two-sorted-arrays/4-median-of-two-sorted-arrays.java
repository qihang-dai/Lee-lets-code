class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int m1 = (m + n + 1)/2; //median, we need to round up for odd length
        int m2 = (m + n + 2)/2;
        return 0.5 * (getK(0, nums1, 0, nums2, m1) + getK(0, nums1, 0, nums2, m2));
        
        
    }
    
    //get the kth number from the two array;
    public double getK(int s1, int[] nums1, int s2, int[] nums2, int k){
        if(s1 > nums1.length - 1) return nums2[s2 + k - 1]; //kth number including the start;
        if(s2 > nums2.length - 1) return nums1[s1 + k - 1];
        if(k == 1) return Math.min(nums1[s1], nums2[s2]);
        int amid = Integer.MAX_VALUE;
        int bmid = Integer.MAX_VALUE;
        if(s1 + k/2 - 1 < nums1.length) amid = nums1[s1 + k/2 - 1];
        if(s2 + k/2 - 1 < nums2.length) bmid = nums2[s2 + k/2 - 1];
        if(amid < bmid){
            return getK(s1 + k/2, nums1, s2, nums2, k - k/2);
        }else{
            return getK(s1, nums1, s2 + k/2, nums2, k - k/2);
        }
    }
}
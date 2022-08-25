class Solution {
    public int triangularSum(int[] A) {

        for(int i = A.length; i > 1; i--){ //every level, the count would decrease one.
            for(int j = 0; j < i - 1; j++){ // this is the next level, so size is i-1
                A[j] = (A[j] + A[j + 1]) % 10;
            }
        }

        return A[0];
    }
}
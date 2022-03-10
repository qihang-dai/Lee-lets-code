class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[] res = new Integer[rowIndex + 1];
        Arrays.fill(res, 0);
        res[0] = 1;
        for(int i = 1; i < rowIndex + 1; i++){
            for(int j = i; j >= 1; j --){
                res[j] += res[j - 1];
            }
        }
        return Arrays.asList(res);
    }
}
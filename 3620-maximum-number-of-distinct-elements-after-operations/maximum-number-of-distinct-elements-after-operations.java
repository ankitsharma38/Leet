class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        //using long for avaoiding overflow
        long last = Long.MIN_VALUE;
        int distinct = 0;

        for(int num : nums){
            long start = (long) num - k;
            long end = (long) num +k;
            long candidate  = Math.max(start, last + 1);

            if(candidate <= end){
                distinct++;
                last = candidate;
            }
        }
        return distinct;
    }
}
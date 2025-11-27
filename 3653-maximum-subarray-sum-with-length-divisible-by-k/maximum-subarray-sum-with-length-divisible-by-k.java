class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] minPrefix = new long[k];
        
        // Initializing with large numr
        Arrays.fill(minPrefix, Long.MAX_VALUE);
        
        long prefix = 0;
        long answer = Long.MIN_VALUE;
        
        // prefix[0] = 0 → remainder = 0
        minPrefix[0] = 0;
        
        for (int i = 0; i < n; i++) {
            prefix += nums[i];   // build prefix sum
            
            int rem = (i + 1) % k; // prefix index is (i+1)
            
            // Check best candidate
            if (minPrefix[rem] != Long.MAX_VALUE) {
                answer = Math.max(answer, prefix - minPrefix[rem]);
            }
            
            // Update minimum prefix with same remainder
            minPrefix[rem] = Math.min(minPrefix[rem], prefix);
        }
        
        return answer;
    }
}

class Solution {
    public int minOperations(int[] nums, int k) {
        long sum = 0;
        for (int n : nums) sum += n;

        int r = (int)(sum % k);
        if (r == 0) return 0;
        return r;
    }
}

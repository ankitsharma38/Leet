class Solution {
    public int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int x : nums) total += x;
        int need = (int)(total % p);
        if (need == 0) return 0;

        Map<Integer, Integer> seen = new HashMap<>();
        seen.put(0, -1);

        long prefix = 0;
        int best = nums.length;

        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i]) % p;
            int target = (int)((prefix - need + p) % p);

            if (seen.containsKey(target)) {
                best = Math.min(best, i - seen.get(target));
            }
            seen.put((int)prefix, i);
        }

        return best == nums.length ? -1 : best;
    }
}

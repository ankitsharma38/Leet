class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.getOrDefault(num, 0) == n - 1) return num;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return 0;
    }
}
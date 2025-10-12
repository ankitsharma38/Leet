class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Long> damageMap = new HashMap<>();

        for (int p : power) {
            damageMap.put(p, damageMap.getOrDefault(p, 0L) + p);
        }

        List<Integer> values = new ArrayList<>(damageMap.keySet());
        Collections.sort(values);

        int n = values.size();
        long[] dp = new long[n];
        dp[0] = damageMap.get(values.get(0));

        for (int i = 1; i < n; i++) {
            long currDamage = damageMap.get(values.get(i));
            int j = i - 1;

            while (j >= 0 && values.get(i) - values.get(j) <= 2) {
                j--;
            }

            long include = currDamage + (j >= 0 ? dp[j] : 0);
            long exclude = dp[i - 1];

            dp[i] = Math.max(include, exclude);
        }

        return dp[n - 1];
    }
}

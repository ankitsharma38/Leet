class Solution {

    int[][] mx, mn;
    int[] lg;

    long value(int l, int r) {
        int len = r - l + 1;
        int p = lg[len];

        int maxi = Math.max(mx[p][l], mx[p][r - (1 << p) + 1]);
        int mini = Math.min(mn[p][l], mn[p][r - (1 << p) + 1]);

        return (long) maxi - mini;
    }

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;

        lg = new int[n + 1];
        for (int i = 2; i <= n; i++)
            lg[i] = lg[i / 2] + 1;

        int m = lg[n] + 1;

        mx = new int[m][n];
        mn = new int[m][n];

        for (int i = 0; i < n; i++) {
            mx[0][i] = nums[i];
            mn[0][i] = nums[i];
        }

        for (int p = 1; p < m; p++) {
            int len = 1 << p;
            int half = len >> 1;

            for (int i = 0; i + len <= n; i++) {
                mx[p][i] = Math.max(mx[p - 1][i],
                                    mx[p - 1][i + half]);

                mn[p][i] = Math.min(mn[p - 1][i],
                                    mn[p - 1][i + half]);
            }
        }

        PriorityQueue<long[]> pq =
            new PriorityQueue<>((a, b) ->
                Long.compare(b[0], a[0]));

        for (int l = 0; l < n; l++) {
            pq.offer(new long[]{
                value(l, n - 1), l, n - 1
            });
        }

        long ans = 0;

        while (k-- > 0) {
            long[] cur = pq.poll();

            long val = cur[0];
            int l = (int) cur[1];
            int r = (int) cur[2];

            ans += val;

            if (r > l) {
                pq.offer(new long[]{
                    value(l, r - 1), l, r - 1
                });
            }
        }

        return ans;
    }
}
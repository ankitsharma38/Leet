class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for (int b : batteries) sum += b;

        long left = 0, right = sum / n; 
       //aded here some upper limit chr 
        while (left < right) {
            long mid = right - (right - left) / 2;
            if (canRun(n, batteries, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
     return left;
    }

    private boolean canRun(int n, int[] batteries, long t) {
        long total = 0;
        for (int b : batteries) {
            total += Math.min((long) b, t);
        }
        return total >= t * n;
    }
}

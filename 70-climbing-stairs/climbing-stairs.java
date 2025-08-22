class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int a = 1, b = 2; // ways(1), ways(2)
        int result = 0;

        for (int i = 3; i <= n; i++) {
            result = a + b; // ways(n-1) + ways(n-2)
            a = b;  // shift forward
            b = result;
        }

        return result;
    }
}

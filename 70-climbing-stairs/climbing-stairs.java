class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        int fir = 1;  // ways(1)
        int sec = 2; // ways(2)
        
        for (int i = 3; i <= n; i++) {
            int third = fir + sec;
            fir = sec;
            sec = third;
        }
        return sec;
    }
}

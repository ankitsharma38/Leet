class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 1_000_000_007;

        int[][] prev = new int[n][k]; 
        int[][] curr = new int[n][k];

        for (int i = 0; i < m; i++) {
            // clear current row DP
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < k; y++) {
                    curr[x][y] = 0;
                }
            }

            for (int j = 0; j < n; j++) {
                int val = grid[i][j] % k;

                if (i == 0 && j == 0) {
                    curr[0][val] = 1;  
                } else {
                    // From above
                    if (i > 0) {
                        for (int r = 0; r < k; r++) {
                            int newR = (r + val) % k;
                            curr[j][newR] = (curr[j][newR] + prev[j][r]) % MOD;
                        }
                    }

                    // From left
                    if (j > 0) {
                        for (int r = 0; r < k; r++) {
                            int newR = (r + val) % k;
                            curr[j][newR] = (curr[j][newR] + curr[j - 1][r]) % MOD;
                        }
                    }
                }
            }

            // swap prev and curr
            int[][] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n - 1][0];
    }
}

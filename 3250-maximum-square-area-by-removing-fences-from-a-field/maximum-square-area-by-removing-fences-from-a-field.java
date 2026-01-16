class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        // Store all possible horizontal distances
        HashSet<Integer> set = new HashSet<>();
        set.add(m - 1); // Full height distance

        long max = 0;

        // Generate all horizontal fence distances
        for (int i = 0; i < hFences.length; i++) {
            int num = hFences[i];

            // Distances between fences
            for (int j = i + 1; j < hFences.length; j++) {
                set.add(Math.abs(num - hFences[j]));
            }

            // Distances from boundaries
            set.add(Math.abs(1 - num));
            set.add(m - num);
        }

        // Early check for maximum possible square
        if (set.contains(n - 1)) {
            max = n - 1;
            return (int)((max * max) % 1000000007);
        }

        // Check vertical distances against horizontal distances
        for (int i = 0; i < vFences.length; i++) {
            int num = vFences[i];

            for (int j = i + 1; j < vFences.length; j++) {
                int curr = Math.abs(num - vFences[j]);
                if (set.contains(curr)) {
                    max = Math.max(max, curr);
                }
            }
            // Boundary distances
            if (set.contains(num - 1)) max = Math.max(max, num - 1);
            if (set.contains(n - num)) max = Math.max(max, n - num);
        }

        // Return result or -1 if no square possible
        max = (max * max) % 1000000007;
        return (max != 0) ? (int) max : -1;
    }
}
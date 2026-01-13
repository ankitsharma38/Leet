class Solution {
    public double separateSquares(int[][] squares) {
        double low = Double.MAX_VALUE, high = Double.MIN_VALUE;
        double totalArea = 0;
        for (int[] s : squares) {
            double y = s[1], l = s[2];
            low = Math.min(low, y);
            high = Math.max(high, y + l);
            totalArea += l * l;
        }
        double target = totalArea / 2.0;
        for (int i = 0; i < 60; i++) {
            double mid = (low + high) / 2.0;
            double areaBelow = 0;
            for (int[] s : squares) {
                double y = s[1], l = s[2];
                if (mid > y) {
                    areaBelow += Math.min(l, mid - y) * l;
                }
            }
            if (areaBelow < target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
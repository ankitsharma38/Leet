class Solution {
    public int[][] merge(int[][] intervals) {
        // Step 1: sorting by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();

        // Step 2: merging intervals
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                // No overlap -> add interval
                merged.add(interval);
            } else {
                // Overlap -> merge with the last interval
                merged.get(merged.size() - 1)[1] = Math.max(
                    merged.get(merged.size() - 1)[1], 
                    interval[1]
                );
            }
        }

        // Step 3: converting  list back to array
        return merged.toArray(new int[merged.size()][]);
    }
}

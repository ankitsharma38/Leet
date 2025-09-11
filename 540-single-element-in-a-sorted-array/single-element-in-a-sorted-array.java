class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            // Make sure mid is even
            if (mid % 2 == 1) {
                mid--;
            }
            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2; // Pair is valid, go right
            } else {
                high = mid; // Pair is broken, go left
            }
        }
        return nums[low];
    }
}
class Solution {
    public int removeDuplicates(int[] nums) {
        // if (numslength == 0) return 0;
        
        int i = 0;  // pointer for last unique element
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1; // length of unique elements
    }
}
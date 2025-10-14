// class Solution {
//     public List<Integer> findDuplicates(int[] nums) {
        // List<Integer> resultSet = new ArrayList<>();

        // for (int i = 0; i < nums.length; i++) {
        //     // Get the index that this number corresponds to
        //     int index = Math.abs(nums[i]) - 1;

        //     // If the number at this index is already negative, we found a duplicate
        //     if (nums[index] < 0) {
        //         resultSet.add(index + 1);
        //     }

        //     // Flip the number at this index to negative to mark it as seen
        //     nums[index] = -nums[index];
        // }

        // return resultSet;
//     }
// }


class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> resultSet = new ArrayList<>();

        // Set to store unique numbers
        Set<Integer> uniqueSet = new HashSet<>();
        for (int num : nums) {

        // If already present, then it is a duplicate
        if (uniqueSet.contains(num))
            resultSet.add(num);

        // Add the number to the set
        uniqueSet.add(num);
        }

        return resultSet;
    }
}
import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList)); // add a copy
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue; // skip if already used
            used[i] = true;
            tempList.add(nums[i]);
            backtrack(result, tempList, nums, used);
            // backtrack
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }
}

//Timpe Complexity O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[] {map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        return null;
   }
}

//Time complexity = O(n2)

// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         for(int i =0; i<nums.length; i++){
//             for(int j=i+1; j<nums.length; j++){
//                 if(nums[i] + nums[j] == target){
//                     int a[] = {i,j};
//                     return a;
//                 }
//             }
//         }
//         return null;
//     }
// }
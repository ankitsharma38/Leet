class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        
        int maxProd = nums[0];
        int product = 1;
        
        // Left to right
        for (int i = 0; i < n; i++) {
            product *= nums[i];
            maxProd = Math.max(maxProd, product);
            if (product == 0) product = 1;  // reset when zero encountered
        }
        
        product = 1;
        
        // Right to left
        for (int i = n - 1; i >= 0; i--) {
            product *= nums[i];
            maxProd = Math.max(maxProd, product);
            if (product == 0) product = 1;
        }
        
        return maxProd;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
            // long MOD = 1_000_000_007
 *     }
 * }
 */
class Solution {
    long totalSum;
    long ans = 0;
    long MOD = 1_000_000_007;
    

    
    public int maxProduct(TreeNode root) {
        totalSum = dfs1(root);
        dfs2(root);
        return (int) (ans % MOD);




    }
    
    private long dfs1(TreeNode root){
        if(root == null) return 0;
        return root.val + dfs1(root.left) + dfs1(root.right);
    }
    
    private long dfs2(TreeNode root){
        if(root == null) return 0;
        long left = dfs2(root.left);
        long right = dfs2(root.right);
        long sum = root.val + left + right;
        ans = Math.max(ans, sum * (totalSum - sum));
        return sum;
    }
}
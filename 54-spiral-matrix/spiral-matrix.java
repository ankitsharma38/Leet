class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        List<Integer> ans = new ArrayList<>();
        
        int n = mat.length; // rows no...
        int m = mat[0].length; // columns oss.
        
        // initializing the pointers required for traversal.
        int top = 0, left = 0, bottom = n - 1, right = m - 1;

        // lloop until all elements are not traversed.
        while (top <= bottom && left <= right) {

            // move left to right
            for (int i = left; i <= right; i++)
                ans.add(mat[top][i]);

            top++;

            // move top to bottom.
            for (int i = top; i <= bottom; i++)
                ans.add(mat[i][right]);

            right--;

            // mov right to left.
            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    ans.add(mat[bottom][i]);

                bottom--;
            }

            //move bottom to top.
            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    ans.add(mat[i][left]);

                left++;
            }
        }
        return ans;
    }
}
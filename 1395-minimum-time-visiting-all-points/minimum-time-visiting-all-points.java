class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans =0;

        for(int i=0;i<points.length-1;i++)
        {
            int x1 = points[i][0];
            int x2 = points[i][1];

            int y1 = points[i+1][0];
            int y2 = points[i+1][1];

            int x_diff = Math.abs(y1-x1);
            int y_diff = Math.abs(y2-x2);

            int min = Math.min(x_diff,y_diff);
            int max = Math.max(x_diff,y_diff);

            ans+= (min+Math.abs(max-min));

        }
        return ans;
    }
}
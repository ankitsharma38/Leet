class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long maxSqLength=0;
        long maxArea=0; 
        int n=bottomLeft.length;
        for(int i=0; i<n; i++){
            // check for rectangles on right
            for(int j=i+1; j<n; j++){

                //first rectangle 
                long y11= bottomLeft[i][1],
                 y12=topRight[i][1],
                 x11=bottomLeft[i][0], 
                x12=topRight[i][0];

    //           second rectangle
                long y21=bottomLeft[j][1], 
                y22=topRight[j][1], 
                x21=bottomLeft[j][0], 
                x22=topRight[j][0];

                long breadth=Math.min(y12, y22)-Math.max(y11, y21);
                long length=Math.min(x12, x22)-Math.max(x11, x21);

                maxSqLength=Math.max(maxSqLength, Math.min(length, breadth));
            }
        }

        maxArea=maxSqLength*maxSqLength;
        return maxArea;
    }
}

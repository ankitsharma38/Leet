class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) ->
        a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]
        );

        int count =0;
        int a=-1, b=-1;
        for(int[] in : intervals){
            int L = in[0], R = in[1];

            if(b<L){
                count += 2;
                a= R - 1;
                b= R;
            }
            else if(a<L){
                count += 1;
                a=b;
                b=R;
            }
        }
        return count;
    }
}
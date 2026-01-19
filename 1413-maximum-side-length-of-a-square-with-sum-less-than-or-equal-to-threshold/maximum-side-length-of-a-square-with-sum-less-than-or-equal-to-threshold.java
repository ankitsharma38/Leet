class Solution {
    public int maxSideLength(int[][] mat, int t) {

        int m = mat.length ;
        int n = mat[0].length ;

        for(int i = 0 ; i < m ; i ++)
        {
            for(int j = 1 ; j < n ; j ++)
            {
                mat[i][j] += mat[i][j-1] ;
            }
        }

        for(int i = 1 ; i < m ; i ++)
        {
            for(int j = 0 ; j < n ; j ++)
            {
                mat[i][j] += mat[i-1][j] ;
            }
        }

        int max = 0 ;

        for(int i = 0 ; i < m ; i ++)
        {
            for(int j = 0 ; j < n ; j ++)
            {
                for(int k = max + 1 ; i + k -1 < m && j + k -1 < n ; k ++)
                {
                    int A = (i - 1 >= 0) && (j - 1 >= 0) ? mat[i-1][j-1] : 0 ;

                    int B = i - 1 >= 0 ? mat[i-1][j+k-1] : 0 ;

                    int C = j - 1 >= 0 ? mat[i+k-1][j-1] : 0 ;

                    int D = mat[i+k-1][j+k-1] ;

                    int sum = A - B - C + D ;

                    if(sum <= t) max = k ;
                    else break ;
                }
            }
        }

        return max ;

    }
}
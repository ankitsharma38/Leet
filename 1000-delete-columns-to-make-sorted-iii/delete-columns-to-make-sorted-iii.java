class Solution {
    public int minDeletionSize(String[] strs) {
    int width = strs[0].length();

    int dp[] = new int[width];
    Arrays.fill(dp, 1);
    int maxy = 0; 
    for(int i=width-2; i>=0; i--)
    {
        
        for(int j=i+1; j<width; j++)
        {
            boolean valid = true; 
            for(String str: strs)
            if(str.charAt(i)>str.charAt(j))
            {
             valid = false;
             break;
            }

            if(valid)
            dp[i] = Math.max(dp[i], 1+dp[j]); 
        } 
             
    }
     for(int x : dp)
     maxy = Math.max(maxy, x);

     return width-maxy;   
    }
}
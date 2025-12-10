class Solution {
    public int countPermutations(int[] complexity) {
        int mod = 1000000007;
        long anss = 1;
        for(int i= 1; i<complexity.length; i++){
            if(complexity[i] <= complexity[0]) {
                return 0;
            }
            else {
                anss = (anss *i) % mod;
            }
        }
        return (int)anss;
    }
}
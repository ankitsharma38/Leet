class Solution {
public:
    int dp[502][502];
    int solve(int idx1,int idx2, vector<int>&nums1, vector<int>&nums2){
        if(idx1 >= nums1.size() || idx2 >= nums2.size()) return 0;

        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];

        int case1 = nums1[idx1] * nums2[idx2] + solve(idx1+1, idx2+1,nums1, nums2);
        int case2 = solve(idx1, idx2+1, nums1, nums2);
        int case3 = solve(idx1+1, idx2, nums1, nums2);
        int case4 = solve(idx1+1, idx2+1, nums1, nums2);

        return dp[idx1][idx2] = max({case1, case2, case3, case4});
    }
    int maxDotProduct(vector<int>& nums1, vector<int>& nums2) {
        int mx = INT_MIN;
        for(auto i : nums1){
            for(auto j : nums2){
                mx = max(mx,i*j);
            }
        }
        if(mx < 0) return mx;
        memset(dp,-1,sizeof(dp));
        return solve(0,0,nums1,nums2);
    }
};
class Solution {
    public int maxOperations(String s) {
        int oneCount = 0;
        int res = 0;
        int i = 0;
        int n = s.length();

        while (i < n) {
            if (s.charAt(i) == '1') {
                oneCount++;
            } else { // s[i] == '0'
                res += oneCount;
                // skiping  continuous zeros from her
                while (i + 1 < n && s.charAt(i + 1) == '0') {
                    i++;
                }
            }
            i++;
        }

        return res;
    }
}

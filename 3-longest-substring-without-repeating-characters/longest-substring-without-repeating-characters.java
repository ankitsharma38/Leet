import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int lef = 0;
        int maxLength = 0;
        HashSet<Character> seen = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            while (seen.contains(c)) {
                seen.remove(s.charAt(lef));
                lef++;
            }            seen.add(c);
            maxLength = Math.max(maxLength, right - lef + 1);
        }

        return maxLength;
    }
}

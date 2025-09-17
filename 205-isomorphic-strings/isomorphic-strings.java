import java.util.*;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        // Arrays for mapping characters
        int[] mapST = new int[256]; // map from s -> t
        int[] mapTS = new int[256]; // map from t -> s
        
        Arrays.fill(mapST, -1);
        Arrays.fill(mapTS, -1);
        
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            
            // If already mapped, check consistency
            if (mapST[c1] != -1 && mapST[c1] != c2) {
                return false;
            }
            if (mapTS[c2] != -1 && mapTS[c2] != c1) {
                return false;
            }
            
            // Create mapping
            mapST[c1] = c2;
            mapTS[c2] = c1;
        }
        
        return true;
    }
}

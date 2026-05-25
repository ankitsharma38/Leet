class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        java.util.List<Integer> q = new java.util.ArrayList<>();
        q.add(0);

        int k = 1;
        int n = s.length();

        for (int idx = 0; idx < q.size(); idx++) {
            int i = q.get(idx);

            int start = Math.max(i + minJump, k);
            int end = Math.min(i + maxJump + 1, n);

            for (int j = start; j < end; j++) {
                if (s.charAt(j) == '0') {
                    q.add(j);
                }
            }

            k = i + maxJump + 1;
        }
        return q.get(q.size() - 1) == n - 1;
    }
}
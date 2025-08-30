class Solution {
    public boolean isValidSudoku(char[][] board) {
        // here we can use hash to trac we have seen
        HashSet<String> seen = new HashSet<>();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num == '.') continue;
                
                // Create keys for row, column, and box
                String rowKey = num + " in row " + i;
                String colKey = num + " in col " + j;
                String boxKey = num + " in box " + (i / 3) + "-" + (j / 3);
                
                // If it is  already seen, invalid
                if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                    return false;
                }
            }
        }
        return true;
    }
}

class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int total = 0;

        for(int i = 0; i < apple.length; i++){
            total += apple[i];
        }

        int boxes = 0;
        Arrays.sort(capacity);
        int len = capacity.length;

        while(total > 0){
            total -= capacity[len - 1];
            len--;
            boxes++;
        }

        return boxes;
    }
}
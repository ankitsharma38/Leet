class Solution {
    public String largestOddNumber(String num) {
        //starting from last and move left
        for(int i=num.length()-1; i>=0; i--){
            char c = num.charAt(i);

            //here checking if digit is odd or not
            if((c - '0') % 2 == 1){
                //here we return dubstring from start to index
                return num.substring(0, i+1);
            }
        }
        return "";
    }
}
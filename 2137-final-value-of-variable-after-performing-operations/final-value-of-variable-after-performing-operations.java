class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int X=0;

        for(String opt : operations){
            if(opt.equals("++X") || opt.equals("X++")){
                X++; 
            }
            else
             X--;
        }
        return X;
    }
}
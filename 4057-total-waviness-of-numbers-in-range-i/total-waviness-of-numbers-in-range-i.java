class Solution {
    public int totalWaviness(int num1, int num2) {
        int count=0;
        for(int i=num1;i<=num2;i++){
            int i1=i;
            int a=0,b=0;
            a=i1%10;
            i1=i1/10;
            b=i1%10;
            i1=i1/10;
            while(i1>0){
                int c=i1%10;
                i1=i1/10;
                if((b>c && b>a) || (b<c && b<a)) count++;
                a=b;
                b=c;
            }
        }
        return count;
    }
}
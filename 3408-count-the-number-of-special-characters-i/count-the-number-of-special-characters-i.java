class Solution {
    public int numberOfSpecialChars(String word) {
        String str="abcdefghijklmnopqrstqvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int res=0;
        for(int i=0;i<26;i++){
            char ch=str.charAt(i);
            char cap=str.charAt(i+26);// capital letter in str
            if(word.indexOf(ch)!=-1&&word.indexOf(cap) !=-1)res++;// if both index exist then res++
        }
        return res;
    }
}
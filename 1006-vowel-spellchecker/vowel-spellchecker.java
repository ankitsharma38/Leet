class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> words = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> firstOccurence = new HashMap<>();
        Map<String, String> maskedOccurence = new HashMap<>();
        //here we iterate from reverse because if we do from the front the occurence will be overridden so to get the first occurrence we do from back;
        for(int i = wordlist.length - 1; i >= 0; i--){
            String word = wordlist[i];
            String lowWord = word.toLowerCase();

            firstOccurence.put(lowWord, word);
            maskedOccurence.put(mask(lowWord), word);
         }

         int n = queries.length;
         for(int i= 0; i < n; i++){
            String str = queries[i];
            String strLow = str.toLowerCase();
            String maskedLow = mask(strLow);
            if(words.contains(str)){
                continue;
            }
            else if(firstOccurence.containsKey(strLow)){
                queries[i] = firstOccurence.get(strLow);
            }
            else if(maskedOccurence.containsKey(maskedLow)){
                queries[i] = maskedOccurence.get(maskedLow);
            }
            else{
                queries[i] = "";
            }
         }
        
    return queries;

        
    }

    private String mask(String word){
        StringBuilder str = new StringBuilder();
        char[] arr = word.toCharArray();
        for(int i = 0; i < arr.length; i++){
            char ch = arr[i];
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ) ch = '*';

            str.append(ch);
        }
        return str.toString();   
    }
}
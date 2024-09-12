class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        
        int mask = 0; //00.........0000000000000
        int count = 0;
        for(int i = 0; i< allowed.length(); i++){
            mask |= ( 1 << (allowed.charAt(i) - 'a'));
        }

        for(String s : words){
            boolean isValid = true;
            for(int i = 0; i<s.length(); i++){
                if(((mask >> (s.charAt(i) - 'a')) & 1) == 0){
                    isValid = false;
                    break;
                }
            }
            if(isValid) count++;
        }

        return count;

        /*
        int count = 0;
        for(int i = 0; i< words.length; i++){
            boolean isValid = true;
            for(int j =0; j<words[i].length(); j++){
                if(allowed.indexOf(words[i].charAt(j)) == -1){
                    isValid = false;
                    break;
                }
            }
            if(isValid){
                count++;
            }
        }
        return count;
        */
    }
}
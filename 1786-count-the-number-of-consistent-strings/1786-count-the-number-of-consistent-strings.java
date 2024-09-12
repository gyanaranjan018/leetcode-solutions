class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        //Set<character> set = new HashSet<>();
        //for(char c : allowed){

        //}
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
    }
}
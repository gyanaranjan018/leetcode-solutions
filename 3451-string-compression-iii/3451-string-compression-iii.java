class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char prev = word.charAt(0);
        for(int i = 1; i< word.length(); i++){
            if(word.charAt(i) == prev){
                if(count == 9){
                    sb.append(count);
                    sb.append(prev);
                    count = 0;
                }
                count++;
            }
            else{
                sb.append(count);
                sb.append(prev);
                prev = word.charAt(i);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(prev);
        return sb.toString();
    }
}
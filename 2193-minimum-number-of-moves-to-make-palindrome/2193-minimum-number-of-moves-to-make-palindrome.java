class Solution {
    public void swap(char[] str, int src, int dest){
        char temp = str[src];
        str[src] = str[dest];
        str[dest] = temp;
    }
    public int minMovesToMakePalindrome(String s) {
        if (s.length() == 1) return 0;
        char[] str = s.toCharArray();
        int i = 0, j= str.length-1, moves = 0;
        while(i < j){
            if(str[i] != str[j]){
                int curr = j;
                while(str[curr] != str[i]){
                    curr--;
                }
                // if only one char is present in the string
                if (curr == i){
                    swap(str, i, i+1);
                    moves++;
                    continue;
                }
                while(curr < j){
                    swap(str, curr, curr+1);
                    curr++;
                    moves++;
                }
            }
            i++;
            j--;
        }
        return moves;
    }
}
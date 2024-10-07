class Solution {
    public int minLength(String s) {

        char[] arr = s.toCharArray();

        int i = 0, j = 1;

        while(j < arr.length){
            if(i >= 0 && ((arr[j] == 'B' && arr[i] == 'A') || (arr[j] == 'D' && arr[i] == 'C'))){
                i--;
            }
            else{
                i++;
                arr[i] = arr[j];
            }
            j++;
        }

        return i+1;


        /*
        // Using stack
        Stack<Character> st = new Stack<>();
        for(int i =0; i< s.length(); i++){
            if(!st.isEmpty() && ((st.peek() == 'A' && s.charAt(i) == 'B')||(st.peek() == 'C' && s.charAt(i) == 'D'))){
                st.pop();
            }
            else{
                st.push(s.charAt(i));
            }
        }
        return st.size();
        */
    }
}
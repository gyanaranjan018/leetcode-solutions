class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        int count = 0;
        for(int i = 0; i < n; i++){
	        if(!st.isEmpty() && s.charAt(i) == 'a' && st.peek() == 'b'){
		        st.pop();
		        count++;
	        }
	        else{
		        st.push(s.charAt(i));
	        }
        }
        return count;
    }
}
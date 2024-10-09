class Solution {
    public int minAddToMakeValid(String s) {

        // Optimized approch
        
        int open = 0;
        int close = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                open++;
            }
            else{
                if(open <= 0){
                    close++;
                }
                else{
                    open--;
                }
            }
        }

        return open + close;

        /*
        ArrayList<Character> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            if(list.size() > 0 && list.get(list.size()-1) == '(' && s.charAt(i) == ')'){
                list.remove(list.size()-1);
            }
            else{
                list.add(s.charAt(i));
            }
        }
        return list.size();

        */



        /*
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(!st.isEmpty() && st.peek() == '(' && s.charAt(i) == ')'){
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
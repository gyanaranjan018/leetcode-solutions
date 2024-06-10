class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int index = -1;
        for(int i =0; i< s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c== '{' || c=='['){
                stack[++index] = c;
            }
            else if(index >= 0 && ((c==')'&& stack[index]=='(') ||
                              (c=='}'&& stack[index]=='{') ||
                              (c==']'&& stack[index]=='[')) ){
                index--;
            }
            else{
                return false;
            }            
        }
        return index == -1;
    }
}
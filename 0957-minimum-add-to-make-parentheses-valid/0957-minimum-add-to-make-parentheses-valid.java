class Solution {
    public int minAddToMakeValid(String s) {
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
    }
}
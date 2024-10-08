class Solution {
    public int minSwaps(String s) {
        int n = s.length();
        ArrayList<Character> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(list.size() > 0 && s.charAt(i) == ']' && list.get(list.size()-1) == '['){
                list.remove(list.size() - 1);
            }
            else{
                list.add(s.charAt(i));
            }
        }

        int opening = list.size()/2;

        return (opening+1)/2;
    }
}
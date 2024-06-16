class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String op = "";
        int open = n;
        int close = n;
        helper(open, close, op, res);
        return res;
    }
    public void helper(int open, int close, String op, List<String> res){
        if(open == 0 && close ==0){
            res.add(op);
            return;
        }
        if(open == close){
            helper(open-1, close, op+"(", res);
        }
        else if(open == 0){
            helper(open, close-1, op+")", res);
        }
        else{
            helper(open-1, close, op+"(", res);
            helper(open, close-1, op+")", res);
        }
    }
}
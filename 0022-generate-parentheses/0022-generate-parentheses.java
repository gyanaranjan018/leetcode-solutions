class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(n, n, new StringBuilder(), res);
        return res;
    }
    public void helper(int open, int close, StringBuilder sb, List<String> res){
        if(open == 0 && close ==0){
            res.add(sb.toString());
            return;
        }
        if(open > 0){
            sb.append("(");
            helper(open-1, close, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
        if(open < close){
            sb.append(")");
            helper(open, close-1, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
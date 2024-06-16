class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        String op = "";
        helper(s, op, res);
        return res;
    }

    public void helper(String s, String op, List<String> res){
        if(s.length() == 0){
            res.add(op);
            return;
        }
        char c = s.charAt(0);
        if(Character.isDigit(c)){
            op += c;
            helper(s.substring(1), op, res);
        }
        else{
            String op1 = op;
            String op2 = op;

            op1 += Character.toLowerCase(c);
            op2 += Character.toUpperCase(c);

            helper(s.substring(1), op1, res);
            helper(s.substring(1), op2, res);
        }
    }
}
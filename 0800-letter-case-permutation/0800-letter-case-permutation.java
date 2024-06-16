class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        String op = "";
        helper(s, op, res);
        return res;
    }

    public void helper(String s, String op, List<String> res){
        while(s.length() > 0 && s.charAt(0)>= 48 && s.charAt(0) <= 57){
            op += s.charAt(0);
            s = s.substring(1);
        }
        if(s.length() == 0){
            res.add(op);
            return;
        }

        String op1 = op;
        String op2 = op;

        op1 += Character.toLowerCase(s.charAt(0));
        op2 += Character.toUpperCase(s.charAt(0));

        helper(s.substring(1), op1, res);
        helper(s.substring(1), op2, res);
    }
}
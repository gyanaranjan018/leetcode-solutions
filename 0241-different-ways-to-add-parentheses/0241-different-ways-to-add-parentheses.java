class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        return solve(expression);
    }

    public List<Integer> solve(String s) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*'){
                List<Integer> left_res = solve(s.substring(0, i));
                List<Integer> right_res = solve(s.substring(i+1));

                for(int x : left_res){
                    for(int y : right_res){
                        if(s.charAt(i) == '+'){
                            result.add(x+y);
                        }
                        else if(s.charAt(i) == '*'){
                            result.add(x*y);
                        }
                        else{
                            result.add(x-y);
                        }
                    }
                }
            }
        }

        if(result.size() == 0){
            result.add(Integer.valueOf(s));
        }
        return result;
    }

}
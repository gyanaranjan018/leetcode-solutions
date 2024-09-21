class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for(int start = 1; start <= 9; start++){
            solve(start, n, res);
        }
        return res;
    }

    public void solve(int curr, int n, List<Integer> res){
        if(curr > n) return;
        res.add(curr);
        for(int i = 0; i <= 9; i++){
            int newNum = (curr*10) + i;
            if(newNum > n) return;
            solve(newNum, n, res);
        }
    }
}
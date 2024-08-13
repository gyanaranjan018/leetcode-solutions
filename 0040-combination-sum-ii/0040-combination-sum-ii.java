class Solution {

    void solve(int[] candidates, int target, List<Integer> curr, int index, List<List<Integer>> res){
        if(target < 0){
            return;
        }
        
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = index; i< candidates.length; i++){
            if(i > index && candidates[i] == candidates[i-1]){
                continue; //Ignoring duplicates elements
            }

            curr.add(candidates[i]); //DO
            solve(candidates, target - candidates[i], curr, i+1, res); // EXPLORE
            curr.remove(curr.size()-1); //UNDO
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        Arrays.sort(candidates);

        solve(candidates, target, curr, 0, res);
        return res;
    }
}
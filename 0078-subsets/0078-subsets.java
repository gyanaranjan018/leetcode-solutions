class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> op = new ArrayList<>();
        int start = 0;
        int end = nums.length -1;
        helper(nums, start, end, op, res);
        return res;
    }

    public void helper(int[] nums, int start, int end, List<Integer> op, List<List<Integer>> res){
        if(start > end){
            res.add(new ArrayList<>(op));
            return;
        }
        op.add(nums[start]);
        helper(nums, start+1, end, op, res);
        op.remove(op.size()-1);
        helper(nums, start+1, end, op, res);
    }
}
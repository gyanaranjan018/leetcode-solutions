class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        int i = 0;
        Arrays.sort(nums);
        findSubset(nums, i, set, subset);
        return subset;
    }
    public void findSubset(int[] nums, int i, List<Integer> set, List<List<Integer>> subset){
        if(i == nums.length){
            if(subset.contains(set)){
                return;
            }
            subset.add(new ArrayList<>(set));
            return;
        }
        //add the number and call recursion
        set.add(nums[i]);
        findSubset(nums, i+1, set, subset);

        //remove the num and call recursion
        set.remove(set.size()-1);
        findSubset(nums, i+1, set, subset);
    }
}
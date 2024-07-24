class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        List<Pair> list = new ArrayList<>(); //{maapedNum, Index}

        for(int i = 0; i< n; i++){
            String numStr = Integer.toString(nums[i]);
            String mappedStr = getMappedNum(numStr, mapping);
            int mappedNum = Integer.parseInt(mappedStr);
            list.add(new Pair(mappedNum, i));
        }
        Collections.sort(list, (a, b) -> Integer.compare(a.mappedNum, b.mappedNum));
        int[] result = new int[n];
        for(int i =0; i<n; i++){
            int originalNumIdx = list.get(i).originalIdx;
            result[i] = nums[originalNumIdx];
        }
        return result;
    }

    public String getMappedNum(String numStr, int[] mapping){
        StringBuilder mappedNum = new StringBuilder();
        for (char ch : numStr.toCharArray()) {
            mappedNum.append(mapping[ch - '0']);
        }
        return mappedNum.toString();
    }

    private static class Pair {
        int mappedNum;
        int originalIdx;

        Pair(int mappedNum, int originalIdx) {
            this.mappedNum = mappedNum;
            this.originalIdx = originalIdx;
        }
    }

}
class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        List<Pair> list = new ArrayList<>(); //{maapedNum, Index}

        for(int i = 0; i< n; i++){
            int mappedNum = getMappedNum(nums[i], mapping);
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

    public int getMappedNum(int num, int[] mapping){
        if(num < 10){
            return mapping[num];
        }
        
        int mappedVal = 0;
        int placeValue = 1;
        while(num > 0){
            mappedVal += (mapping[num % 10] * placeValue);
            num = num/10;
            placeValue *= 10;
        }
        return mappedVal;
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
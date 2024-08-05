class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String s : arr){
            map.put(s, map.getOrDefault(s, 0)+1);
        }

        int countDistinct = 0;
        for(String s : arr){
            if(map.get(s) == 1){
                countDistinct++;
            }
            if(countDistinct == k){
                return s;
            }
        }
        return "";
    }
}
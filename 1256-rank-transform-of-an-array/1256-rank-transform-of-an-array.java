class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        
        int[] dup = arr.clone();
        Arrays.sort(dup); //nlogn

        Map<Integer, Integer> map = new HashMap<>();
        int counter = 1;
        for(int i : dup){
            if(!map.containsKey(i)){
                map.put(i, counter++);
            }
        }

        int res[] = new int[n];
        for(int i = 0;i<n; i++){
            res[i] = map.get(arr[i]);
        }

        return res;
    }
}
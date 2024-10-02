class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        SortedSet<Integer> set = new TreeSet<>();
        for(int i : arr){
            set.add(i);
        }

        Map<Integer, Integer> map = new HashMap<>();
        int counter = 1;
        for(int i : set){
            map.put(i, counter++);
        }

        int res[] = new int[n];
        for(int i = 0;i<n; i++){
            res[i] = map.get(arr[i]);
        }

        return res;
    }
}
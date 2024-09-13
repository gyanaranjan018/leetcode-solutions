class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        //precompute cumulative xor
        int[] cumulative = new int[arr.length];
        int[] res = new int[queries.length];
        cumulative[0] = arr[0];
        for(int i = 1; i< arr.length; i++){
            cumulative[i] = arr[i] ^ cumulative[i-1];
        }

        for(int i = 0; i<queries.length; i++){
            int start = queries[i][0];
            int end = queries[i][1];

            if(start != 0){
                res[i] = cumulative[end] ^ cumulative[start-1];
            }
            else{
                res[i] = cumulative[end];
            }
        }

        return res;
    }
}
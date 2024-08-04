class Solution {
    class Pair{
        int sum, idx;
        Pair(int sum, int idx){
            this.sum = sum;
            this.idx = idx;
        }
    }
    public int rangeSum(int[] nums, int n, int left, int right) {
        long resArr[] = new long[(n*(n+1))/2];
        int c = 0;
        long mod = 1000000007;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.sum - y.sum);
        for(int i =0; i< n; i++){
            pq.add(new Pair(nums[i], i));
        }

        while(pq.size() != 0){
            int sum = pq.peek().sum;
            int idx = pq.peek().idx;
            pq.remove();
            resArr[c++] = sum;

            if(idx+1 < n){
                pq.add(new Pair(sum + nums[idx+1], idx+1));
            }
        }
        long res = 0;
        for(int i = left-1; i< right; i++){
            res += resArr[i];
        }
        return (int)(res % mod);
    }
}
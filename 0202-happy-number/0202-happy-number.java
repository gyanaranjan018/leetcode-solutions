class Solution {
    public boolean isHappy(int n) {
        int sum = 0;
        Set<Integer> s = new HashSet<>();
        while(true){
            sum=0;
            while(n>0){
                int temp =n%10;
                sum += temp*temp;
                n=n/10;
            }            
            if(sum == 1) return true;
            if(s.contains(sum)){
                return false;
            }
            s.add(sum);
            n = sum;
        }
    }
}
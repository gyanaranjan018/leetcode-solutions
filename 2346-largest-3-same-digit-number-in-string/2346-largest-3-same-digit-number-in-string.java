class Solution {
    public String largestGoodInteger(String num) {
        String res = "";
        int currentLargest = -1;
        for(int i = 2; i < num.length(); i++){
            if(num.charAt(i) == num.charAt(i-1)  && num.charAt(i)  == num.charAt(i-2) ){
                if(num.charAt(i)  - '0' > currentLargest){
                    currentLargest = num.charAt(i) - '0';
                    res = "";
                    res += num.charAt(i);
                    res += num.charAt(i);
                    res += num.charAt(i);
                }
            }
        }
        return res;
    }
}
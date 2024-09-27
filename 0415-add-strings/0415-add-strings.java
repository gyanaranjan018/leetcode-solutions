class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int n1 = num1.length();
        int n2 = num2.length();
        int carry = 0;
        int i = n1-1, j = n2-1;
        for( ; i>= 0 && j>= 0; i--, j--){
            int a = num1.charAt(i) - '0';
            int b = num2.charAt(j) - '0';
            int res = a + b + carry;
            if(res >= 10){
                carry = res/10;
            }
            else{
                carry = 0;
            }
            sb.append(res%10);
        }
        while(i >= 0){
            int a = num1.charAt(i) - '0';
            int res = a + carry;
            if(res >= 10){
                carry = res/10;
            }
            else{
                carry = 0;
            }
            sb.append(res%10);
            i--;
        }
        while(j >= 0){
            int a = num2.charAt(j) - '0';
            int res = a + carry;
            if(res >= 10){
                carry = res/10;
            }
            else{
                carry = 0;
            }
            sb.append(res%10);
            j--;
        }
        if(carry > 0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
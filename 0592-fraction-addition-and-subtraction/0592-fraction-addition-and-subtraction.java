class Solution {

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b); 
    }

    public String fractionAddition(String expression) {
        int nume = 0;
        int deno = 1;

        int i =0;
        int n = expression.length();
        while(i < n){
            int currNume = 0;
            int currDeno = 0;

            boolean isNeg = (expression.charAt(i) == '-');

            if(expression.charAt(i) == '+' || expression.charAt(i) == '-'){
                i++;
            }

            //Build the current numerator
            while(i < n && Character.isDigit(expression.charAt(i))){
                int val = expression.charAt(i) - '0';
                currNume = (currNume * 10) + val;
                i++;
            }

            i++; //skipping the divisor character

            if(isNeg){
                currNume *= -1;
            }
            
            //Build the current denomerator
            while(i < n && Character.isDigit(expression.charAt(i))){
                int val = expression.charAt(i) - '0';
                currDeno = (currDeno * 10) + val;
                i++;
            }

            nume = (nume * currDeno) + (currNume * deno);
            deno = deno * currDeno;
        }

        int GCD = Math.abs(gcd(nume, deno));

        nume /= GCD;
        deno /= GCD;

        return nume+"/"+deno;
    }
}
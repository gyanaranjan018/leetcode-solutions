class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i =0; i< s.length(); i++){
            int number = (int)s.charAt(i) - 96;
            sb.append(number);
        }

        String digits = new String(sb);

        for(int i=0; i<k; i++){
            int sum = 0;
            for(int j =0; j< digits.length(); j++){
                sum += Character.getNumericValue(digits.charAt(j));
            }
            digits = String.valueOf(sum);
        }
        return Integer.valueOf(digits);

    }
}
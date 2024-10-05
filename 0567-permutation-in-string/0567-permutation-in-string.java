class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        int i = 0, j = 0, n = s2.length();

        int[] arr = new int[26];
        for(char c : s1.toCharArray()){
            arr[c-'a']++;
        }

        while(j < n){
            arr[s2.charAt(j)-'a']--;

            if(j-i+1 == k){
                boolean check = true;
                for(char c : s1.toCharArray()){
                    if(arr[c-'a'] != 0){
                        check = false;
                        break;
                    }
                }
                if(check){
                    return true;
                }
                arr[s2.charAt(i)-'a']++;
                i++;
            }
            j++;
        }

        return false;
    }
}
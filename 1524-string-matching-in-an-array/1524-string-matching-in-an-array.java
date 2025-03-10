class Solution {
    public List<String> stringMatching(String[] words) {
        int n = words.length;
        List<String> res = new ArrayList<>();
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(i == j) continue;
                if(words[j].indexOf(words[i]) != -1){
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }
}
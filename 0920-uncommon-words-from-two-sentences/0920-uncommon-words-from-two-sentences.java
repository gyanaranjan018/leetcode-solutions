class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        String[] str1 = s1.split(" ");
        String[] str2 = s2.split(" ");
        List<String> resList = new ArrayList<>();

        for(String i : str1){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        for(String i : str2){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                resList.add(entry.getKey());
            }
        }

        return resList.toArray(new String[0]);
    }
}
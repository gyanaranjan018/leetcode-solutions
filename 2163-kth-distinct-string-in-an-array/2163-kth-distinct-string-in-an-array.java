class Solution {
    public String kthDistinct(String[] arr, int k) {
        List<String> list = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        for(String s : arr){
            if(visited.contains(s)){
                list.remove(s);
            }
            else{
                list.add(s);
                visited.add(s);
            }
        }

        if(list.size() >= k){
            return list.get(k-1);
        }
        else{
            return "";
        }

    }
}
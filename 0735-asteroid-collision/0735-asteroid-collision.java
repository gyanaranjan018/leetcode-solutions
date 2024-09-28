class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> list = new ArrayList<>();

        for(int a : asteroids){
            if(a > 0){
                list.add(a);
            }
            else{ 
                while(!list.isEmpty() && list.get(list.size() - 1) > 0 && list.get(list.size()-1) + a < 0){
                    list.remove(list.size() - 1);
                } 
                if(!list.isEmpty() && list.get(list.size()-1) + a == 0){
                    list.remove(list.size() - 1);
                }
                else if(list.isEmpty() || list.get(list.size()-1) < 0){
                    list.add(a);
                }
            }
        }

        int[] res = new int[list.size()];
        for(int i =0 ; i< list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
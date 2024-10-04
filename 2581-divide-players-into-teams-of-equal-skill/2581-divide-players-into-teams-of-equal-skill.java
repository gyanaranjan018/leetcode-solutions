class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        if(n % 2 == 1){
            return -1;
        }
        
        int noOfteams = n / 2;

        long sum = 0;

        for(int i : skill){
            sum += i;
        }

        if(sum % noOfteams != 0){
            return -1;
        }

        long perTeamSkill = sum / noOfteams;

        HashMap<Long, Integer> map = new HashMap<>();
        int idx = 0;
        long chemistry = 0;

        for(int i = 0; i<n; i++){
            long find = perTeamSkill - skill[i];
            if(find < 0){
                return -1;
            }
            if(map.containsKey(find)){
                chemistry += (skill[i] * find);
                if(map.get(find) == 1){
                    map.remove(find);
                }
                else{
                    map.put((long)find, map.get(find) - 1);
                }
            }
            else{
                map.put((long)skill[i], map.getOrDefault((long)skill[i], 0)+1);
            }
        }

        if(map.size() > 0){
            return -1;
        }

        return chemistry;
    }
}
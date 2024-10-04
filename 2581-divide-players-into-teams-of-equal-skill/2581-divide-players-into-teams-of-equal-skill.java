class Solution {
    public long dividePlayers(int[] skill) {

        //By sorting the array 
        int n = skill.length;

        Arrays.sort(skill);

        int i =0, j = n-1;
        int s = skill[i] + skill[j];
        long chemistry = 0;

        while(i<j){
            if(skill[i] + skill[j] != s){
                return -1;
            }
            chemistry += ((long)skill[i] * (long)skill[j]);
            i++;
            j--;
        }

        return chemistry;


        /*
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

        */
    }
}
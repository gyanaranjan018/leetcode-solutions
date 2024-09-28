class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();

        for(int a : asteroids){
            if(a > 0){
                s.push(a);
            }
            else{ 
                while(!s.isEmpty() && s.peek() > 0 && s.peek() + a < 0){
                    s.pop();
                } 
                if(!s.isEmpty() && s.peek() + a == 0){
                    s.pop();
                }
                else if(s.isEmpty() || s.peek() < 0){
                    s.push(a);
                }
            }
        }

        int[] res = new int[s.size()];
        int i = s.size() - 1;
        while(!s.isEmpty()){
            res[i--] = s.pop();
        }

        return res;
    }
}
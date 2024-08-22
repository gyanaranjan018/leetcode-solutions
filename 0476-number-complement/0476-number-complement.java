class Solution {
    public int findComplement(int num) {
        int i = 0; 
        int compliment = 0;

        while(num != 0){
            if((num & 1) == 0){  //if its a 0, the we need to flip it
                compliment |= (1<<i);
            }
            num >>= 1; //right shifting num
            i++;
        }
        return compliment;
    }
}
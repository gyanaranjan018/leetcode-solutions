class Solution {
    public double angleClock(int hour, int minutes) {
        hour = hour % 12;
        double conversion = (double)1/12;
        double hourAt =  hour * 5 + (minutes*conversion);
        double diff = Math.abs(hourAt - minutes);
        double angle = diff * 6;
        if(angle > 180){
            return (double)360-angle;
        }
        return angle;
    }
}
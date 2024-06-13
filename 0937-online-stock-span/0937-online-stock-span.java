class StockSpanner {
    final int N = 10010;
    int[] days;
    int ind;
    int[] nge;
    int peek;
    public StockSpanner() {
        days = new int[N];
        nge = new int[N];
        ind = 0;
        peek = -1;
    }
    
    public int next(int price) {
        while(peek >= 0 && price >= days[nge[peek]]){
            peek--;
        }
        int span = peek < 0 ? ind + 1 : ind - nge[peek];
        nge[++peek] = ind;
        days[ind++] = price;
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
class StockSpanner {
    int[] days;
    int top;
    public StockSpanner() {
        days = new int[10000];
        top = -1;
    }
    
    public int next(int price) {
        days[++top] = price;
        int span = 0;
        int i = top;
        while( i >= 0 && days[i] <= days[top]){
            span++;
            i--;
        }
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
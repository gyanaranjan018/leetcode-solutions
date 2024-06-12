class MinStack {
    Stack<Long> st;
    Long minVal;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        Long value = Long.valueOf(val);
        if(st.isEmpty()){
            st.push(value);
            minVal = value;
        }
        else{
            if(value < minVal){
                st.push(2 * value - minVal);
                minVal = value;
            }
            else{
                st.push(value);
            }
        }
    }
    
    public void pop() {
        if(st.isEmpty()){
            return;
        }
        Long top = st.pop();
        if( top < minVal){
            minVal = 2 * minVal - top;
        }
    }
    
    public int top() {
        if(st.isEmpty()){
            return -1;
        }
        Long top = st.peek();
        if(top < minVal){
            return minVal.intValue();
        }
        return top.intValue();
    }
    
    public int getMin() {
        if(st.isEmpty()){
            return -1;
        }
        return minVal.intValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
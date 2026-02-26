class StockSpanner {
    Stack<int[]> stack;
    public StockSpanner() {
        // implement a monotonic stack storing price,span
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;//currently itself is also included in span
        while (!stack.isEmpty() && stack.peek()[0] <= price){
            // stack is not empty
            span += stack.pop()[1];
        }
        // push
        stack.push(new int[]{price, span});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

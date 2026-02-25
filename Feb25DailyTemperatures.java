class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        // brute force: causes TLE
        for(int i = 0;i < n;i++){
            int j = i+1;
            for(;j<n;j++){//O(n^2)
                if (temperatures[j] > temperatures[i]){
                    break;
                }
            }
            result[i] = j==n?0:j-i;
        }
        return result;
    }
}
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        // use monotonic stack: order of stack (either increasing or decreasing is maintained)
        Stack<Integer> st = new Stack<>();//stores indices such that at the top we have smallest element and till the last elements are greater in the stack
        //stack elements -> greater at last --(smaller) -- smallest (on top)
        for(int i = n-1;i >= 0;i--){//O(n)
            while(!st.isEmpty() && temperatures[i] >= temperatures[st.peek()]){
                st.pop();
            }
            if (st.isEmpty()){
                result[i] = 0;
            }
            else{
                result[i] = st.peek()-i;
            }
            st.push(i);
        }
        return result;
    }
}

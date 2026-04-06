class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = n-1;i >= 0;i--){
            if(stack.isEmpty()){
                list.add(0, -1);
            }
            else{
                if(arr[i] < stack.peek()){
                    list.add(0, stack.peek());
                }
                else{
                    while(!stack.isEmpty() && stack.peek() <= arr[i]){
                        stack.pop();
                    }
                    if(stack.isEmpty()){
                        list.add(0, -1);
                    }
                    else{
                        list.add(0, stack.peek());
                    }
                }
            }
            stack.push(arr[i]);
        }
        return list;
    }
}

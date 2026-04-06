class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        int n = s.length();
        for(;i < s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }
            else if(ch == ')' || ch == '}' || ch == ']'){
                // no opening bracket
                if(stack.isEmpty()) return false;
                char peekChar = stack.peek();
                if(peekChar != '(' && ch == ')' || peekChar != '{' && ch == '}' || peekChar != '[' && ch == ']'){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
class Solution {
    Map<Character, Character> map;
    public boolean isValid(String s) {
        map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Stack<Character> stack = new Stack<>();
        int i = 0;
        int n = s.length();
        for(;i < s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }
            else{
                // no opening bracket
                if(stack.isEmpty()) return false;
                char peekChar = stack.peek();
                for(char key: map.keySet()){
                    if(ch == key && peekChar != map.get(key)) return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
class Solution {
    Map<Character, Character> map;
    public boolean isValid(String s) {
        map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Stack<Character> stack = new Stack<>();
        int i = 0;
        int n = s.length();
        for(;i < s.length();i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){
                stack.push(ch);
            }
            else{
                // no opening bracket
                if(stack.isEmpty()) return false;
                char peekChar = stack.peek();
                for(char key: map.keySet()){
                    if(ch == key && peekChar != map.get(key)) return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}

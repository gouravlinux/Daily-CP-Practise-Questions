class Solution {
    public String simplifyPath(String path) {
        // SC : O(n)
        // TC : O(n)
        // where n is the no. of names b/w /name/
        int n = path.length();
        String[] components = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String dir: components){
            if(dir.isEmpty() || dir.equals(".")){
                // do nothing 
                continue;
            }
            else if (dir.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else{
                //valid dir. name
                stack.push(dir);
            }
        }
        StringBuilder result = new StringBuilder();
        for(String dir: stack){
            result.append('/').append(dir);
        }
        return result.isEmpty()?"/":result.toString();
    }
}
class Solution {
    public String simplifyPath(String path) {
	// TC : O(n) where n is the number of tokens
	// SC : O(n)
        // using list
        String[] tokens = path.split("/");
        List<String> list = new ArrayList<>();
        for(String token: tokens){
            if(token.isEmpty() || token.equals(".")){
                continue;//do nothing
            }
            else if (token.equals("..")){
                if(list.isEmpty()){
                    continue;
                }
                else{
                    list.remove(list.size()-1);
                }
            }
            else{
                // valid dir name
                list.add(token);
            }
        }
        if(list.isEmpty()){
            return "/";
        }
        StringBuilder result = new StringBuilder();
        for(String str: list){
            result.append('/').append(str);
        }
        return result.toString();
    }
}

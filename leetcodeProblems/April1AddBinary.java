class Solution {
    public String addBinary(String a, String b) {
	// O(n) : TC and O(1) : SC
        int m = a.length();
        int n = b.length();
        int i = m-1;
        int j = n-1;
        int carry = 0;
        String res = "";
        while(i >= 0 || j >= 0 || carry > 0){
            int charOfA = 0;
            int charOfB = 0;
            if(i >= 0){
                charOfA = (int)(a.charAt(i--) - '0');
            }
            if(j >= 0){
                charOfB = (int)(b.charAt(j--) - '0');
            }
            int sum = carry + charOfA + charOfB;
            if(sum <= 1){
                res = Integer.toString(sum) + res;
                carry = 0;
            }
            else if (sum == 2){
                res = "0" + res;
                carry = 1;
            }
            else if (sum == 3){
                res = "1" + res;
                carry = 1;
            }
        }
        return res;
    }
}

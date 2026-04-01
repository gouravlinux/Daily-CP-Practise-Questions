class Solution {
    public int reverseBits(int n) {
        if(n == 0) return 0;
        int ans = 0;
        int i = 31;
        while(n > 0){
            int bit = n&1;
            ans += bit*Math.pow(2, i--);
            n = n >> 1;
        }
        return ans;
    }
}
class Solution {
    public int reverseBits(int n) {
        if(n == 0) return 0;
        int ans = 0;
        for(int i = 1;i <= 32;i++){
            ans = ans << 1;//left shift
            ans = ans | (n & 1);// add that bit to the LSB
            n = n >> 1;// right shift
        }
        return ans;
    }
}

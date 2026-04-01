class Solution {
    public int hammingWeight(int n) {
        // O(k) : TC where k is the no. of set bits
        int cnt = 0;
        while(n > 0){
            cnt++;
            n = n & (n-1);// unsets rightmost set bit
        }
        return cnt;
    }
}
class Solution {
    public int hammingWeight(int n) {
        // TC : O(log n) as n = n/2
        int cnt = 0;
        while(n > 0){
            cnt += n%2;
            n = n/2;
        }
        return cnt;
    }
}
class Solution {
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}

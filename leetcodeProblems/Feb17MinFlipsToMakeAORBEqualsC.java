class Solution {
    public int minFlips(int a, int b, int c) {
        int cnt = 0;
        while (a > 0 || b > 0 || c > 0) {
            int bitc = c & 1;
            int bita = a & 1;
            int bitb = b & 1;
            if (bitc == 0) {
                if (bita == 1) {
                    cnt++;
                }
                if (bitb == 1) {
                    cnt++;
                }
            } else {
                // if bit == 1
                if (bita == 0 && bitb == 0) {
                    cnt++;
                }
            }
            c = c >> 1;
            a = a >> 1;
            b = b >> 1;
        }
        return cnt;
    }
}

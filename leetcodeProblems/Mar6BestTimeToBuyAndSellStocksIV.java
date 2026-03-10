class Solution {
    int n;
    int[] curr;
    int[] ahead;

    public int maxProfit(int k, int[] prices) {
        // (using tabulations)->txns are noed(only 2k can be done)->space optimized
        n = prices.length;
        ahead = new int[2 * k + 1];
        curr = new int[2 * k + 1];
        for (int idx = n - 1; idx >= 0; idx--) {
            for (int txnNo = 2 * k - 1; txnNo >= 0; txnNo--) {
                //txnNo = 2k has 0 (therefore take from 2k-1)
                if (txnNo % 2 == 0) {
                    // can buy
                    curr[txnNo] = Math.max(-prices[idx] + ahead[txnNo + 1], ahead[txnNo]);
                } else {
                    // can't buy
                    curr[txnNo] = Math.max(prices[idx] + ahead[txnNo + 1], ahead[txnNo]);
                }
            }
            ahead = curr;
        }
        return curr[0];
    }
}

class Solution {
    int n;
    public int minOperations(String s) {
        n = s.length();
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        String sorted_s = new String(charArr);
        System.out.println(sorted_s);
        if(s.equals(sorted_s)){
            // both are same: no operations required
            
            return 0;
        }
        if(n == 2) 
            //can't be sorted
            return -1;
        char minChar = sorted_s.charAt(0);
        char maxChar = sorted_s.charAt(n-1);
        boolean start = false;
        boolean end = false;
        boolean middle = false;
        for(int i = 0;i < n;i++){
            if(s.charAt(i) == minChar){
                if(i == 0){
                    // minChar present at start 
                    start = true;
                }
                else if(i != n-1){
                    // minChar present in middle
                    middle = true;
                }
                
            }
            if(s.charAt(i) == maxChar){
                if (i == n-1){
                    //maxChar present at last
                    end = true;
                }
                else if(i != 0){
                    // maxChar present in middle
                    middle = true;
                }
            }
        }
        if(start || end){
            return 1;//min. 1 opn required 
            // that is sort s(start+1, end-1)
        }
        if(middle){
            return 2;//start and end are in middle
            // min. 2 opns would be required
        }
        return 3;//reverse : 3 operations min required
    }
}

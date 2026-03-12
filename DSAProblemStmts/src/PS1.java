// problem stmt given in Problem Stmts folder
import java.util.*;

public class PS1{
    private static int maxNonAdjSameDish(int[] arr){
        int N = arr.length;
        Map<Integer, List<Integer>> pos = new HashMap<>();

        int maxCount = 0;
        int bestDishType = Integer.MAX_VALUE;

        for(int i = 0;i < N;i++){
            if(!pos.containsKey(arr[i])){
                pos.put(arr[i], new ArrayList<>());
            }
            pos.get(arr[i]).add(i);
        }
        for(int num: pos.keySet()){
            List<Integer> ls = pos.get(num);
            int cnt = 0;
            int i = 0;
            while(i < ls.size()){
                int start = i;
                while(i+1 < ls.size() && (ls.get(i+1)  == 1 + ls.get(i))){
                    i++;
                }
                int blockLen = i - start + 1;
                cnt += (blockLen+1)/2;
                i++;
            }
            if(cnt > maxCount || (cnt == maxCount && num < bestDishType)){
                maxCount = cnt;
                bestDishType = num;
            }
        }

        return bestDishType;
    }
    public static void main(String[] args){
       int T;
       Scanner scn = new Scanner(System.in);
       T = scn.nextInt();
       while(T > 0){
           int N = scn.nextInt();
           int[] arr = new int[N];
           for(int i = 0;i < N;i++){
               arr[i] = scn.nextInt();
           }
           System.out.println(maxNonAdjSameDish(arr));
           T--;
       }
    }
}


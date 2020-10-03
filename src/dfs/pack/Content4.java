package dfs.pack;

import java.util.Arrays;
import java.util.Scanner;

public class Content4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int V = scanner.nextInt();
        int[] Vs = new int[N];
        int[] Ws = new int[N];
        int[] Ss = new int[N];
        for (int i = 0; i < N; i++) {
            Vs[i] = scanner.nextInt();
            Ws[i] = scanner.nextInt();
            Ss[i] = scanner.nextInt();
        }

        /*initial is done*/
        /*和01背包是类似的*/
        int[] dp = new int[V+1];
        Arrays.fill(dp, 0);
/*要拆分的*/
        for (int i = 0; i < N; i++) {
            for (int j = V; j > Vs[i]; j--) {//一维的是右到左的
                for(int k =1; k <= Ss[i] && k*Vs[i] <= j; k++){
                    dp[j] = Math.max(dp[j], dp[j - Ss[i]*Ws[i]] + Ss[i]*Ws[i]);
                }
            }
        }
        System.out.println(dp[V]);
    }
}

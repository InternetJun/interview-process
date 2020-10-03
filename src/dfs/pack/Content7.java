package dfs.pack;

import java.util.Scanner;

public class Content7 {
    /*求解的是一个混合背包的问题。
    * 1 01背包 ==>v从大到小
    * 2 完全背包 ==》 从小到大
    * 3 多重背包 ==》拆分为二进制或者说的k的限制问题。
    * */
    public int getDpRes() {
        /*需要的是判断
        * for(int q=0; q<k; q++{
        *   if(k[q] == 1) {
        *   } else if(k[q] <Integer.MAxValue){
        * } else{
        *   //完全背包的限制条件的
        * }
        * */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 物品个数
        int V = sc.nextInt(); // 背包总容量
        int[] dp = new int[V + 1];
        for(int i = 0; i < N; i++){
            int v = sc.nextInt(); // 体积
            int w = sc.nextInt(); // 价值
            int s = sc.nextInt(); // 数量
            if(s == 0){//利用0来代表
                // 完全背包问题
                for(int j = v; j <= V; j++){
                    dp[j] = Math.max(dp[j], dp[j - v] + w);
                }
            }else{
                // 多重背包问题，01背包是多重背包的特例，可以一并处理
                s = Math.abs(s);
                for(int j = 1; s >= j; s -= j, j *= 2){
                    for(int k = V; k >= j * v; k--){
                        dp[k] = Math.max(dp[k], dp[k - j * v] + j * w);
                    }
                }
                if(s > 0){
                    for(int j = V; j >= s * v; j--){// 最小的重量.
                        dp[j] = Math.max(dp[j], dp[j - s * v] + s * w);
                    }
                }
            }
        }
        System.out.println(dp[V]);
        return dp[V];
    }
}

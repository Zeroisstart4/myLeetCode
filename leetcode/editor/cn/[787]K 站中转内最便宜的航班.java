//有 n 个城市通过一些航班连接。给你一个数组 flights ，其中 flights[i] = [fromi, toi, pricei] ，表示该航班都从城
//市 fromi 开始，以价格 toi 抵达 pricei。 
//
// 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k 站中转的路线，使得从 src 到 dst 的 价格最便
//宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。 
//
// 
//
// 示例 1： 
//
// 
//输入: 
//n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
//src = 0, dst = 2, k = 1
//输出: 200
//解释: 
//城市航班图如下
//
//
//从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。 
//
// 示例 2： 
//
// 
//输入: 
//n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
//src = 0, dst = 2, k = 0
//输出: 500
//解释: 
//城市航班图如下
//
//
//从城市 0 到城市 2 在 0 站中转以内的最便宜价格是 500，如图中蓝色所示。 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// 0 <= flights.length <= (n * (n - 1) / 2) 
// flights[i].length == 3 
// 0 <= fromi, toi < n 
// fromi != toi 
// 1 <= pricei <= 104 
// 航班没有重复，且不存在自环 
// 0 <= src, dst, k < n 
// src != dst 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 动态规划 最短路 堆（优先队列） 
// 👍 294 👎 0

import java.util.Comparator;
import java.util.PriorityQueue;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // dp[i][k]是经过k个中转站后到达站 i 的最小费用
        int[][] dp = new int[n][K + 1];

        // 循环初始化整个二维数组。
        for(int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        // 利用flights中的信息初始化src可直达的班次
        for(int[] flight : flights) {
            if(flight[0] == src){
                dp[flight[1]][0] = flight[2];
            }
        }

        // 循环初始化数组中dst == src的行
        for(int i = 0; i <= K; i++){
            dp[src][i] = 0;
        }

        //动态规划状态转移方程，开始填表
        //直达的已经初始化了（即k = 0的情况），现在从k = 1 的开始，即只有一个中转站开始
        for(int k = 1; k <= K; k++){
            for(int[] flight : flights){
                //结合题目理解
                if(dp[flight[0]][k - 1] != Integer.MAX_VALUE){
                    dp[flight[1]][k] = Math.min(dp[flight[1]][k], dp[flight[0]][k - 1] + flight[2]);
                }
            }
        }
        return dp[dst][K] == Integer.MAX_VALUE? -1: dp[dst][K];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

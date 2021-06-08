//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。 
//
// 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。 
//
// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：3 
//解释：12 = 4 + 4 + 4 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：2
//解释：13 = 4 + 9 
// 
//
// 提示： 
//
// 
// 1 <= n <= 104 
// 
// Related Topics 广度优先搜索 数学 动态规划 
// 👍 875 👎 0


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 动态规划
    /*public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            //最坏的情况都是由1的平方组成
            dp[i] = i;

            for (int j = 1; j * j <= i; j++) {
                //动态规划公式
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }*/

    // BFS
    public int numSquares(int n) {

        Queue<Integer> queue = new LinkedList<>();
        //记录访问过的节点值
        Set<Integer> visited = new HashSet<>();
        queue.offer(0);
        visited.add(0);
        //树的第几层
        int level = 0;

        while (!queue.isEmpty()) {
            //每一层的节点数量
            int size = queue.size();
            level++;
            //遍历当前层的所有节点
            for (int i = 0; i < size; i++) {
                //节点的值
                int digit = queue.poll();
                //访问当前节点的子节点，类比于二叉树的左右子节点
                for (int j = 1; j <= n; j++) {
                    //子节点的值
                    int nodeValue = digit + j * j;
                    //nodeValue始终是完全平方数的和，当他等于n的时候直接返回
                    if(nodeValue == n) {
                        return level;
                    }

                    if(nodeValue > n) {
                        break;
                    }

                    if(!visited.contains(nodeValue)) {
                        queue.offer(nodeValue);
                        visited.add(nodeValue);
                    }
                }
            }
        }

        return level;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下： 
//
// 
// 有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0 
// 每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。 
// 每轮信息必须需要传递给另一个人，且信息可重复经过同一个人 
// 
//
// 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 ) 经过 k 轮传递到编号
//为 n-1 的小伙伴处的方案数；若不能到达，返回 0。 
//
// 示例 1： 
//
// 
// 输入：n = 5, relation = [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]], k = 3 
//
// 输出：3 
//
// 解释：信息从小 A 编号 0 处开始，经 3 轮传递，到达编号 4。共有 3 种方案，分别是 0->2->0->4， 0->2->1->4， 0->2->
//3->4。 
// 
//
// 示例 2： 
//
// 
// 输入：n = 3, relation = [[0,2],[2,1]], k = 2 
//
// 输出：0 
//
// 解释：信息不能从小 A 处经过 2 轮传递到编号 2 
// 
//
// 限制： 
//
// 
// 2 <= n <= 10 
// 1 <= k <= 5 
// 1 <= relation.length <= 90, 且 relation[i].length == 2 
// 0 <= relation[i][0],relation[i][1] < n 且 relation[i][0] != relation[i][1] 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 动态规划 
// 👍 92 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 变量共享
    // 方案数
    int ways;
    // 玩家数
    int n;
    // 传递轮数
    int k;
    // 邻接矩阵
    List<List<Integer>> edges;
    public int numWays(int n, int[][] relation, int k) {

        // 初始化
        this.n = n;
        this.k = k;
        edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }

        for (int[] edge : relation) {
            // 起始点与目的点
            int src = edge[0];
            int des = edge[1];
            // 初始化邻接矩阵
            edges.get(src).add(des);
        }

        dfs(0, 0);

        return ways;
    }

    /**
     * 递归查找路径
     * @param index     当前索引
     * @param steps     当前已经历步长
     */
    public void dfs(int index, int steps) {

        // 若引进到达 k 步，且恰好到达 n - 1 处，则到达方式 + 1
        if (steps == k) {
            if (index == n - 1) {
                ways++;
            }
            return;
        }

        // 获取当前点可达的下一个点集合
        List<Integer> nextList = edges.get(index);

        // 递归
        for (Integer nextIndex : nextList) {
            dfs(nextIndex, steps + 1);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

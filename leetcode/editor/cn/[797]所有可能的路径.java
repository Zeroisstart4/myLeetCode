//给一个有 n 个结点的有向无环图，找到所有从 0 到 n-1 的路径并输出（不要求按顺序） 
//
// 二维数组的第 i 个数组中的单元都表示有向图中 i 号结点所能到达的下一些结点（译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a ）空就是没
//有下一个结点了。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：graph = [[1,2],[3],[3],[]]
//输出：[[0,1,3],[0,2,3]]
//解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
// 
//
// 示例 2： 
//
// 
//
// 输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
//输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
// 
//
// 示例 3： 
//
// 输入：graph = [[1],[]]
//输出：[[0,1]]
// 
//
// 示例 4： 
//
// 输入：graph = [[1,2,3],[2],[3],[]]
//输出：[[0,1,2,3],[0,2,3],[0,3]]
// 
//
// 示例 5： 
//
// 输入：graph = [[1,3],[2],[3],[]]
//输出：[[0,1,2,3],[0,3]]
// 
//
// 
//
// 提示： 
//
// 
// 结点的数量会在范围 [2, 15] 内。 
// 你可以把路径以任意顺序输出，但在路径内的结点的顺序必须保证。 
// 
// Related Topics 深度优先搜索 图 回溯算法 
// 👍 123 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<List<Integer>> res;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res = new ArrayList<>();
        traverse(graph, 0, new LinkedList<>());
        return res;
    }

    /**
     *      回溯法查找所有路径
     * @param graph     图的邻接矩阵
     * @param s         当前所在节点
     * @param path      路径
     */
    public void traverse(int[][] graph, int s, LinkedList<Integer> path) {

        // 做出选择
        path.add(s);

        int n = graph.length;
        // 若已经贯穿所有点
        if(s == n - 1) {
            res.add(new LinkedList<>(path));
            // 撤销选择
            path.removeLast();
            return;
        }

        // 递归每个相邻节点
        for (int v : graph[s]) {
            traverse(graph, v, path);
        }
        // 撤销选择
        path.removeLast();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

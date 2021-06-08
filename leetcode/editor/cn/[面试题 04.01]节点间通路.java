//节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。 
//
// 示例1: 
//
//  输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
// 输出：true
// 
//
// 示例2: 
//
//  输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [
//1, 3], [2, 3], [3, 4]], start = 0, target = 4
// 输出 true
// 
//
// 提示： 
//
// 
// 节点数量n在[0, 1e5]范围内。 
// 节点编号大于等于 0 小于 n。 
// 图中可能存在自环和平行边。 
// 
// Related Topics 图 
// 👍 32 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {

        boolean[] road = new boolean[n + 1];

        road[start] = true;

        for (int i = 0; i < graph.length; i++) {

            if (road[graph[i][0]]) {
                 road[graph[i][1]] = true;
            }
        }

        return road[target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

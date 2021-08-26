//给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。 
//
// 请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。 
//
// 如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。 
//
// 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。 
//
// 
//
// 示例 1： 
//
// 
//输入：mat = 
//[[1,1,0,0,0],
// [1,1,1,1,0],
// [1,0,0,0,0],
// [1,1,0,0,0],
// [1,1,1,1,1]], 
//k = 3
//输出：[2,0,3]
//解释：
//每行中的军人数目：
//行 0 -> 2 
//行 1 -> 4 
//行 2 -> 1 
//行 3 -> 2 
//行 4 -> 5 
//从最弱到最强对这些行排序后得到 [2,0,3,1,4]
// 
//
// 示例 2： 
//
// 
//输入：mat = 
//[[1,0,0,0],
// [1,1,1,1],
// [1,0,0,0],
// [1,0,0,0]], 
//k = 2
//输出：[0,2]
//解释： 
//每行中的军人数目：
//行 0 -> 1 
//行 1 -> 4 
//行 2 -> 1 
//行 3 -> 1 
//从最弱到最强对这些行排序后得到 [0,2,3,1]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 2 <= n, m <= 100 
// 1 <= k <= m 
// matrix[i][j] 不是 0 就是 1 
// 
// Related Topics 数组 二分查找 矩阵 排序 堆（优先队列） 
// 👍 78 👎 0


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {

        // 记录数组的行列数
        int m = mat.length;
        int n = mat[0].length;

        // 统计每行的 1 个数， power[0] 为 1 个数， power[1] 为 所在行索引
        ArrayList<int[]> power = new ArrayList<>();

        // 遍历每行
        for (int i = 0; i < m; i++) {
            // 双指针
            int left = 0;
            int right = n - 1;
            // 1 个数
            int pos = -1;
            // 查找每行 1 的个数
            while (left <= right) {
                int mid = (left + right) / 2;
                // 若中间值为 0，则最后一个 1 在左侧
                if (mat[i][mid] == 0) {
                    right = mid - 1;
                }
                // 若中间值为 1，则最后一个 1 至少在 mid 处
                else {
                    pos = mid;
                    left = mid + 1;
                }
            }

            power.add(new int[]{pos + 1, i});
        }

        PriorityQueue<int[]> pqueue = new PriorityQueue<>((int[] pair1, int[] pair2) -> {

            if (pair1[0] != pair2[0]) {
                return pair1[0] - pair2[0];
            }
            else {
                return pair1[1] - pair2[1];
            }
        });

        for (int[] pair : power) {
            pqueue.offer(pair);
        }

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = pqueue.poll()[1];
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 排序 数组 
// 👍 928 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 排序 + 双指针
    public int[][] merge(int[][] intervals) {

        // 健壮性判断
        if(intervals.length == 0) {
            return new int[0][2];
        }

        // 排序，使区间的集合起始区间由小到大排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // 合并区间集合
        List<int[]> merged = new ArrayList<>();

        // 遍历
        for (int i = 0; i < intervals.length; i++) {
            // 左右指针
            int L = intervals[i][0];
            int R = intervals[i][1];

            // 若合并区间集合长度为 0 或者合并区间集合的最右边界较之于当前区间的左边界小，则合并区间区间集合与当前区间无交集
            if(merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                // 将当前区间加入集合
                merged.add(new int[]{L, R});
            }
            // 若合并区间区间集合与当前区间无交集
            else {
                // 将合并区间右边界进行扩展
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

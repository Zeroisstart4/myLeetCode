import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
<p>以数组 <code>intervals</code> 表示若干个区间的集合，其中单个区间为 <code>intervals[i] = [start<sub>i</sub>, end<sub>i</sub>]</code> 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>intervals = [[1,3],[2,6],[8,10],[15,18]]
<strong>输出：</strong>[[1,6],[8,10],[15,18]]
<strong>解释：</strong>区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
</pre>

<p><strong>示例&nbsp;2：</strong></p>

<pre>
<strong>输入：</strong>intervals = [[1,4],[4,5]]
<strong>输出：</strong>[[1,5]]
<strong>解释：</strong>区间 [1,4] 和 [4,5] 可被视为重叠区间。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= intervals.length &lt;= 10<sup>4</sup></code></li>
	<li><code>intervals[i].length == 2</code></li>
	<li><code>0 &lt;= start<sub>i</sub> &lt;= end<sub>i</sub> &lt;= 10<sup>4</sup></code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 56&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/merge-intervals/">https://leetcode-cn.com/problems/merge-intervals/</a></p>
<div><li>👍 4</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {

		if (intervals == null || intervals.length == 0) {
			return new int[0][2];
		}

		Arrays.sort(intervals, (o1, o2) -> {
			return o1[0] - o2[0];
		});

		List<int[]> merged = new ArrayList<>();

		for (int i = 0; i < intervals.length; i++) {

			int L = intervals[i][0];
			int R = intervals[i][1];

			if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
				merged.add(new int[]{L, R});
			}
			else {
				merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
			}
		}

		return merged.toArray(new int[merged.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

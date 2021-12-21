/**
<p>给你一个整数&nbsp;<code>n</code>&nbsp;，表示有&nbsp;<code>n</code>&nbsp;节课，课程编号从&nbsp;<code>1</code>&nbsp;到&nbsp;<code>n</code>&nbsp;。同时给你一个二维整数数组&nbsp;<code>relations</code>&nbsp;，其中&nbsp;<code>relations[j] = [prevCourse<sub>j</sub>, nextCourse<sub>j</sub>]</code>&nbsp;，表示课程&nbsp;<code>prevCourse<sub>j</sub></code>&nbsp;必须在课程&nbsp;<code>nextCourse<sub>j</sub></code>&nbsp;<strong>之前</strong>&nbsp;完成（先修课的关系）。同时给你一个下标从 <strong>0</strong>&nbsp;开始的整数数组&nbsp;<code>time</code>&nbsp;，其中&nbsp;<code>time[i]</code>&nbsp;表示完成第&nbsp;<code>(i+1)</code>&nbsp;门课程需要花费的 <strong>月份</strong>&nbsp;数。</p>

<p>请你根据以下规则算出完成所有课程所需要的 <strong>最少</strong>&nbsp;月份数：</p>

<ul>
	<li>如果一门课的所有先修课都已经完成，你可以在 <strong>任意</strong>&nbsp;时间开始这门课程。</li>
	<li>你可以&nbsp;<strong>同时</strong>&nbsp;上&nbsp;<strong>任意门课程</strong>&nbsp;。</li>
</ul>

<p>请你返回完成所有课程所需要的 <strong>最少</strong>&nbsp;月份数。</p>

<p><strong>注意：</strong>测试数据保证一定可以完成所有课程（也就是先修课的关系构成一个有向无环图）。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1:</strong></p>

<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2021/10/07/ex1.png" style="width: 392px; height: 232px;"></strong></p>

<pre><strong>输入：</strong>n = 3, relations = [[1,3],[2,3]], time = [3,2,5]
<b>输出：</b>8
<b>解释：</b>上图展示了输入数据所表示的先修关系图，以及完成每门课程需要花费的时间。
你可以在月份 0 同时开始课程 1 和 2 。
课程 1 花费 3 个月，课程 2 花费 2 个月。
所以，最早开始课程 3 的时间是月份 3 ，完成所有课程所需时间为 3 + 5 = 8 个月。
</pre>

<p><strong>示例 2：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2021/10/07/ex2.png" style="width: 500px; height: 365px;"></strong></p>

<pre><b>输入：</b>n = 5, relations = [[1,5],[2,5],[3,5],[3,4],[4,5]], time = [1,2,3,4,5]
<b>输出：</b>12
<b>解释：</b>上图展示了输入数据所表示的先修关系图，以及完成每门课程需要花费的时间。
你可以在月份 0 同时开始课程 1 ，2 和 3 。
在月份 1，2 和 3 分别完成这三门课程。
课程 4 需在课程 3 之后开始，也就是 3 个月后。课程 4 在 3 + 4 = 7 月完成。
课程 5 需在课程 1，2，3 和 4 之后开始，也就是在 max(1,2,3,7) = 7 月开始。
所以完成所有课程所需的最少时间为 7 + 5 = 12 个月。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>0 &lt;= relations.length &lt;= min(n * (n - 1) / 2, 5 * 10<sup>4</sup>)</code></li>
	<li><code>relations[j].length == 2</code></li>
	<li><code>1 &lt;= prevCourse<sub>j</sub>, nextCourse<sub>j</sub> &lt;= n</code></li>
	<li><code>prevCourse<sub>j</sub> != nextCourse<sub>j</sub></code></li>
	<li>所有的先修课程对&nbsp;<code>[prevCourse<sub>j</sub>, nextCourse<sub>j</sub>]</code>&nbsp;都是 <strong>互不相同</strong>&nbsp;的。</li>
	<li><code>time.length == n</code></li>
	<li><code>1 &lt;= time[i] &lt;= 10<sup>4</sup></code></li>
	<li>先修课程图是一个有向无环图。</li>
</ul>
<div><li>👍 5</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

	int res = 0;
	public int minimumTime(int n, int[][] relations, int[] time) {
		//统计每门课的前序课程集合；
		Map<Integer, List<Integer>> map = new HashMap<>();
		//找出结尾的课程集合；
		Set<Integer> last = new HashSet<>();
		for (int i = 1; i <= n; i++) last.add(i);

		for (int[] rela : relations) {
			last.remove(rela[0]); //set中剔除作为前序的课程；
			List<Integer> before = map.getOrDefault(rela[1], new ArrayList<>());
			before.add(rela[0]); //map加入前序课程
			map.put(rela[1], before);
		}
		int[] dp = new int[time.length + 1]; //dp[i]表示完成课程i的最短时间
		for (int l : last) {
			res = Math.max(res, fastTime(map, time, l, dp)); //从set中所有的结尾课程出发，进行dfs，取最大值
		}
		return res;
	}

	//记忆化dfs
	private int fastTime(Map<Integer, List<Integer>> map , int[] time, int l, int[] dp) {
		if (dp[l] != 0) return dp[l]; //记忆化取值
		List<Integer> before = map.get(l);
		if (before == null || before.size() == 0) { //找到了头部课程
			dp[l] = time[l - 1];
			return time[l - 1];
		}
		int beforeTime = 0;
		for (int b : before) {
			beforeTime = Math.max(beforeTime, fastTime(map, time, b, dp));
		}
		dp[l] = beforeTime + time[l - 1]; //记忆化赋值
		return dp[l];
	}
}
//leetcode submit region end(Prohibit modification and deletion)

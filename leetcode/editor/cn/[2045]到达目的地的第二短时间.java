/**
<p>城市用一个 <strong>双向连通</strong> 图表示，图中有 <code>n</code> 个节点，从 <code>1</code> 到 <code>n</code> 编号（包含 <code>1</code> 和 <code>n</code>）。图中的边用一个二维整数数组 <code>edges</code> 表示，其中每个 <code>edges[i] = [u<sub>i</sub>, v<sub>i</sub>]</code>&nbsp;表示一条节点&nbsp;<code>u<sub>i</sub></code> 和节点&nbsp;<code>v<sub>i</sub></code> 之间的双向连通边。每组节点对由 <strong>最多一条</strong> 边连通，顶点不存在连接到自身的边。穿过任意一条边的时间是 <code>time</code>&nbsp;分钟。</p>

<p>每个节点都有一个交通信号灯，每 <code>change</code> 分钟改变一次，从绿色变成红色，再由红色变成绿色，循环往复。所有信号灯都&nbsp;<strong>同时</strong> 改变。你可以在 <strong>任何时候</strong> 进入某个节点，但是 <strong>只能</strong> 在节点&nbsp;<strong>信号灯是绿色时</strong> 才能离开。如果信号灯是&nbsp; <strong>绿色</strong> ，你 <strong>不能</strong> 在节点等待，必须离开。</p>

<p><strong>第二小的值</strong> 是&nbsp;<strong>严格大于</strong> 最小值的所有值中最小的值。</p>

<ul>
	<li>例如，<code>[2, 3, 4]</code> 中第二小的值是 <code>3</code> ，而 <code>[2, 2, 4]</code> 中第二小的值是 <code>4</code> 。</li>
</ul>

<p>给你 <code>n</code>、<code>edges</code>、<code>time</code> 和 <code>change</code> ，返回从节点 <code>1</code> 到节点 <code>n</code> 需要的 <strong>第二短时间</strong> 。</p>

<p><strong>注意：</strong></p>

<ul>
	<li>你可以 <strong>任意次</strong> 穿过任意顶点，<strong>包括</strong> <code>1</code> 和 <code>n</code> 。</li>
	<li>你可以假设在 <strong>启程时</strong> ，所有信号灯刚刚变成 <strong>绿色</strong> 。</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2021/09/29/e1.png" style="width: 200px; height: 250px;" />        <img alt="" src="https://assets.leetcode.com/uploads/2021/09/29/e2.png" style="width: 200px; height: 250px;" /></p>

<pre>
<strong>输入：</strong>n = 5, edges = [[1,2],[1,3],[1,4],[3,4],[4,5]], time = 3, change = 5
<strong>输出：</strong>13
<strong>解释：</strong>
上面的左图展现了给出的城市交通图。
右图中的蓝色路径是最短时间路径。
花费的时间是：
- 从节点 1 开始，总花费时间=0
- 1 -&gt; 4：3 分钟，总花费时间=3
- 4 -&gt; 5：3 分钟，总花费时间=6
因此需要的最小时间是 6 分钟。

右图中的红色路径是第二短时间路径。
- 从节点 1 开始，总花费时间=0
- 1 -&gt; 3：3 分钟，总花费时间=3
- 3 -&gt; 4：3 分钟，总花费时间=6
- 在节点 4 等待 4 分钟，总花费时间=10
- 4 -&gt; 5：3 分钟，总花费时间=13
因此第二短时间是 13 分钟。      
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2021/09/29/eg2.png" style="width: 225px; height: 50px;" /></p>

<pre>
<strong>输入：</strong>n = 2, edges = [[1,2]], time = 3, change = 2
<strong>输出：</strong>11
<strong>解释：</strong>
最短时间路径是 1 -&gt; 2 ，总花费时间 = 3 分钟
最短时间路径是 1 -&gt; 2 -&gt; 1 -&gt; 2 ，总花费时间 = 11 分钟</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 &lt;= n &lt;= 10<sup>4</sup></code></li>
	<li><code>n - 1 &lt;= edges.length &lt;= min(2 * 10<sup>4</sup>, n * (n - 1) / 2)</code></li>
	<li><code>edges[i].length == 2</code></li>
	<li><code>1 &lt;= u<sub>i</sub>, v<sub>i</sub> &lt;= n</code></li>
	<li><code>u<sub>i</sub> != v<sub>i</sub></code></li>
	<li>不含重复边</li>
	<li>每个节点都可以从其他节点直接或者间接到达</li>
	<li><code>1 &lt;= time, change &lt;= 10<sup>3</sup></code></li>
</ul>
<div><li>👍 10</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int secondMinimum(int n, int[][] edges, int time, int change) {
		List<Integer>[] adj = new ArrayList[n];
		for(int i = 0; i < n; ++i) {
			adj[i] = new ArrayList<>();
		}
		int[] dis = new int[n];
		boolean[] sec = new boolean[n];
		for(int[] edge : edges) {
			int v = edge[0] - 1;
			int u = edge[1] - 1;
			adj[v].add(u);
			adj[u].add(v);
		}
		for(int i = 1; i < n; ++i) {
			dis[i] = Integer.MAX_VALUE;
		}
		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		while(!q.isEmpty()) {
			int head = q.poll();
			for(int u : adj[head]) {
				if(dis[u] > dis[head] + 1) {
					dis[u] = dis[head] + 1;
					q.offer(u);
				}
				else if(dis[u] == dis[head] || (sec[head] && dis[u] == dis[head] + 1)) {
					if(!sec[u]) {
						q.offer(u);
					}
					sec[u] = true;
				}
			}
		}
		int path = dis[n - 1] + (sec[n - 1] ? 1 : 2);
		return lenToTime(path, time, change);
	}

	private int lenToTime(int len, int time, int change) {
		int cur = 0;
		int tol = 0;
		for(int i = 0; i < len; i++) {
			tol += time;
			if(i == len - 1) {
				break;
			}
			int period = tol / change;
			if((period & 1) == 1) {
				tol += (period + 1) * change - tol;
			}
		}
		return tol;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

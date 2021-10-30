/**
<p>给你一棵根节点为 <code>0</code> 的&nbsp;<strong>二叉树</strong>&nbsp;，它总共有 <code>n</code>&nbsp;个节点，节点编号为&nbsp;<code>0</code>&nbsp;到&nbsp;<code>n - 1</code>&nbsp;。同时给你一个下标从&nbsp;<strong>0</strong>&nbsp;开始的整数数组&nbsp;<code>parents</code>&nbsp;表示这棵树，其中&nbsp;<code>parents[i]</code>&nbsp;是节点 <code>i</code>&nbsp;的父节点。由于节点 <code>0</code>&nbsp;是根，所以&nbsp;<code>parents[0] == -1</code>&nbsp;。</p>

<p>一个子树的 <strong>大小</strong>&nbsp;为这个子树内节点的数目。每个节点都有一个与之关联的&nbsp;<strong>分数</strong>&nbsp;。求出某个节点分数的方法是，将这个节点和与它相连的边全部 <strong>删除</strong>&nbsp;，剩余部分是若干个 <strong>非空</strong>&nbsp;子树，这个节点的 <strong>分数</strong>&nbsp;为所有这些子树 <strong>大小的乘积</strong>&nbsp;。</p>

<p>请你返回有 <strong>最高得分</strong>&nbsp;节点的 <strong>数目</strong>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1:</strong></p>

<p><img alt="example-1" src="https://assets.leetcode.com/uploads/2021/10/03/example-1.png" style="width: 604px; height: 266px;"></p>

<pre><b>输入：</b>parents = [-1,2,0,2,0]
<b>输出：</b>3
<strong>解释：</strong>
- 节点 0 的分数为：3 * 1 = 3
- 节点 1 的分数为：4 = 4
- 节点 2 的分数为：1 * 1 * 2 = 2
- 节点 3 的分数为：4 = 4
- 节点 4 的分数为：4 = 4
最高得分为 4 ，有三个节点得分为 4 （分别是节点 1，3 和 4 ）。
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="example-2" src="https://assets.leetcode.com/uploads/2021/10/03/example-2.png" style="width: 95px; height: 143px;"></p>

<pre><b>输入：</b>parents = [-1,2,0]
<b>输出：</b>2
<strong>解释：</strong>
- 节点 0 的分数为：2 = 2
- 节点 1 的分数为：2 = 2
- 节点 2 的分数为：1 * 1 = 1
最高分数为 2 ，有两个节点分数为 2 （分别为节点 0 和 1 ）。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == parents.length</code></li>
	<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>parents[0] == -1</code></li>
	<li>对于&nbsp;<code>i != 0</code>&nbsp;，有&nbsp;<code>0 &lt;= parents[i] &lt;= n - 1</code></li>
	<li><code>parents</code>&nbsp;表示一棵二叉树。</li>
</ul>
<div><li>👍 3</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int countHighestScoreNodes(int[] parents) {
		Map<Integer, List<Integer>> map = new HashMap();
		int[] count = new int[parents.length];
		for(int i = 1; i < parents.length; i++){
			List<Integer> list = new ArrayList(map.getOrDefault( parents[i], new ArrayList()));
			list.add(i);
			map.put(parents[i], list);
		}
		DFS(0, map, count);
		long scoreMax = Integer.MIN_VALUE;
		int nodes = 0;
		for(int i = 0; i < parents.length; i++) {
			long score = 1;
			if(parents[i] == -1) {
				List<Integer> list = new ArrayList( map.getOrDefault( i, new ArrayList() ) );
				for(int num : list) {
					score *= count[num];
				}
			}
			else {
				score = count[0] - count[i];
				List<Integer> list = new ArrayList( map.getOrDefault( i, new ArrayList() ) );
				for(int num : list)
					score *= count[num];
			}
			if(scoreMax < score){
				scoreMax = score;
				nodes = 1;
			}
			else if(score == scoreMax) {
				++nodes;
			}
		}
		return nodes;
	}

	public void DFS(int index,  Map<Integer, List<Integer>> map, int[] count){
		List<Integer> list = new ArrayList(map.getOrDefault( index, new ArrayList()));
		if(list.size() == 0){
			count[index] = 1;
			return;
		}
		for(int num : list){
			DFS(num, map, count);
			count[index] += count[num];
		}
		++count[index];
	}
}
//leetcode submit region end(Prohibit modification and deletion)

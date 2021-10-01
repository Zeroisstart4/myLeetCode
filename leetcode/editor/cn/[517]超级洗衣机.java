import java.util.Arrays;

/**
<p>假设有 <code>n</code><strong>&nbsp;</strong>台超级洗衣机放在同一排上。开始的时候，每台洗衣机内可能有一定量的衣服，也可能是空的。</p>

<p>在每一步操作中，你可以选择任意 <code>m</code> (<code>1 &lt;= m &lt;= n</code>) 台洗衣机，与此同时将每台洗衣机的一件衣服送到相邻的一台洗衣机。</p>

<p>给定一个整数数组&nbsp;<code>machines</code> 代表从左至右每台洗衣机中的衣物数量，请给出能让所有洗衣机中剩下的衣物的数量相等的 <strong>最少的操作步数 </strong>。如果不能使每台洗衣机中衣物的数量相等，则返回 <code>-1</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>machines = [1,0,5]
<strong>输出：</strong>3
<strong>解释：</strong>
第一步:    1     0 &lt;-- 5    =&gt;    1     1     4
第二步:    1 &lt;-- 1 &lt;-- 4    =&gt;    2     1     3    
第三步:    2     1 &lt;-- 3    =&gt;    2     2     2   
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>machines = [0,3,0]
<strong>输出：</strong>2
<strong>解释：</strong>
第一步:    0 &lt;-- 3     0    =&gt;    1     2     0    
第二步:    1     2 --&gt; 0    =&gt;    1     1     1     
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>machines = [0,2,0]
<strong>输出：</strong>-1
<strong>解释：</strong>
不可能让所有三个洗衣机同时剩下相同数量的衣物。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == machines.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>4</sup></code></li>
	<li><code>0 &lt;= machines[i] &lt;= 10<sup>5</sup></code></li>
</ul>
<div><li>👍 171</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMinMoves(int[] machines) {

		int total = Arrays.stream(machines).sum();
		int n = machines.length;

		if (total % n != 0) {
			return -1;
		}

		int avg = total / n;
		int res = 0;
		int sum = 0;

		for (int num : machines) {
			num -= avg;
			sum += num;
			res = Math.max(res, Math.max(Math.abs(sum), num));
		}

		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

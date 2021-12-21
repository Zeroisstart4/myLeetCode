import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
<p>给定两个以升序排列的整数数组 <code>nums1</code> 和<strong> </strong><code>nums2</code><strong>&nbsp;</strong>,&nbsp;以及一个整数 <code>k</code><strong>&nbsp;</strong>。</p>

<p>定义一对值&nbsp;<code>(u,v)</code>，其中第一个元素来自&nbsp;<code>nums1</code>，第二个元素来自 <code>nums2</code><strong>&nbsp;</strong>。</p>

<p>请找到和最小的 <code>k</code>&nbsp;个数对&nbsp;<code>(u<sub>1</sub>,v<sub>1</sub>)</code>, <code>&nbsp;(u<sub>2</sub>,v<sub>2</sub>)</code> &nbsp;... &nbsp;<code>(u<sub>k</sub>,v<sub>k</sub>)</code>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> nums1 = [1,7,11], nums2 = [2,4,6], k = 3
<strong>输出:</strong> [1,2],[1,4],[1,6]
<strong>解释: </strong>返回序列中的前 3 对数：
    [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入: </strong>nums1 = [1,1,2], nums2 = [1,2,3], k = 2
<strong>输出: </strong>[1,1],[1,1]
<strong>解释: </strong>返回序列中的前 2 对数：
&nbsp;    [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入: </strong>nums1 = [1,2], nums2 = [3], k = 3 
<strong>输出:</strong> [1,3],[2,3]
<strong>解释: </strong>也可能序列中所有的数对都被返回:[1,3],[2,3]
</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>1 &lt;= nums1.length, nums2.length &lt;= 10<sup>4</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= nums1[i], nums2[i] &lt;= 10<sup>9</sup></code></li>
	<li><code>nums1</code>, <code>nums2</code> 均为升序排列</li>
	<li><code>1 &lt;= k &lt;= 1000</code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 373&nbsp;题相同：<a href="https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/">https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/</a></p>
<div><li>👍 5</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

		// 结果集合
		List<List<Integer>> res = new ArrayList<>();
    	// 记录数组长度
		int len1 = nums1.length;
		int len2 = nums2.length;
		// 用于表示 index1 与 index2 的组合，cobinations[index1] 为 nums2 中的索引
		int[] cobinations = new int[len1];
		// 优先队列，排序规则为 nums1[index1] + nums2[index1 的组合索引] < nums1[index2] + nums2[index2 的组合索引]
		Queue<Integer> queue = new PriorityQueue<>((index1, index2) -> {
			return (nums1[index1] + nums2[cobinations[index1]]) - (nums1[index2] + nums2[cobinations[index2]]);
		});

		// 限制入队列数量
		int min = Math.min(len1, k);
		for (int i = 0; i < min; i++) {
			queue.offer(i);
		}

		// 向 res 中存够 k 个组合
		while (res.size() < k && !queue.isEmpty()) {

			// 获取队首元素
			int index = queue.poll();
			// 用于存储一个组合
			List<Integer> list = new ArrayList<>();

			// 一个组合
			int x = nums1[index];
			int y = nums2[cobinations[index]];

			// 入集合
			list.add(x);
			list.add(y);

			// 入结果集合
			res.add(list);

			// 若 cobinations[index] + 1 仍小于 len2，则 index 仍有组合的可能，故再次将 index 入队列， 优先队列会根据排序规则自动排序
			if (++cobinations[index] < len2) {
				queue.offer(index);
			}
		}

		return res;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

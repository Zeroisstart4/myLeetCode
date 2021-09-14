import java.util.HashMap;

/**
<p>给定一个整数数组和一个整数&nbsp;<code>k</code><strong> ，</strong>请找到该数组中和为&nbsp;<code>k</code><strong>&nbsp;</strong>的连续子数组的个数。</p>

<p>&nbsp;</p>

<p><strong>示例 1 :</strong></p>

<pre>
<strong>输入:</strong>nums = [1,1,1], k = 2
<strong>输出:</strong> 2
<strong>解释:</strong> 此题 [1,1] 与 [1,1] 为两种不同的情况
</pre>

<p><strong>示例 2&nbsp;:</strong></p>

<pre>
<strong>输入:</strong>nums = [1,2,3], k = 3
<strong>输出:</strong> 2
</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>-1000 &lt;= nums[i] &lt;= 1000</code></li>
	<li>
	<p><code>-10<sup>7</sup>&nbsp;&lt;= k &lt;= 10<sup>7</sup></code></p>
	</li>
</ul>

<p>&nbsp;</p>

<p>注意：本题与主站 560&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/subarray-sum-equals-k/">https://leetcode-cn.com/problems/subarray-sum-equals-k/</a></p>
<div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>前缀和</li></div></div><br><div><li>👍 6</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {

		// 健壮性判断
		if (nums == null || nums.length == 0) {
			return 0;
		}

		// 记录数组长度
		int n = nums.length;
		// 前缀和
		int pre = 0;
		// 统计数
		int count = 0;

		// 哈希容器， 键为 前醉和，值为 前醉和出现次数
		HashMap<Integer, Integer> container = new HashMap<>();
    	container.put(0, 1);
		// 遍历
		for (int i = 0; i < n; i++) {

			pre += nums[i];

			if (container.containsKey(pre - k)) {
				count += container.get(pre - k);
			}
			container.put(pre, container.getOrDefault(pre, 0) + 1);
		}

		return count;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

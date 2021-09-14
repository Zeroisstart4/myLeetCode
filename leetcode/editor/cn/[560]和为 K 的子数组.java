import java.util.HashMap;

/**
<p>给你一个整数数组 <code>nums</code> 和一个整数&nbsp;<code>k</code> ，请你统计并返回该数组中和为&nbsp;<code>k</code><strong>&nbsp;</strong>的连续子数组的个数。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,1,1], k = 2
<strong>输出：</strong>2
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3], k = 3
<strong>输出：</strong>2
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>-1000 &lt;= nums[i] &lt;= 1000</code></li>
	<li><code>-10<sup>7</sup> &lt;= k &lt;= 10<sup>7</sup></code></li>
</ul>
<div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>前缀和</li></div></div><br><div><li>👍 1090</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {

		// 健壮性判断
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int n = nums.length;
		int pre = 0;
		int count = 0;
		HashMap<Integer, Integer> contains = new HashMap<>();
		contains.put(0, 1);

		for (int i = 0; i < n; i++) {

			pre += nums[i];

			if (contains.containsKey(pre - k)) {
				count += contains.get(pre - k);
			}

			contains.put(pre, contains.getOrDefault(pre, 0) + 1);
		}

		return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

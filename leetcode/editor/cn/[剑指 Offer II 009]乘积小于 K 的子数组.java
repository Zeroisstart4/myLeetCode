/**
<p>给定一个正整数数组&nbsp;<code>nums</code>和整数 <code>k</code>&nbsp;，请找出该数组内乘积小于&nbsp;<code>k</code>&nbsp;的连续的子数组的个数。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> nums = [10,5,2,6], k = 100
<strong>输出:</strong> 8
<strong>解释:</strong> 8 个乘积小于 100 的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> nums = [1,2,3], k = 0
<strong>输出:</strong> 0</pre>

<p>&nbsp;</p>

<p><strong>提示:&nbsp;</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 1000</code></li>
	<li><code>0 &lt;= k &lt;= 10<sup>6</sup></code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 713&nbsp;题相同：<a href="https://leetcode-cn.com/problems/subarray-product-less-than-k/">https://leetcode-cn.com/problems/subarray-product-less-than-k/</a>&nbsp;</p>
<div><div>Related Topics</div><div><li>数组</li><li>滑动窗口</li></div></div><br><div><li>👍 7</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

		// 数组内乘积小于 k 的连续的子数组的个数
		int count = 0;

		// 健壮性判断
		if (nums == null || nums.length == 0) {
			return count;
		}

		// 双指针
		int left = 0;
		int right = 0;
		// 乘积
		int multi = 1;

		while (right < nums.length) {

			multi *= nums[right];
			right++;

			while (left < right && multi >= k) {
				multi /= nums[left];
				left++;
			}

			count += (right - left);
		}

		return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

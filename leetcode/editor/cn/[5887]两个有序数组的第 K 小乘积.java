/**
给你两个 <strong>从小到大排好序</strong>&nbsp;且下标从 <strong>0</strong>&nbsp;开始的整数数组&nbsp;<code>nums1</code> 和&nbsp;<code>nums2</code>&nbsp;以及一个整数&nbsp;<code>k</code>&nbsp;，请你返回第<em>&nbsp;</em><code>k</code>&nbsp;（从 <strong>1</strong>&nbsp;开始编号）小的&nbsp;<code>nums1[i] * nums2[j]</code><em>&nbsp;</em>的乘积，其中<em>&nbsp;</em><code>0 &lt;= i &lt; nums1.length</code><em> </em>且<em> </em><code>0 &lt;= j &lt; nums2.length</code>&nbsp;。
<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>nums1 = [2,5], nums2 = [3,4], k = 2
<b>输出：</b>8
<b>解释：</b>第 2 小的乘积计算如下：
- nums1[0] * nums2[0] = 2 * 3 = 6
- nums1[0] * nums2[1] = 2 * 4 = 8
第 2 小的乘积为 8 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>nums1 = [-4,-2,0,3], nums2 = [2,4], k = 6
<b>输出：</b>0
<strong>解释：</strong>第 6 小的乘积计算如下：
- nums1[0] * nums2[1] = (-4) * 4 = -16
- nums1[0] * nums2[0] = (-4) * 2 = -8
- nums1[1] * nums2[1] = (-2) * 4 = -8
- nums1[1] * nums2[0] = (-2) * 2 = -4
- nums1[2] * nums2[0] = 0 * 2 = 0
- nums1[2] * nums2[1] = 0 * 4 = 0
第 6 小的乘积为 0 。
</pre>

<p><strong>示例 3：</strong></p>

<pre><b>输入：</b>nums1 = [-2,-1,0,1,2], nums2 = [-3,-1,2,4,5], k = 3
<b>输出：</b>-6
<b>解释：</b>第 3 小的乘积计算如下：
- nums1[0] * nums2[4] = (-2) * 5 = -10
- nums1[0] * nums2[3] = (-2) * 4 = -8
- nums1[4] * nums2[0] = 2 * (-3) = -6
第 3 小的乘积为 -6 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums1.length, nums2.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>-10<sup>5</sup> &lt;= nums1[i], nums2[j] &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= k &lt;= nums1.length * nums2.length</code></li>
	<li><code>nums1</code> 和&nbsp;<code>nums2</code>&nbsp;都是从小到大排好序的。</li>
</ul>
<div><li>👍 0</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {

		List<Long> n1 = new ArrayList<>();
		List<Long> p1 = new ArrayList<>();
		List<Long> n2 = new ArrayList<>();
		List<Long> p2 = new ArrayList<>();
		for (int x : nums1) {
			if (x < 0) {
				n1.add((long)-x);
			} else {
				p1.add((long) x);
			}
		}
		for (int x : nums2) {
			if (x < 0) {
				n2.add((long) -x);
			} else {
				p2.add((long) x);
			}
		}
		Collections.sort(n1);
		Collections.sort(n2);
		Collections.sort(p1);
		Collections.sort(p2);
		long negativeCount = n1.size() * p2.size() + n2.size() * p1.size();
		int sign = 1;
		List<Long> l1, l2, r1, r2;
		if (k > negativeCount) {
			// 在正数里找第 k - negativeCount大
			k -= negativeCount;
			l1 = n1;
			r1 = n2;
			l2 = p1;
			r2 = p2;
		}
		else {
			sign = -1;
			// 因为把负数取反了，正数里排第1的（最小），负数里反而最大（排第negativeCount）
			k = negativeCount - k + 1;
			l1 = n1;
			r1 = p2;
			l2 = p1;
			r2 = n2;
		}

		long left = 0L;
		long right = 10000000000L;
		while (left < right) {
			long mid = (left + right) / 2;
			if (count(l1, r1, mid) + count(l2, r2, mid) >= k) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left * sign;

    }

	// 统计乘积小于等于target的组合数量
	private long count(List<Long> arr1, List<Long> arr2, long target) {
		long result = 0;
		int j = arr2.size() - 1;
		for (int i = 0; i < arr1.size(); i++) {
			while (j >= 0 && arr1.get(i) * arr2.get(j) > target) {
				j--;
			}
			result += j + 1;
		}
		return result;
	}

}
//leetcode submit region end(Prohibit modification and deletion)

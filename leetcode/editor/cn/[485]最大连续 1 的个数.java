/**
<p>给定一个二进制数组， 计算其中最大连续 1 的个数。</p>

<p> </p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>[1,1,0,1,1,1]
<strong>输出：</strong>3
<strong>解释：</strong>开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li>输入的数组只包含 <code>0</code> 和 <code>1</code> 。</li>
	<li>输入数组的长度是正整数，且不超过 10,000。</li>
</ul>
<div><li>👍 265</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int maxCount = 0;
        int count = 0;

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            if (nums[i] == 1) {
                count++;
            }
            else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }

        maxCount = Math.max(maxCount, count);

        return maxCount;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

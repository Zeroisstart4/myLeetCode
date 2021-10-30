/**
<p>给定一个非空的正整数数组 <code>nums</code> ，请判断能否将这些数字分成元素和相等的两部分。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,5,11,5]
<strong>输出：</strong>true
<strong>解释：</strong>nums<strong> </strong>可以分割成 [1, 5, 5] 和 [11] 。</pre>

<p><strong>示例&nbsp;2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3,5]
<strong>输出：</strong>false
<strong>解释：</strong>nums<strong> </strong>不可以分为和相等的两部分
</pre>

<p>&nbsp;</p>

<p><meta charset="UTF-8" /></p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 200</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 100</code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 416&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/partition-equal-subset-sum/">https://leetcode-cn.com/problems/partition-equal-subset-sum/</a></p>
<div><div>Related Topics</div><div><li>数学</li><li>字符串</li><li>模拟</li></div></div><br><div><li>👍 3</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        int len = nums.length;

        if(len < 2) {
            return false;
        }

        int sum = 0;
        int maxNum = 0;

        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }

        if(sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        if(maxNum > target) {
            return false;
        }

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int i = 0; i < len; i++) {
            int num = nums[i];
            for (int j = target; j >= num; j--) {
                dp[j] |= dp[j - num];
            }
        }

        return dp[target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

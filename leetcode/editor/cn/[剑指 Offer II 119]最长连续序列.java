import java.util.HashSet;
import java.util.Set;

/**
<p>给定一个未排序的整数数组 <code>nums</code> ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [100,4,200,1,3,2]
<strong>输出：</strong>4
<strong>解释：</strong>最长数字连续序列是 <code>[1, 2, 3, 4]。它的长度为 4。</code></pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,3,7,2,5,8,4,6,0,1]
<strong>输出：</strong>9
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>可以设计并实现时间复杂度为&nbsp;<code>O(n)</code><em> </em>的解决方案吗？</p>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 128&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/longest-consecutive-sequence/">https://leetcode-cn.com/problems/longest-consecutive-sequence/</a></p>
<div><div>Related Topics</div><div><li>并查集</li><li>数组</li><li>哈希表</li></div></div><br><div><li>👍 2</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxLen = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {

            if (!set.contains(num - 1)) {
                int curNum = num;
                int len = 1;
                while (set.contains(curNum + 1)) {
                    curNum++;
                    len++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

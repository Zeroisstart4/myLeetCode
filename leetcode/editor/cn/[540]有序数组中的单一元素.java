/**
<p>给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。</p>

<p> </p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> nums = [1,1,2,3,3,4,4,8,8]
<strong>输出:</strong> 2
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> nums =  [3,3,7,7,10,11,11]
<strong>输出:</strong> 10
</pre>

<p> </p>

<p><meta charset="UTF-8" /></p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>1 <= nums.length <= 10<sup>5</sup></code></li>
	<li><code>0 <= nums[i] <= 10<sup>5</sup></code></li>
</ul>

<p> </p>

<p><strong>进阶:</strong> 采用的方案可以在 <code>O(log n)</code> 时间复杂度和 <code>O(1)</code> 空间复杂度中运行吗？</p>
<div><div>Related Topics</div><div><li>数组</li><li>二分查找</li></div></div><br><div><li>👍 266</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNonDuplicate(int[] nums) {

        int res = 0;
        for (int num : nums) {
            res ^= num;
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

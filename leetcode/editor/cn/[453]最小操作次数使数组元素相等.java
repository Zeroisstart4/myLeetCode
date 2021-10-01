import java.util.Arrays;

/**
<p>给定一个长度为 <em>n</em> 的 <strong>非空 </strong>整数数组，每次操作将会使 <em>n</em> - 1 个元素增加 1。找出让数组所有元素相等的最小操作次数。</p>

<p> </p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>
[1,2,3]
<strong>输出：</strong>
3
<strong>解释：</strong>
只需要3次操作（注意每次操作会增加两个元素的值）：
[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
</pre>
<div><li>👍 253</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minMoves(int[] nums) {

        int count = 0;
        Arrays.sort(nums);

        for (int i = nums.length - 1; i >= 0; i--) {
            count += nums[i] - nums[0];
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

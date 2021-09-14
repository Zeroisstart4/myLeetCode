import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
<p>给定一个包含 <code>n</code> 个整数的数组&nbsp;<code>nums</code>，判断&nbsp;<code>nums</code>&nbsp;中是否存在三个元素&nbsp;<code>a</code> ，<code>b</code> ，<code>c</code> <em>，</em>使得&nbsp;<code>a + b + c = 0</code> ？请找出所有和为 <code>0</code> 且&nbsp;<strong>不重复&nbsp;</strong>的三元组。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [-1,0,1,2,-1,-4]
<strong>输出：</strong>[[-1,-1,2],[-1,0,1]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = []
<strong>输出：</strong>[]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [0]
<strong>输出：</strong>[]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 &lt;= nums.length &lt;= 3000</code></li>
	<li><code>-10<sup>5</sup> &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 15&nbsp;题相同：<a href="https://leetcode-cn.com/problems/3sum/">https://leetcode-cn.com/problems/3sum/</a></p>
<div><div>Related Topics</div><div><li>数组</li><li>双指针</li><li>排序</li></div></div><br><div><li>👍 4</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        // 结果数组
        List<List<Integer>> res = new ArrayList<>();

        // 健壮性判断
        if (nums == null || nums.length < 3) {
            return res;
        }

        // 数组排序
        Arrays.sort(nums);

        // 遍历数组
        int n = nums.length;
        for (int i = 0; i < n; i++) {

            // 若三数中的最小元素都已经大于 0， 则三数无法组合出和为 0 的结果
            if (nums[i] > 0) {
                break;
            }
            // 数组去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 左右指针
            int L = i + 1;
            int R = n - 1;

            while (L < R) {

                // 三数之和
                int sum = nums[i] + nums[L] + nums[R];

                // 若满足条件， 即和为 0
                if (sum == 0) {
                    // 加入结果集
                    res.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    // 元素去重
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;
                    }
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--;
                    }

                    L++;
                    R--;
                }
                // 若小于 0
                else if (sum < 0) {
                    L++;
                }
                // 若大于 0
                else {
                    R--;
                }
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

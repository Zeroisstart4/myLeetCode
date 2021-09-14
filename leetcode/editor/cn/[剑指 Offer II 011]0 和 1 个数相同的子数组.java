import java.util.HashMap;
import java.util.Map;

/**
<p>给定一个二进制数组 <code>nums</code> , 找到含有相同数量的 <code>0</code> 和 <code>1</code> 的最长连续子数组，并返回该子数组的长度。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> nums = [0,1]
<strong>输出:</strong> 2
<strong>说明:</strong> [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> nums = [0,1,0]
<strong>输出:</strong> 2
<strong>说明:</strong> [0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>nums[i]</code> 不是 <code>0</code> 就是 <code>1</code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 525&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/contiguous-array/">https://leetcode-cn.com/problems/contiguous-array/</a></p>
<div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>前缀和</li></div></div><br><div><li>👍 6</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxLength(int[] nums) {

        // 最大长度
        int maxLen = 0;

        // 键为 统计值 count, 值为 统计值索引
        Map<Integer, Integer> containsMap = new HashMap<>();

        // 用于统计 0 1 出现次数， 若出现 1 则 count++, 若出现 0 则 count--
        int count = 0;
        // 初始化， 出现 0 的索引为 -1
        containsMap.put(0, -1);

        // 遍历
        for (int i = 0; i < nums.length; i++) {
            // 若出现 1 则 count+
            if (nums[i] == 1) {
                count++;
            }
            // 若出现 0 则 count--
            else {
                count--;
            }
            // 若发生 count 重复
            if (containsMap.containsKey(count)) {
                // 更新有相同数量的 0 和 1 的最长连续子数组长度
                int preIndex = containsMap.get(count);
                maxLen = Math.max(maxLen, i - preIndex);
            }
            // 若不发生 count 重复
            else {
                containsMap.put(count, i);
            }
        }

        return maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

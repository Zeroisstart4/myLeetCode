import java.util.ArrayList;
import java.util.List;

/**
<p>给定一个整数数组&nbsp;<code>nums</code> ，数组中的元素 <strong>互不相同</strong> 。返回该数组所有可能的子集（幂集）。</p>

<p>解集 <strong>不能</strong> 包含重复的子集。你可以按 <strong>任意顺序</strong> 返回解集。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3]
<strong>输出：</strong>[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0]
<strong>输出：</strong>[[],[0]]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10</code></li>
	<li><code>-10 &lt;= nums[i] &lt;= 10</code></li>
	<li><code>nums</code> 中的所有元素 <strong>互不相同</strong></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 78&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/subsets/">https://leetcode-cn.com/problems/subsets/</a></p>
<div><li>👍 4</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {

		List<List<Integer>> res = new ArrayList<>();
		dfs(res, nums, new ArrayList<>(), 0);

		return res;
    }

	private void dfs(List<List<Integer>> res, int[] nums, List<Integer> list, int index) {

		if (index == nums.length) {
			res.add(new ArrayList<>(list));
			return;
		}

		dfs(res, nums, list, index + 1);

		list.add(nums[index]);
		dfs(res, nums, list, index + 1);
		list.remove(list.size() - 1);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

/**
<p>给定两个整数 <code>n</code> 和 <code>k</code>，返回 <code>1 ... n</code> 中所有可能的 <code>k</code> 个数的组合。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong>&nbsp;n = 4, k = 2
<strong>输出:</strong>
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong>&nbsp;n = 1, k = 1
<strong>输出: </strong>[[1]]</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 20</code></li>
	<li><code>1 &lt;= k &lt;= n</code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 77&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/combinations/">https://leetcode-cn.com/problems/combinations/</a></p>
<div><li>👍 6</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        if (n < 1 || k < 0) {
            return res;
        }
        dfs(res, list, 1, n, k);

        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> list, int index, int n, int k) {

        if (list.size() + (n - index + 1) < k) {
            return;
        }

        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        dfs(res, list, index + 1, n, k);

        list.add(index);
        dfs(res, list, index + 1, n, k);
        list.remove(list.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

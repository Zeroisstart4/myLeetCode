import java.util.ArrayList;
import java.util.List;

/**
<p>正整数&nbsp;<code>n</code>&nbsp;代表生成括号的对数，请设计一个函数，用于能够生成所有可能的并且 <strong>有效的 </strong>括号组合。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>n = 3
<strong>输出：</strong>[&quot;((()))&quot;,&quot;(()())&quot;,&quot;(())()&quot;,&quot;()(())&quot;,&quot;()()()&quot;]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 1
<strong>输出：</strong>[&quot;()&quot;]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 8</code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 22&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/generate-parentheses/">https://leetcode-cn.com/problems/generate-parentheses/</a></p>
<div><li>👍 7</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    public void backtrack(List<String> res, StringBuilder str, int open, int close, int pair) {

        if (str.length() == pair * 2) {
            res.add(str.toString());
            return;
        }

        if (open < pair) {
            str.append("(");
            backtrack(res, str, open + 1, close, pair);
            str.deleteCharAt(str.length() - 1);
        }

        if (close < pair) {
            str.append(")");
            backtrack(res, str, open, close + 1, pair);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
<p>给定一个字符串 <code>s</code> ，请将 <code>s</code> 分割成一些子串，使每个子串都是 <strong>回文串</strong> ，返回 s 所有可能的分割方案。</p>

<p><meta charset="UTF-8" /><strong>回文串</strong>&nbsp;是正着读和反着读都一样的字符串。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s =<strong> </strong>&quot;google&quot;
<strong>输出：</strong>[[&quot;g&quot;,&quot;o&quot;,&quot;o&quot;,&quot;g&quot;,&quot;l&quot;,&quot;e&quot;],[&quot;g&quot;,&quot;oo&quot;,&quot;g&quot;,&quot;l&quot;,&quot;e&quot;],[&quot;goog&quot;,&quot;l&quot;,&quot;e&quot;]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = &quot;aab&quot;
<strong>输出：</strong>[[&quot;a&quot;,&quot;a&quot;,&quot;b&quot;],[&quot;aa&quot;,&quot;b&quot;]]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>s = &quot;a&quot;
<strong>输出：</strong>[[&quot;a&quot;]<span style="font-family: &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 14px; background-color: rgb(255, 255, 255);">&nbsp;</span></pre>

<p>&nbsp;</p>

<p><b>提示：</b></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 16</code></li>
	<li><code>s </code>仅由小写英文字母组成</li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 131&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/palindrome-partitioning/">https://leetcode-cn.com/problems/palindrome-partitioning/</a></p>
<div><li>👍 7</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    
    boolean[][] palindrome;
    public String[][] partition(String s) {

        List<List<String>> res = new ArrayList<>();
        int len = s.length();
        
        palindrome = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(palindrome[i], true);
        }
        
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                palindrome[i][j] = (s.charAt(i) == s.charAt(j)) && palindrome[i + 1][j - 1];
            }
        }
        
        dfs(res, new ArrayList<>(), s, palindrome, 0);

        int m = res.size();
        String[][] ans = new String[m][];
        for (int i = 0; i < m; i++) {
            List<String> list = res.get(i);
            int  n = list.size();
            ans[i] = new String[n];
            for (int j = 0; j < n; j++) {
                ans[i][j] = list.get(j);
            }
        }

        return ans;
    }
    
    public void dfs(List<List<String>> res, List<String> list, String s, boolean[][] palindrome, int index) {

        if (index == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int j = index; j < s.length(); j++) {

            if (palindrome[index][j]) {
                list.add(s.substring(index, j + 1));
                dfs(res, list, s, palindrome, j + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

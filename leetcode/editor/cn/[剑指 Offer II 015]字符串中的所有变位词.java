import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
<p>给定两个字符串&nbsp;<code>s</code>&nbsp;和<b>&nbsp;</b><code>p</code>，找到&nbsp;<code>s</code><strong>&nbsp;</strong>中所有 <code>p</code> 的&nbsp;<strong>变位词&nbsp;</strong>的子串，返回这些子串的起始索引。不考虑答案输出的顺序。</p>

<p><strong>变位词 </strong>指字母相同，但排列不同的字符串。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre>
<strong>输入: </strong>s = &quot;cbaebabacd&quot;, p = &quot;abc&quot;
<strong>输出: </strong>[0,6]
<strong>解释:</strong>
起始索引等于 0 的子串是 &quot;cba&quot;, 它是 &quot;abc&quot; 的变位词。
起始索引等于 6 的子串是 &quot;bac&quot;, 它是 &quot;abc&quot; 的变位词。
</pre>

<p><strong>&nbsp;示例 2:</strong></p>

<pre>
<strong>输入: </strong>s = &quot;abab&quot;, p = &quot;ab&quot;
<strong>输出: </strong>[0,1,2]
<strong>解释:</strong>
起始索引等于 0 的子串是 &quot;ab&quot;, 它是 &quot;ab&quot; 的变位词。
起始索引等于 1 的子串是 &quot;ba&quot;, 它是 &quot;ab&quot; 的变位词。
起始索引等于 2 的子串是 &quot;ab&quot;, 它是 &quot;ab&quot; 的变位词。
</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>1 &lt;= s.length, p.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>s</code>&nbsp;和 <code>p</code> 仅包含小写字母</li>
</ul>

<p>&nbsp;</p>

<p>注意：本题与主站 438&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/" style="background-color: rgb(255, 255, 255);">https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/</a></p>
<div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li><li>滑动窗口</li></div></div><br><div><li>👍 1</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();

        if (s.length() < p.length()) {
            return res;
        }

        int left = 0;
        int right = 0;
        int valid = 0;

        HashMap<Character, Integer> needs = new HashMap<>();
        HashMap<Character, Integer> windows = new HashMap<>();

        for (char c : p.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        while (right < s.length()) {

            char ch = s.charAt(right);
            right++;
            if (needs.containsKey(ch)) {
                windows.put(ch, windows.getOrDefault(ch, 0) + 1);
                if (needs.get(ch).equals(windows.get(ch))) {
                    valid++;
                }
            }

            while (right - left >= p.length()) {

                if (valid == needs.size()) {
                    res.add(left);
                }

                char rem = s.charAt(left);
                left++;

                if (needs.containsKey(rem)) {
                    if (needs.get(rem).equals(windows.get(rem))) {
                        valid--;
                    }
                    windows.put(rem, windows.getOrDefault(rem, 0) - 1);
                }
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

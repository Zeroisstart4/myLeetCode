import java.util.HashMap;

/**
<p>给定两个字符串&nbsp;<code>s1</code>&nbsp;和&nbsp;<code>s2</code>，写一个函数来判断 <code>s2</code> 是否包含 <code>s1</code><strong>&nbsp;</strong>的某个变位词。</p>

<p>换句话说，第一个字符串的排列之一是第二个字符串的 <strong>子串</strong> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入: </strong>s1 = &quot;ab&quot; s2 = &quot;eidbaooo&quot;
<strong>输出: </strong>True
<strong>解释:</strong> s2 包含 s1 的排列之一 (&quot;ba&quot;).
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入: </strong>s1= &quot;ab&quot; s2 = &quot;eidboaoo&quot;
<strong>输出:</strong> False
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s1.length, s2.length &lt;= 10<sup>4</sup></code></li>
	<li><code>s1</code> 和 <code>s2</code> 仅包含小写字母</li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 567&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/permutation-in-string/">https://leetcode-cn.com/problems/permutation-in-string/</a></p>
<div><div>Related Topics</div><div><li>哈希表</li><li>双指针</li><li>字符串</li><li>滑动窗口</li></div></div><br><div><li>👍 5</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 第一个字符串的排列之一是第二个字符串的子串 。
    public boolean checkInclusion(String s1, String s2) {

        // 若 s1
        if (s1.length() > s2.length()) {
            return false;
        }

        HashMap<Character, Integer> needs = new HashMap<>();
        HashMap<Character, Integer> windows = new HashMap<>();

        for (char c : s1.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;

        while (right < s2.length()) {

            char ch = s2.charAt(right);
            right++;
            if (needs.containsKey(ch)) {
                windows.put(ch, windows.getOrDefault(ch, 0) + 1);
                if (needs.get(ch).equals(windows.get(ch))) {
                    valid++;
                }
            }

            while (right - left >= s1.length()) {
                if (valid == needs.size()) {
                    return true;
                }

                char rem = s2.charAt(left);
                left++;
                if (needs.containsKey(rem)) {
                    if (needs.get(rem).equals(windows.get(rem))) {
                        valid--;
                    }
                    windows.put(rem, windows.getOrDefault(rem, 0) - 1);
                }
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

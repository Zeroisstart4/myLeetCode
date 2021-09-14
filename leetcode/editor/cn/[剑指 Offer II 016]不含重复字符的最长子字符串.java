import java.util.HashMap;

/**
<p>给定一个字符串 <code>s</code> ，请你找出其中不含有重复字符的&nbsp;<strong>最长连续子字符串&nbsp;</strong>的长度。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre>
<strong>输入: </strong>s = &quot;abcabcbb&quot;
<strong>输出: </strong>3 
<strong>解释:</strong> 因为无重复字符的最长子字符串是 <code>&quot;abc&quot;，所以其</code>长度为 3。
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入: </strong>s = &quot;bbbbb&quot;
<strong>输出: </strong>1
<strong>解释: </strong>因为无重复字符的最长子字符串是 <code>&quot;b&quot;</code>，所以其长度为 1。
</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入: </strong>s = &quot;pwwkew&quot;
<strong>输出: </strong>3
<strong>解释: </strong>因为无重复字符的最长子串是&nbsp;<code>&quot;wke&quot;</code>，所以其长度为 3。
&nbsp;    请注意，你的答案必须是 <strong>子串 </strong>的长度，<code>&quot;pwke&quot;</code>&nbsp;是一个<em>子序列，</em>不是子串。
</pre>

<p><strong>示例 4:</strong></p>

<pre>
<strong>输入: </strong>s = &quot;&quot;
<strong>输出: </strong>0
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 &lt;= s.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>s</code>&nbsp;由英文字母、数字、符号和空格组成</li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 3&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/">https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/</a></p>
<div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li><li>滑动窗口</li></div></div><br><div><li>👍 3</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {

        // 滑动窗口
        HashMap<Character, Integer> windows = new HashMap<>();
        // 最长不重复字串长度
        int maxLen = 0;
        // 左右指针
        int left = 0;
        int right = 0;

        while (right < s.length()) {

            char ch = s.charAt(right);
            right++;

            windows.put(ch, windows.getOrDefault(ch, 0) + 1);

            while (windows.get(ch) > 1) {

                char rem = s.charAt(left);
                left++;
                windows.put(rem, windows.getOrDefault(rem, 0) - 1);
            }

            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

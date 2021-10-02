/**
<p>给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> &quot;abab&quot;

<strong>输出:</strong> True

<strong>解释:</strong> 可由子字符串 &quot;ab&quot; 重复两次构成。
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> &quot;aba&quot;

<strong>输出:</strong> False
</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入:</strong> &quot;abcabcabcabc&quot;

<strong>输出:</strong> True

<strong>解释:</strong> 可由子字符串 &quot;abc&quot; 重复四次构成。 (或者子字符串 &quot;abcabc&quot; 重复两次构成。)
</pre>
<div><li>👍 536</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean repeatedSubstringPattern(String s) {

        return (s + s).indexOf(s, 1) != s.length();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

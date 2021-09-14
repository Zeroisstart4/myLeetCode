/**
<p>给定一个非空字符串 <code>s</code>，<strong>最多</strong>删除一个字符。判断是否能成为回文字符串。</p>

<p> </p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> s = "aba"
<strong>输出:</strong> true
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> s = "abca"
<strong>输出:</strong> true
<strong>解释:</strong> 你可以删除c字符。
</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入:</strong> s = "abc"
<strong>输出:</strong> false</pre>

<p> </p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>1 <= s.length <= 10<sup>5</sup></code></li>
	<li><code>s</code> 由小写英文字母组成</li>
</ul>
<div><div>Related Topics</div><div><li>贪心</li><li>双指针</li><li>字符串</li></div></div><br><div><li>👍 393</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return validPalindrome(s, left, right - 1) || validPalindrome(s, left + 1, right);
            }
            left++;
            right--;
        }

        return true;
    }

    public boolean validPalindrome(String s, int low, int high) {
        if (low > high) {
            return false;
        }
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

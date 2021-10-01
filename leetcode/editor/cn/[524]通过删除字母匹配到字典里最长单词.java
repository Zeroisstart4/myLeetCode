/**
<p>给你一个字符串 <code>s</code> 和一个字符串数组 <code>dictionary</code> 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 <code>s</code> 中的某些字符得到。</p>

<p>如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
<strong>输出：</strong>"apple"
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "abpcplea", dictionary = ["a","b","c"]
<strong>输出：</strong>"a"
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= s.length <= 1000</code></li>
	<li><code>1 <= dictionary.length <= 1000</code></li>
	<li><code>1 <= dictionary[i].length <= 1000</code></li>
	<li><code>s</code> 和 <code>dictionary[i]</code> 仅由小写英文字母组成</li>
</ul>
<div><div>Related Topics</div><div><li>数组</li><li>双指针</li><li>字符串</li><li>排序</li></div></div><br><div><li>👍 234</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
		String res = "";

		for (String t : dictionary) {
			int i = 0;
			int j = 0;
			while (i < t.length() && j < s.length()) {
				if (t.charAt(i) == s.charAt(j)) {
					i++;
				}
				j++;
			}

			if (i == t.length()) {

				if (i > res.length() || (i == res.length() && t.compareTo(res) < 0)) {
					res = t;
				}
			}
		}

		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

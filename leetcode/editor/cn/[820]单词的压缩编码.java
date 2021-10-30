import java.util.HashMap;
import java.util.Map;

/**
<p>单词数组 <code>words</code> 的 <strong>有效编码</strong> 由任意助记字符串 <code>s</code> 和下标数组 <code>indices</code> 组成，且满足：</p>

<ul>
	<li><code>words.length == indices.length</code></li>
	<li>助记字符串 <code>s</code> 以 <code>'#'</code> 字符结尾</li>
	<li>对于每个下标 <code>indices[i]</code> ，<code>s</code> 的一个从 <code>indices[i]</code> 开始、到下一个 <code>'#'</code> 字符结束（但不包括 <code>'#'</code>）的 <strong>子字符串</strong> 恰好与 <code>words[i]</code> 相等</li>
</ul>

<p>给你一个单词数组 <code>words</code> ，返回成功对 <code>words</code> 进行编码的最小助记字符串 <code>s</code> 的长度 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>words = ["time", "me", "bell"]
<strong>输出：</strong>10
<strong>解释：</strong>一组有效编码为 s = <code>"time#bell#" 和 indices = [0, 2, 5</code>] 。
words[0] = "time" ，s 开始于 indices[0] = 0 到下一个 '#' 结束的子字符串，如加粗部分所示 "<strong>time</strong>#bell#"
words[1] = "me" ，s 开始于 indices[1] = 2 到下一个 '#' 结束的子字符串，如加粗部分所示 "ti<strong>me</strong>#bell#"
words[2] = "bell" ，s 开始于 indices[2] = 5 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#<strong>bell</strong>#"
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>words = ["t"]
<strong>输出：</strong>2
<strong>解释：</strong>一组有效编码为 s = "t#" 和 indices = [0] 。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= words.length <= 2000</code></li>
	<li><code>1 <= words[i].length <= 7</code></li>
	<li><code>words[i]</code> 仅由小写字母组成</li>
</ul>
<div><li>👍 247</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumLengthEncoding(String[] words) {

		TrieNode trie = new TrieNode();
		Map<TrieNode, Integer> nodes = new HashMap<>();

		for (int i = 0; i < words.length; i++) {

			String word = words[i];
			TrieNode cur = trie;
			for (int j = word.length() - 1; j >= 0; j--) {
				cur = cur.get(word.charAt(j));
			}
			nodes.put(cur, i);
		}
		
		int res = 0;
		for (TrieNode node : nodes.keySet()) {
			
			if (node.count == 0) {
				res += words[nodes.get(node)].length() + 1;
			}
		}
		
		return res;
    }
	
	class TrieNode {
		
		TrieNode[] children;
		int count = 0;

		public TrieNode() {
			children = new TrieNode[26];
			count = 0;
		}
		
		public TrieNode get(char c) {
			if (children[c - 'a'] == null) {
				children[c - 'a'] = new TrieNode();
				count++;
			}
			
			return children[c - 'a'];
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

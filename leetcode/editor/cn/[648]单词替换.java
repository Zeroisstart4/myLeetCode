import java.util.List;

/**
<p>在英语中，我们有一个叫做&nbsp;<code>词根</code>(root)的概念，它可以跟着其他一些词组成另一个较长的单词&mdash;&mdash;我们称这个词为&nbsp;<code>继承词</code>(successor)。例如，词根<code>an</code>，跟随着单词&nbsp;<code>other</code>(其他)，可以形成新的单词&nbsp;<code>another</code>(另一个)。</p>

<p>现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有<code>继承词</code>用<code>词根</code>替换掉。如果<code>继承词</code>有许多可以形成它的<code>词根</code>，则用最短的词根替换它。</p>

<p>你需要输出替换之后的句子。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>dictionary = [&quot;cat&quot;,&quot;bat&quot;,&quot;rat&quot;], sentence = &quot;the cattle was rattled by the battery&quot;
<strong>输出：</strong>&quot;the cat was rat by the bat&quot;
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>dictionary = [&quot;a&quot;,&quot;b&quot;,&quot;c&quot;], sentence = &quot;aadsfasf absbs bbab cadsfafs&quot;
<strong>输出：</strong>&quot;a a b c&quot;
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>dictionary = [&quot;a&quot;, &quot;aa&quot;, &quot;aaa&quot;, &quot;aaaa&quot;], sentence = &quot;a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa&quot;
<strong>输出：</strong>&quot;a a a a a a a a bbb baba a&quot;
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>dictionary = [&quot;catt&quot;,&quot;cat&quot;,&quot;bat&quot;,&quot;rat&quot;], sentence = &quot;the cattle was rattled by the battery&quot;
<strong>输出：</strong>&quot;the cat was rat by the bat&quot;
</pre>

<p><strong>示例 5：</strong></p>

<pre><strong>输入：</strong>dictionary = [&quot;ac&quot;,&quot;ab&quot;], sentence = &quot;it is abnormal that this solution is accepted&quot;
<strong>输出：</strong>&quot;it is ab that this solution is ac&quot;
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= dictionary.length&nbsp;&lt;= 1000</code></li>
	<li><code>1 &lt;= dictionary[i].length &lt;= 100</code></li>
	<li><code>dictionary[i]</code>&nbsp;仅由小写字母组成。</li>
	<li><code>1 &lt;= sentence.length &lt;= 10^6</code></li>
	<li><code>sentence</code>&nbsp;仅由小写字母和空格组成。</li>
	<li><code>sentence</code> 中单词的总量在范围 <code>[1, 1000]</code> 内。</li>
	<li><code>sentence</code> 中每个单词的长度在范围 <code>[1, 1000]</code> 内。</li>
	<li><code>sentence</code> 中单词之间由一个空格隔开。</li>
	<li><code>sentence</code>&nbsp;没有前导或尾随空格。</li>
</ul>
<div><li>👍 136</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {

		TrieNode trie = new TrieNode();

		for (String letters : dictionary) {
			TrieNode cur = trie;
			for (char letter : letters.toCharArray()) {

				if (cur.children[letter - 'a'] == null) {
					cur.children[letter - 'a'] = new TrieNode();
				}
				cur = cur.children[letter - 'a'];
			}
			cur.word = letters;
		}

		StringBuilder res = new StringBuilder();

		for (String word : sentence.split(" ")) {
			if (res.length() > 0) {
				res.append(" ");
			}

			TrieNode cur = trie;

			for (char letter : word.toCharArray()) {
				if (cur.children[letter - 'a'] == null || cur.word != null) {
					break;
				}
				cur = cur.children[letter - 'a'];
			}
			res.append(cur.word == null ? word : cur.word);
		}

		return res.toString();
    }

	class TrieNode {

		TrieNode[] children;
		String word;

		TrieNode() {
			children = new TrieNode[26];
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

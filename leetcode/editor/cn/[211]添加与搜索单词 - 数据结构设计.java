/**
<p>请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。</p>

<p>实现词典类 <code>WordDictionary</code> ：</p>

<ul>
	<li><code>WordDictionary()</code> 初始化词典对象</li>
	<li><code>void addWord(word)</code> 将 <code>word</code> 添加到数据结构中，之后可以对它进行匹配</li>
	<li><code>bool search(word)</code> 如果数据结构中存在字符串与 <code>word</code> 匹配，则返回 <code>true</code> ；否则，返回  <code>false</code> 。<code>word</code> 中可能包含一些 <code>'.'</code> ，每个 <code>.</code> 都可以表示任何一个字母。</li>
</ul>

<p> </p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
<strong>输出：</strong>
[null,null,null,null,false,true,true,true]

<strong>解释：</strong>
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= word.length <= 500</code></li>
	<li><code>addWord</code> 中的 <code>word</code> 由小写英文字母组成</li>
	<li><code>search</code> 中的 <code>word</code> 由 '.' 或小写英文字母组成</li>
	<li>最多调用 <code>50000</code> 次 <code>addWord</code> 和 <code>search</code></li>
</ul>
<div><li>👍 312</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class WordDictionary {


	class TrieNode {

		TrieNode[] children;
		boolean isEnd;

		public TrieNode() {
			children = new TrieNode[26];
			isEnd = false;
		}

		public void insert(String word) {
			TrieNode cur = trie;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (cur.children[c - 'a'] == null) {
					cur.children[c - 'a'] = new TrieNode();
				}
				cur = cur.children[c - 'a'];
			}

			cur.isEnd = true;
		}
	}

	TrieNode trie;
    public WordDictionary() {
		trie = new TrieNode();
    }
    
    public void addWord(String word) {
		trie.insert(word);
    }
    
    public boolean search(String word) {
		return search(word, 0, trie);
    }

	public boolean search(String word, int index, TrieNode node) {

		if (index == word.length()) {
			return node.isEnd;
		}

		char c = word.charAt(index);
		if (Character.isLetter(c)) {
			TrieNode child = node.children[c - 'a'];
			if (child != null && search(word, index + 1, child)) {
				return true;
			}
		}
		else {
			for (int i = 0; i < 26; i++) {
				TrieNode child = node.children[i];
				if (child != null && search(word, index + 1, child)) {
					return true;
				}
			}
		}

		return false;
	}
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)

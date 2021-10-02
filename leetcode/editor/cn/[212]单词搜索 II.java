import java.util.*;

/**
<p>给定一个 <code>m x n</code> 二维字符网格 <code>board</code><strong> </strong>和一个单词（字符串）列表 <code>words</code>，找出所有同时在二维网格和字典中出现的单词。</p>

<p>单词必须按照字母顺序，通过 <strong>相邻的单元格</strong> 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/07/search1.jpg" style="width: 322px; height: 322px;" />
<pre>
<strong>输入：</strong>board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
<strong>输出：</strong>["eat","oath"]
</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/07/search2.jpg" style="width: 162px; height: 162px;" />
<pre>
<strong>输入：</strong>board = [["a","b"],["c","d"]], words = ["abcb"]
<strong>输出：</strong>[]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == board.length</code></li>
	<li><code>n == board[i].length</code></li>
	<li><code>1 <= m, n <= 12</code></li>
	<li><code>board[i][j]</code> 是一个小写英文字母</li>
	<li><code>1 <= words.length <= 3 * 10<sup>4</sup></code></li>
	<li><code>1 <= words[i].length <= 10</code></li>
	<li><code>words[i]</code> 由小写英文字母组成</li>
	<li><code>words</code> 中的所有字符串互不相同</li>
</ul>
<div><div>Related Topics</div><div><li>字典树</li><li>数组</li><li>字符串</li><li>回溯</li><li>矩阵</li></div></div><br><div><li>👍 460</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

	int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<String> findWords(char[][] board, String[] words) {

		Trie trie = new Trie();
		for (String word : words) {
			trie.insert(word);
		}

		Set<String> res = new HashSet<>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(board, trie, i, j, res);
			}
		}

		return new ArrayList<>(res);
    }

	public void dfs(char[][] board, Trie cur, int i, int j, Set<String> res) {

		if (!cur.children.containsKey(board[i][j])) {
			return;
		}

		char ch = board[i][j];
		cur = cur.children.get(ch);
		if (cur.word != "") {
			res.add(cur.word);
		}

		board[i][j] = '#';

		for (int[] dir : dirs) {
			int i2 = i + dir[0];
			int j2 = j + dir[1];

			if (i2 >= 0 && i2 < board.length && j2 >= 0 && j2 < board[0].length) {
				dfs(board, cur, i2, j2, res);
			}
		}

		board[i][j] = ch;
	}

	// 前缀树
	class Trie {

		String word;
		Map<Character, Trie> children;
		boolean isWord;

		public Trie() {
			this.word = "";
			this.children = new HashMap<>();
		}

		public void insert(String word) {
			Trie cur = this;
			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				if (!cur.children.containsKey(ch)) {
					cur.children.put(ch, new Trie());
				}
				cur = cur.children.get(ch);
			}

			cur.word = word;
		}
	}

}
//leetcode submit region end(Prohibit modification and deletion)

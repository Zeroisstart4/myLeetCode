/**
<p>实现一个 <code>MapSum</code> 类，支持两个方法，<code>insert</code> 和 <code>sum</code>：</p>

<ul>
	<li><code>MapSum()</code> 初始化 <code>MapSum</code> 对象</li>
	<li><code>void insert(String key, int val)</code> 插入 <code>key-val</code> 键值对，字符串表示键 <code>key</code> ，整数表示值 <code>val</code> 。如果键 <code>key</code> 已经存在，那么原来的键值对将被替代成新的键值对。</li>
	<li><code>int sum(string prefix)</code> 返回所有以该前缀 <code>prefix</code> 开头的键 <code>key</code> 的值的总和。</li>
</ul>

<p> </p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>
["MapSum", "insert", "sum", "insert", "sum"]
[[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
<strong>输出：</strong>
[null, null, 3, null, 5]

<strong>解释：</strong>
MapSum mapSum = new MapSum();
mapSum.insert("apple", 3);  
mapSum.sum("ap");           // return 3 (<u>ap</u>ple = 3)
mapSum.insert("app", 2);    
mapSum.sum("ap");           // return 5 (<u>ap</u>ple + <u>ap</u>p = 3 + 2 = 5)
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= key.length, prefix.length <= 50</code></li>
	<li><code>key</code> 和 <code>prefix</code> 仅由小写英文字母组成</li>
	<li><code>1 <= val <= 1000</code></li>
	<li>最多调用 <code>50</code> 次 <code>insert</code> 和 <code>sum</code></li>
</ul>
<div><li>👍 105</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class MapSum {


	class TrieNode {
		int val;
		int count;
		boolean isEnd;
		TrieNode[] children;

		public TrieNode() {
			isEnd = false;
			children = new TrieNode[26];
		}
	}

	TrieNode trie;
    public MapSum() {
		trie = new TrieNode();
    }
    
    public void insert(String key, int val) {

		TrieNode cur = trie;
		int preVal = isExist(key);
		for (char c : key.toCharArray()) {
			if (cur.children[c - 'a'] == null) {
				cur.children[c - 'a'] = new TrieNode();
				cur.children[c - 'a'].count = val;
			}
			else {
				cur.children[c - 'a'].count -= preVal;
				cur.children[c - 'a'].count += val;
			}

			cur = cur.children[c - 'a'];
		}

		cur.isEnd = true;
		cur.val = val;
	}

	public int isExist(String key) {
		TrieNode cur = trie;
		for (char c : key.toCharArray()) {
			if (cur.children[c - 'a'] == null) {
				return 0;
			}
			cur = cur.children[c - 'a'];
		}

		return cur.isEnd ? cur.val : 0;
	}

    public int sum(String prefix) {

		TrieNode cur = trie;
		for (char c : prefix.toCharArray()) {
			if (cur.children[c - 'a'] == null) {
				return 0;
			}

			cur = cur.children[c - 'a'];
		}

		return cur.count;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

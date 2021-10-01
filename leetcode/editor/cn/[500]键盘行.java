import org.elasticsearch.action.admin.cluster.snapshots.create.CreateSnapshotRequest;

import java.util.ArrayList;

/**
<p>给你一个字符串数组 <code>words</code> ，只返回可以使用在 <strong>美式键盘</strong> 同一行的字母打印出来的单词。键盘如下图所示。</p>

<p><strong>美式键盘</strong> 中：</p>

<ul>
	<li>第一行由字符 <code>"qwertyuiop"</code> 组成。</li>
	<li>第二行由字符 <code>"asdfghjkl"</code> 组成。</li>
	<li>第三行由字符 <code>"zxcvbnm"</code> 组成。</li>
</ul>

<p><img alt="American keyboard" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/keyboard.png" style="width: 100%; max-width: 600px" /></p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>words = ["Hello","Alaska","Dad","Peace"]
<strong>输出：</strong>["Alaska","Dad"]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>words = ["omk"]
<strong>输出：</strong>[]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>words = ["adsdf","sfd"]
<strong>输出：</strong>["adsdf","sfd"]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= words.length <= 20</code></li>
	<li><code>1 <= words[i].length <= 100</code></li>
	<li><code>words[i]</code> 由英文字母（小写和大写字母）组成</li>
</ul>
<div><li>👍 138</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] findWords(String[] words) {

		String[] keys = new String[]{"qwertyuiopQWERTYUIOP", "asdfghjklASDFGHJKL", "zxcvbnmZXCVBNM"};
		ArrayList<String> ansList = new ArrayList<>();

		for (String word : words) {

			int line = 0;
			boolean flag = true;

			for (int i = 0; i < word.length(); i++) {

				if (line == 0) {
					line = findLine(keys, word.charAt(i));
				}
				else {
					if (findLine(keys, word.charAt(i)) != line) {
						flag = false;
						break;
					}
				}
			}

			if (flag) {
				ansList.add(word);
			}
		}

		String[] res = new String[ansList.size()];

		for (int i = 0; i < ansList.size(); i++) {
			res[i] = ansList.get(i);
		}

		return res;
    }

	public int findLine(String[] keys, char ch) {

		for (int i = 0; i < keys.length; i++) {

			String key = keys[i];
			if (key.indexOf(ch) != -1) {
				return i + 1;
			}
		}

		return -1;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
<p>所有 DNA 都由一系列缩写为 <code>'A'</code>，<code>'C'</code>，<code>'G'</code> 和 <code>'T'</code> 的核苷酸组成，例如：<code>"ACGAATTCCG"</code>。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。</p>

<p>编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 <code>s</code> 中出现次数超过一次。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
<strong>输出：</strong>["AAAAACCCCC","CCCCCAAAAA"]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "AAAAAAAAAAAAA"
<strong>输出：</strong>["AAAAAAAAAA"]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 <= s.length <= 10<sup>5</sup></code></li>
	<li><code>s[i]</code> 为 <code>'A'</code>、<code>'C'</code>、<code>'G'</code> 或 <code>'T'</code></li>
</ul>
<div><li>👍 249</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int len = 10;
    public List<String> findRepeatedDnaSequences(String s) {

        List<String> res = new ArrayList<>();
        Map<String, Integer> count = new HashMap<>();
        int n = s.length();
        for (int i = 0; i + len <= n; i++) {

            String temp = s.substring(i, i + len);
            count.put(temp, count.getOrDefault(temp, 0) + 1);
            if (count.get(temp) == 2) {
                res.add(temp);
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

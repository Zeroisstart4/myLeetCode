import java.util.ArrayList;
import java.util.List;

/**
<p>给定一个只包含数字的字符串 <code>s</code> ，用以表示一个 IP 地址，返回所有可能从&nbsp;<code>s</code> 获得的 <strong>有效 IP 地址 </strong>。你可以按任何顺序返回答案。</p>

<p><strong>有效 IP 地址</strong> 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 <code>0</code>），整数之间用 <code>&#39;.&#39;</code> 分隔。</p>

<p>例如：&quot;0.1.2.201&quot; 和 &quot;192.168.1.1&quot; 是 <strong>有效</strong> IP 地址，但是 &quot;0.011.255.245&quot;、&quot;192.168.1.312&quot; 和 &quot;192.168@1.1&quot; 是 <strong>无效</strong> IP 地址。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = &quot;25525511135&quot;
<strong>输出：</strong>[&quot;255.255.11.135&quot;,&quot;255.255.111.35&quot;]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = &quot;0000&quot;
<strong>输出：</strong>[&quot;0.0.0.0&quot;]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>s = &quot;1111&quot;
<strong>输出：</strong>[&quot;1.1.1.1&quot;]
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>s = &quot;010010&quot;
<strong>输出：</strong>[&quot;0.10.0.10&quot;,&quot;0.100.1.0&quot;]
</pre>

<p><strong>示例 5：</strong></p>

<pre>
<strong>输入：</strong>s = &quot;10203040&quot;
<strong>输出：</strong>[&quot;10.20.30.40&quot;,&quot;102.0.30.40&quot;,&quot;10.203.0.40&quot;]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 &lt;= s.length &lt;= 3000</code></li>
	<li><code>s</code> 仅由数字组成</li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 93&nbsp;题相同：<a href="https://leetcode-cn.com/problems/restore-ip-addresses/">https://leetcode-cn.com/problems/restore-ip-addresses/</a>&nbsp;</p>
<div><li>👍 8</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    static final int SEG_COUNT = 4;
    int[] segments;
    List<String> res;
    public List<String> restoreIpAddresses(String s) {

        segments = new int[SEG_COUNT];
        res = new ArrayList<>();
        dfs(s, 0, 0);

        return res;
    }

    public void dfs(String s, int curSeg, int index) {

        if (curSeg == SEG_COUNT) {
            if (index == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < SEG_COUNT; i++) {
                    sb.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        sb.append('.');
                    }
                }
                res.add(sb.toString());
            }
            return;
        }

        if (index == s.length()) {
            return;
        }

        if (s.charAt(index) == '0') {
            segments[curSeg] = 0;
            dfs(s, curSeg + 1, index + 1);
        }

        int addr = 0;
        for (int i = index; i < s.length(); i++) {

            addr = addr * 10 + (s.charAt(i) - '0');
            if (0 < addr && addr <= 255) {
                segments[curSeg] = addr;
                dfs(s, curSeg + 1, i + 1);
            }
            else {
                break;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

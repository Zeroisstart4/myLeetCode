import java.util.Arrays;
import java.util.List;

/**
<p>给定一个 24 小时制（小时:分钟 <strong>&quot;HH:MM&quot;</strong>）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>timePoints = [&quot;23:59&quot;,&quot;00:00&quot;]
<strong>输出：</strong>1
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>timePoints = [&quot;00:00&quot;,&quot;23:59&quot;,&quot;00:00&quot;]
<strong>输出：</strong>0
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 &lt;= timePoints &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>timePoints[i]</code> 格式为 <strong>&quot;HH:MM&quot;</strong></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 539&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/minimum-time-difference/">https://leetcode-cn.com/problems/minimum-time-difference/</a></p>
<div><div>Related Topics</div><div><li>数组</li><li>数学</li><li>字符串</li><li>排序</li></div></div><br><div><li>👍 0</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints == null || timePoints.size() < 2) {
            return 0;
        }

        int[] convert = timeConvert(timePoints);
        Arrays.sort(convert);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < convert.length - 1; i++) {
            int temp = convert[i + 1] - convert[i];
            min = Math.min(min, temp);
        }

        min = Math.min(min, 1440 + convert[0] - convert[convert.length - 1]);
        return min;
    }

    public int[] timeConvert(List<String> timePoints) {

        int size = timePoints.size();
        int[] res = new int[size];
        int index = 0;
        for (String timePoint : timePoints) {

            String[] split = timePoint.split(":");
            int miniutes = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            res[index++] = miniutes;
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

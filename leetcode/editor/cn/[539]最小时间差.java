import java.util.Arrays;
import java.util.List;

/**
<p>给定一个 24 小时制（小时:分钟 <strong>"HH:MM"</strong>）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>timePoints = ["23:59","00:00"]
<strong>输出：</strong>1
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>timePoints = ["00:00","23:59","00:00"]
<strong>输出：</strong>0
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 <= timePoints <= 2 * 10<sup>4</sup></code></li>
	<li><code>timePoints[i]</code> 格式为 <strong>"HH:MM"</strong></li>
</ul>
<div><div>Related Topics</div><div><li>数组</li><li>数学</li><li>字符串</li><li>排序</li></div></div><br><div><li>👍 99</li><li>👎 0</li></div>
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

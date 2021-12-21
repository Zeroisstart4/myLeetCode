import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
<p>给定一个整数数组 <code>nums</code> 和一个整数 <code>k</code>&nbsp;，请返回其中出现频率前 <code>k</code> 高的元素。可以按 <strong>任意顺序</strong> 返回答案。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入: </strong>nums = [1,1,1,2,2,3], k = 2
<strong>输出: </strong>[1,2]
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入: </strong>nums = [1], k = 1
<strong>输出: </strong>[1]</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>k</code> 的取值范围是 <code>[1, 数组中不相同的元素的个数]</code></li>
	<li>题目数据保证答案唯一，换句话说，数组中前 <code>k</code> 个高频元素的集合是唯一的</li>
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>所设计算法的时间复杂度 <strong>必须</strong> 优于 <code>O(n log n)</code> ，其中 <code>n</code><em>&nbsp;</em>是数组大小。</p>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 347&nbsp;题相同：<a href="https://leetcode-cn.com/problems/top-k-frequent-elements/">https://leetcode-cn.com/problems/top-k-frequent-elements/</a></p>
<div><li>👍 5</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

		Map<Integer, Integer> occurences = new HashMap<>();

		for (int num : nums) {
			occurences.put(num, occurences.getOrDefault(num, 0) + 1);
		}

		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

		for (Map.Entry<Integer, Integer> entry : occurences.entrySet()) {
			int num = entry.getKey();
			int count = entry.getValue();

			if (queue.size() == k) {
				if (queue.peek()[1] < count) {
					queue.poll();
					queue.offer(new int[]{num, count});
				}
			}
			else {
				queue.offer(new int[]{num, count});
			}
		}

		int[] res = new int[k];

		for (int i = 0; i < k; i++) {
			res[i] = queue.poll();
		}

		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

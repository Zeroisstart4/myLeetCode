import java.util.Random;

/**
<p>给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。</p>

<p>实现 <code>Solution</code> class:</p>

<ul>
	<li><code>Solution(int[] nums)</code> 使用整数数组 <code>nums</code> 初始化对象</li>
	<li><code>int[] reset()</code> 重设数组到它的初始状态并返回</li>
	<li><code>int[] shuffle()</code> 返回数组随机打乱后的结果</li>
</ul>

<p> </p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入</strong>
["Solution", "shuffle", "reset", "shuffle"]
[[[1, 2, 3]], [], [], []]
<strong>输出</strong>
[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]

<strong>解释</strong>
Solution solution = new Solution([1, 2, 3]);
solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 1, 2]
solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 200</code></li>
	<li><code>-10<sup>6</sup> <= nums[i] <= 10<sup>6</sup></code></li>
	<li><code>nums</code> 中的所有元素都是 <strong>唯一的</strong></li>
	<li>最多可以调用 <code>5 * 10<sup>4</sup></code> 次 <code>reset</code> 和 <code>shuffle</code></li>
</ul>
<div><li>👍 161</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

	private int[] array;
	private int[] original;

	Random random = new Random();

    public Solution(int[] nums) {
		array = nums;
		original = nums.clone();
    }
    
    public int[] reset() {

		array = original;
		original = original.clone();
		return original;
    }
    
    public int[] shuffle() {

		for (int i = 0; i < array.length; i++) {
			swap(i, randIndex(i, array.length));
		}

		return array;
    }

	public void swap(int x, int y) {

		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}

	public int randIndex(int min, int max) {
		return random.nextInt(max - min) + min;
	}

}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
//leetcode submit region end(Prohibit modification and deletion)

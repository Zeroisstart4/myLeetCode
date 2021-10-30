/**
<p>给你两个数组，<code>arr1</code> 和 <code>arr2</code>，</p>

<ul>
	<li><code>arr2</code> 中的元素各不相同</li>
	<li><code>arr2</code> 中的每个元素都出现在 <code>arr1</code> 中</li>
</ul>

<p>对 <code>arr1</code> 中的元素进行排序，使 <code>arr1</code> 中项的相对顺序和 <code>arr2</code> 中的相对顺序相同。未在 <code>arr2</code> 中出现过的元素需要按照升序放在 <code>arr1</code> 的末尾。</p>

<p> </p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
<strong>输出：</strong>[2,2,2,1,4,3,3,9,6,7,19]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= arr1.length, arr2.length <= 1000</code></li>
	<li><code>0 <= arr1[i], arr2[i] <= 1000</code></li>
	<li><code>arr2</code> 中的元素 <code>arr2[i]</code> 各不相同</li>
	<li><code>arr2</code> 中的每个元素 <code>arr2[i]</code> 都出现在 <code>arr1</code> 中</li>
</ul>
<div><li>👍 188</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

		int upper = Integer.MIN_VALUE;
		for (int i : arr1) {
			upper = Math.max(upper, i);
		}

		int[] frequency = new int[upper + 1];
		for (int i : arr1) {
			frequency[i]++;
		}

		int[] ans = new int[arr1.length];
		int index = 0;
		for (int x : arr2) {
			for (int i = 0; i < frequency[x]; i++) {
				ans[index++] = x;
			}
			frequency[x] = 0;
		}

		for (int x = 0; x <= upper; x++) {
			for (int i = 0; i < frequency[x]; i++) {
				ans[index++] = x;
			}
		}

		return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

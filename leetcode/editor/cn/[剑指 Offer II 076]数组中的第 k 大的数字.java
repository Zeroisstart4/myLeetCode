/**
<p>给定整数数组 <code>nums</code> 和整数 <code>k</code>，请返回数组中第 <code><strong>k</strong></code> 个最大的元素。</p>

<p>请注意，你需要找的是数组排序后的第 <code>k</code> 个最大的元素，而不是第 <code>k</code> 个不同的元素。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> <code>[3,2,1,5,6,4] 和</code> k = 2
<strong>输出:</strong> 5
</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre>
<strong>输入:</strong> <code>[3,2,3,1,2,4,5,5,6] 和</code> k = 4
<strong>输出:</strong> 4</pre>

<p>&nbsp;</p>

<p><strong>提示： </strong></p>

<ul>
	<li><code>1 &lt;= k &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>-10<sup>4</sup>&nbsp;&lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 215&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/kth-largest-element-in-an-array/">https://leetcode-cn.com/problems/kth-largest-element-in-an-array/</a></p>
<div><li>👍 6</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    static int len;
    public int findKthLargest(int[] nums, int k) {

        len = nums.length;
        buildHeap(nums);
        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
            swap(nums, 0, i);
            len--;
            adjustHeap(nums, 0);
        }

        return nums[0];
    }

    public void buildHeap(int[] nums) {
        for (int i = len / 2; i >= 0; i--) {
            adjustHeap(nums, i);
        }
    }

    public void adjustHeap(int[] nums, int i) {

        int parent  = i;
        if (i * 2 + 1 < len && nums[i * 2 + 1] > nums[parent]) {
            parent = i * 2 + 1;
        }
        if (i * 2 + 2 < len && nums[i * 2 + 2] > nums[parent]) {
            parent = i * 2 + 2;
        }

        if (parent != i) {
            swap(nums, parent, i);
            adjustHeap(nums, parent);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

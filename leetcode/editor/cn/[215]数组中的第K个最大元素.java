//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 1072 👎 0


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

        int parent = i;

        if(2 * i + 1< len && nums[2 * i + 1] > nums[parent]) {
            parent = 2 * i + 1;
        }
        if(2 * i + 2 < len && nums[2 * i + 2] > nums[parent]) {
            parent = 2 * i + 2;
        }

        if(parent != i) {
            swap(nums, parent, i);
            adjustHeap(nums, parent);
        }
    }
    public void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }




/*    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
            swap(nums, 0, i);
            heapSize--;
            adjustHeap(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildHeap(int[] nums, int heapSize) {
        for (int i = heapSize / 2; i >= 0; i--) {
            adjustHeap(nums, i, heapSize);
        }
    }

    public void adjustHeap(int[] nums, int i, int heapSize) {

        int parent = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < heapSize && nums[left] > nums[parent]) {
            parent = left;
        }
        if (right < heapSize && nums[right] > nums[parent]) {
            parent = right;
        }

        if (parent != i) {
            swap(nums, i, parent);
            adjustHeap(nums, parent, heapSize);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

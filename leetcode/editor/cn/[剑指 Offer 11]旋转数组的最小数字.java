//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2
//] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 
//
// 示例 1： 
//
// 输入：[3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 输入：[2,2,2,0,1]
//输出：0
// 
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sor
//ted-array-ii/ 
// Related Topics 二分查找 
// 👍 303 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 二分查找
    public int minArray(int[] numbers) {
        // 左边界索引
        int low = 0;
        // 右边界索引
        int high = numbers.length - 1;
        // 类二分查找
        while (low < high) {
            // 计算中间索引
            int pivot = low + ((high - low) >>> 1);
            // 若中间值比右边界值小，则将右边界索引缩小至 pivot
            if(numbers[pivot] < numbers[high]) {
                high = pivot;
            }
            // 若中间值比右边界值大，则将左边界索引缩小至 pivot + 1
            else if(numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            }
            // 若中间值等于右边界值，则将右边界索引缩小一位，从而改变中间值索引
            else {
                high--;
            }
        }

        return numbers[low];
    }

    /*public int minArray(int[] numbers) {

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (numbers[mid] < numbers[right]) {
                right = mid;
            }
            else if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            }
            else {
                right--;
            }
        }

        return numbers[left];
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

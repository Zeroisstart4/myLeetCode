//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 
// 👍 395 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int len1 = nums1.length;
        int len2 = nums2.length;

        int[] newArr = new int[len1 + len2];

        int index = 0;
        int index1 = 0;
        int index2 = 0;

        while (index1 < len1 && index2 < len2) {

            int num1 = nums1[index1];
            int num2 = nums2[index2];

            if (num1 == num2) {
                if (index == 0 || num1 != newArr[index - 1]) {
                    newArr[index++] = num1;
                }
                index1++;
                index2++;
            }
            else if (num1 < num2) {
                index1++;
            }
            else {
                index2++;
            }
        }

        return Arrays.copyOfRange(newArr, 0, index);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

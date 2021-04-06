//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nu
//ms2 的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -109 <= nums1[i], nums2[i] <= 109 
// 
// Related Topics 数组 双指针 
// 👍 874 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // API 调用
    // 先合并，再排序
   /*
   public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        
        Arrays.sort(nums1);
    }
    */

    // 双指针法
    /*
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 数组 nums1 指针
        int p1 = 0;
        // 数组 nums2 指针
        int p2 = 0;
        // 用于储存数组的值
        int[] newSorted = new int[m + n];
        int temp = 0;
        // 当两个数组仍存在数时
        while(p1 < m || p2 < n) {
            // 若数组 nums1 元素已全部加入新数组
            if(p1 == m) {
                // 只需将数组 nums2 元素全部依次加入新数组
                temp = nums2[p2++];
            }
            // 若数组 nums2 元素已全部加入新数组
            else if(p2 == n) {
                // 只需将数组 nums2 元素全部依次加入新数组
                temp = nums1[p1++];
            }
            // 若数组 nums1、nums2 皆有元素未加入新数组，比较大小，顺序加入
            else if(nums1[p1] < nums2[p2]) {
                temp = nums1[p1++];
            }
            else {
                temp = nums2[p2++];
            }
            newSorted[p1 + p2 - 1] = temp;
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = newSorted[i];
        }
    }
    */


    // 逆向双指针法
    /*
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int tail = m + n - 1;
        int cur = 0;
        while (p1 >= 0 || p2 >= 0) {
            if(p1 == -1) {
                cur = nums2[p2--];
            }
            else if(p2 == -1) {
                cur = nums1[p1--];
            }
            else if(nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            }
            else {
                cur = nums2[p2--];
            }
            
            nums1[tail--] = cur;
        }
        
    }
    */

    // 逆向双指针法简化
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int tail = m + n - 1;
        while (p2 >= 0) {
            nums1[tail--] = (p1 >= 0 && nums1[p1] > nums2[p2]) ? nums1[p1--] : nums2[p2--];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

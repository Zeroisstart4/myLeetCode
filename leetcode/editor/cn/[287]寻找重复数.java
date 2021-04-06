//给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。 
//
// 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,4,2,2]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,1,3,4,2]
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1]
//输出：1
// 
//
// 示例 4： 
//
// 
//输入：nums = [1,1,2]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 3 * 104 
// nums.length == n + 1 
// 1 <= nums[i] <= n 
// nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次 
// 
//
// 
//
// 进阶： 
//
// 
// 如何证明 nums 中至少存在一个重复的数字? 
// 你可以在不修改数组 nums 的情况下解决这个问题吗？ 
// 你可以只用常量级 O(1) 的额外空间解决这个问题吗？ 
// 你可以设计一个时间复杂度小于 O(n2) 的解决方案吗？ 
// 
// Related Topics 数组 双指针 二分查找 
// 👍 1148 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        // 1、 以数组的索引作为当前对象的地址值
        // 2、 以索引所对应的内容作为指向的下一个地址值
        // 3、 构造链表，然后通过快慢指针寻找链表环的入口。
        //
        // 为了保证地址不发生溢出（数组中元素的值比 nums.length - 1 还要大的情况），造成无法搜索下一地址的情况
        // 287. 寻找重复数给定了这个条件 ：给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n）
        // 剑指 Offer 03.给定了这个条件： 数组中重复的数字在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
        // 保证了地址的可访问性

        // 由于一个索引只能存储一个值，例如 a[0] = 1 , 故每个对象只有一个指向， 即地址 0 --> 地址 1
        // 而由于数组中存在重复元素，例如 a[1] = 3, a[2] = 3 ,即地址 1 --> 地址 3，地址 2 --> 地址 3，（有多个对象指向同一个地址）

        // 若地址 1，地址 2
        do {
            slow = nums[slow];
            fast =nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

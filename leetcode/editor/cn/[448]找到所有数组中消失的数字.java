//给定一个范围在 1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。 
//
// 找到所有在 [1, n] 范围之间没有出现在数组中的数字。 
//
// 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。 
//
// 示例: 
//
// 
//输入:
//[4,3,2,7,8,2,3,1]
//
//输出:
//[5,6]
// 
// Related Topics 数组 
// 👍 715 👎 0


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        ArrayList<Integer> arr = new ArrayList<>();
        int len = nums.length;

        // 模拟 map.put() 操作
        for (int i = 0; i < len; i++) {

            // 查看当前元素应该放在哪个桶中，模拟 hashMap 的数组寻址操作
            int index = (nums[i] - 1) % len;
            // 模拟将数组寻址后的元素存入 hashMap,
            // 由于本题给定围数组元素范围在 1 ≤ a[i] ≤ n ( n = 数组大小 )
            // 故人为设置其储存形式为（index， index%len + 1），以 index 为键，（index%len + 1）为值
            // 为标记 index 处已被使用，且不改变 index 初始元素的修改方式，进行 nums[index] + len 操作
            nums[index] = nums[index] + len;
        }

        // 模拟 map.get（） 操作
        for (int i = 0; i < nums.length; i++) {
            // 由于 nums[i] 的原始值都大于 0, 故若进行过存值操作，则有 （nums[i] = nums[index] + len）> len
            // 故该条件表示该处未进行过存值操作，即该处所存的值是在 [1, n] 范围之间没有出现在数组中的数字。其值为 （i + 1）
            if(nums[i] <= len) {
                arr.add(i + 1);
            }
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

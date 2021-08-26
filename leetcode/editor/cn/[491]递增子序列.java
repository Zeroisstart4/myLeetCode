//给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是 2 。 
//
// 
//
// 示例： 
//
// 
//输入：[4, 6, 7, 7]
//输出：[[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]
//] 
//
// 
//
// 提示： 
//
// 
// 给定数组的长度不会超过15。 
// 数组中的整数范围是 [-100,100]。 
// 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。 
// 
// Related Topics 位运算 数组 哈希表 回溯 
// 👍 306 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
       dfs(nums, 0, Integer.MIN_VALUE);
       return ans;
    }


    /**
     *  回溯
     * @param nums      代检测数组
     * @param cur       当前索引下标
     * @param last      子序列的末尾值
     */
    public void dfs(int[] nums, int cur, int last) {
        // 递归中止条件
        if (cur == nums.length) {
            if (temp.size() >= 2) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        
        // 添加该节点
        if (nums[cur] >= last) {
            temp.add(nums[cur]);
            dfs(nums, cur + 1, nums[cur]);
            temp.remove(temp.size() - 1);
        }
        
        // 过滤该节点
        if (nums[cur] != last) {
            dfs(nums, cur + 1, last);
        }
    }
    
}
//leetcode submit region end(Prohibit modification and deletion)

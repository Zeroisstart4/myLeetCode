//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 707 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res;
    boolean[] visited;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        visited = new boolean[nums.length];
        Arrays.sort(nums);
        backTrack(nums, new LinkedList<>(), 0);
        return res;
    }

    public void backTrack(int[] nums, LinkedList<Integer> list, int index) {

        if(index == nums.length) {
            res.add(new LinkedList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if(visited[i] || i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) {
                continue;
            }

            list.add(nums[i]);
            visited[i] = true;
            backTrack(nums, list, index + 1);
            visited[i] = false;
            list.removeLast();
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

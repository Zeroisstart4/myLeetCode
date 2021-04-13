//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。 
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出："1"
// 
//
// 示例 4： 
//
// 
//输入：nums = [10]
//输出："10"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 109 
// 
// Related Topics 排序 
// 👍 538 👎 0


import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String largestNumber(int[] nums) {
        // 1. 特判
        if (nums.length == 0 || nums == null) {
            return "";
        }

        // 2. 使用优先队列排序：大顶堆
        PriorityQueue<String> pq = new PriorityQueue<>((str1, str2) -> {
            String res1 = str1 + str2;
            String res2 = str2 + str1;
            // 大顶堆：比较字符串拼接后大小
            return res2.compareTo(res1);
        });

        // 3. nums元素转为String,并放入PQ进行排序
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        // 加入到大顶堆中
        pq.addAll(list);

        // 4. 从大顶堆中取出结果加入到结果集中
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.remove());
        }

        // 5. 最后对结果进行检查
        if(sb.toString().charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

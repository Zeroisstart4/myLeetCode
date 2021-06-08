//在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只
//能放在更大的盘子上面)。移动圆盘时受到以下限制: 
//(1) 每次只能移动一个盘子; 
//(2) 盘子只能从柱子顶端滑出移到下一根柱子; 
//(3) 盘子只能叠在比它大的盘子上。 
//
// 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。 
//
// 你需要原地修改栈。 
//
// 示例1: 
//
//  输入：A = [2, 1, 0], B = [], C = []
// 输出：C = [2, 1, 0]
// 
//
// 示例2: 
//
//  输入：A = [1, 0], B = [], C = []
// 输出：C = [1, 0]
// 
//
// 提示: 
//
// 
// A中盘子的数目不大于14个。 
// 
// Related Topics 递归 
// 👍 96 👎 0


import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 偷懒解法
    /*public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        C.addAll(A);
    }*/

    // 递归法
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        hanoi(A.size(), A, B, C);
    }

    /**
     *      汉诺塔
     * @param nums      盘子个数
     * @param A         A 柱
     * @param B         B 柱
     * @param C         C 柱
     */
    public void hanoi(int nums, List<Integer> A, List<Integer> B, List<Integer> C) {

        // 若只有一个盘子，直接从 A 柱移动至 C 柱
        if(nums == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        }

        // 将 A 柱的前 （nums - 1）个盘子先以 C 柱作为中转站移动至 B 柱
        hanoi(nums - 1, A, C, B);
        // 清空 A 柱，将 A 柱中的最后一个盘子添加至 C 柱
        C.add(A.remove(A.size() - 1));
        // 将 B 柱的前 （nums - 1）个盘子以 A 柱作为中转站移动至 C 柱
        hanoi(nums - 1, B, A, C);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

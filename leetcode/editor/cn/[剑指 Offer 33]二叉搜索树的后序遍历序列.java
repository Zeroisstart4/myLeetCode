//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// 👍 260 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 递归分治
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    /**
     *  检验 BST
     * @param postorder     后序遍历数组
     * @param left          左边界
     * @param right         右边界
     * @return
     */
    public boolean recur(int[] postorder, int left, int right) {

        // 若左边界大于等于右边界，无检验必要，返回 true
        if(left >= right) {
            return true;
        }

        // 从左边界起开始检验
        int cur = left;

        // 左子树的值小于根节点的值
        while (postorder[cur] < postorder[right]) {
            cur++;
        }

        // 记录左、右子树分界点
        int mid = cur;

        // 右子树的值大于根节点的值
        while (postorder[cur] > postorder[right]) {
            cur++;
        }

        // 检查树的长度是否相符，同时递归检测左、右子树是否也是 BST
        return cur == right && recur(postorder, left, mid - 1) && recur(postorder, mid, right - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

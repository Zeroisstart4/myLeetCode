//返回与给定的前序和后序遍历匹配的任何二叉树。 
//
// pre 和 post 遍历中的值是不同的正整数。 
//
// 
//
// 示例： 
//
// 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
//输出：[1,2,3,4,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= pre.length == post.length <= 30 
// pre[] 和 post[] 都是 1, 2, ..., pre.length 的排列 
// 每个输入保证至少有一个答案。如果有多个答案，可以返回其中一个。 
// 
// Related Topics 树 
// 👍 165 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    // 由于需要在另一个方法中用到前序遍历数组，故将其共享
    int[] pre;
    // 创建字典，用于通过的数组元素值查找其对应的索引
    HashMap<Integer, Integer> postMap = new HashMap<>();
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        // 共享前序遍历数组
        this.pre = pre;

        // 将中序遍历数组添加入 inMap， 键为数组的元素值 inorder[i]，值为数组的索引 i
        for (int i = 0; i < post.length; i++) {
            postMap.put(post[i], i);
        }

        return recur(0, pre.length - 1, 0);
    }

    /**
     * 根据前序后序构建树
     * @param begin         前序的起点下标
     * @param end           前序的终点下标
     * @param postBegin     后序的起点下标
     * @return
     */
    TreeNode recur(int begin, int end, int postBegin) {
        // 递归中止条件，若树的左边界比右边界大，则返回空
        if (begin > end) {
            return null;
        }

        //前序第一个结点就是当前根结点
        TreeNode newRoot = new TreeNode(pre[begin]);
        //若还有子结点
        if(begin < end) {
            // 查找根节点在后序遍历中对应的索引
            int index = postMap.get(pre[begin + 1]);
            //计算左子树结点数
            int leftCount = index - postBegin + 1;
            // 递归创建左子节树
            newRoot.left = recur(begin + 1, begin + leftCount, postBegin);
            // 递归创建右子节树
            newRoot.right = recur(begin + leftCount + 1, end, postBegin + leftCount);
        }
        // 返回树的根节点
        return newRoot;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

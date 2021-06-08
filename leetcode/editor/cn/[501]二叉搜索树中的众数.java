//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。 
//
// 假定 BST 有如下定义： 
//
// 
// 结点左子树中所含结点的值小于等于当前结点的值 
// 结点右子树中所含结点的值大于等于当前结点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 例如： 
//给定 BST [1,null,2,2], 
//
//    1
//    \
//     2
//    /
//   2
// 
//
// 返回[2]. 
//
// 提示：如果众数超过1个，不需考虑输出顺序 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// Related Topics 树 
// 👍 308 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    List<Integer> mList = new ArrayList<>();
    //表示当前节点的值
    int curent = 0;
    //和当前节点值相同的节点数量
    int count = 0;
    //最大的重复数量
    int maxCount = 0;


    public int[] findMode(TreeNode root) {
        inorder(root);
        //把集合list转化为数组
        int[] res = new int[mList.size()];

        for (int i = 0; i < mList.size(); i++) {
            res[i] = mList.get(i);
        }

        return res;
    }
    //二叉搜索树中的众数
    public void inorder(TreeNode node) {
        //终止条件判断
        if(node == null) {
            return;
        }

        inorder(node.left);
        //下面是对当前节点的一些逻辑操作
        int value = node.val;

        if(value == curent) {
            //如果节点值等于curent，count就加1
            count++;
        }
        else {
            //否则，就表示遇到了一个新的值，curent和count都要重新赋值
            curent = value;
            count = 1;
        }

        if(count == maxCount) {
            mList.add(value);
        }
        else if(count > maxCount) {
            //否则，当前节点的值重复量是最多的，直接把list清空，然后把当前节点的值加入到集合中
            mList.clear();
            mList.add(value);
            maxCount = count;
        }

        //遍历右子树
        inorder(node.right);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

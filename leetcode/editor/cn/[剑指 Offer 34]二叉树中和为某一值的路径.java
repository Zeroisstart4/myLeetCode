//输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。 
//
// 
//
// 示例: 
//给定如下二叉树，以及目标和 target = 22， 
//
// 
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// 
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/ 
// Related Topics 树 深度优先搜索 
// 👍 183 👎 0


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
    public List<List<Integer>> pathSum(TreeNode root, int target) {

        List<List<Integer>> res = new ArrayList<>();
        dfs(root, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(TreeNode root, int sum, int total, List<Integer> list, List<List<Integer>> res) {

        //如果节点为空直接返回
        if(root == null) {
            return;
        }

        //把当前节点值加入到list中
        list.add(root.val);

        //每往下走一步就要计算走过的路径和
        total += root.val;
        //如果到达叶子节点，就不能往下走了，直接return
        if(root.left == null && root.right == null) {
            //如果到达叶子节点，并且sum等于toal，说明我们找到了一组，要把它放到result中
            if(sum == total) {
                res.add(new ArrayList<>(list));
                //注意别忘了把最后加入的结点值给移除掉，因为下一步直接return了，不会再走最后一行的remove了，所以这里在rerurn之前提前把最后一个结点的值给remove掉。
                list.remove(list.size() - 1);
                //到叶子节点之后直接返回，因为在往下就走不动了
                return;
            }
        }

        //如果没到达叶子节点，就继续从他的左右两个子节点往下找
        dfs(root.left, sum, total, list, res);
        dfs(root.right, sum, total, list, res);

        //我们要理解递归的本质，当递归往下传递的时候他最后还是会往回走，我们把这个值使用完之后还要把它给移除，这就是回溯
        list.remove(list.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

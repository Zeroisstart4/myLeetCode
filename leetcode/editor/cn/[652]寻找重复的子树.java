//给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。 
//
// 两棵树重复是指它们具有相同的结构以及相同的结点值。 
//
// 示例 1： 
//
//         1
//       / \
//      2   3
//     /   / \
//    4   2   4
//       /
//      4
// 
//
// 下面是两个重复的子树： 
//
//       2
//     /
//    4
// 
//
// 和 
//
//     4
// 
//
// 因此，你需要以列表的形式返回上述重复子树的根结点。 
// Related Topics 树 
// 👍 252 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.HashMap;

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
    // 二叉树问题首先需要找出每个节点所需要进行的共同操作，随后递归即可

    // 用于储存重复子树结果
    List<TreeNode> list = new ArrayList<>();
    // 用于查找子树是否重复
    Map<String, Integer> count = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        buildSerial(root);
        return list;
    }
    // 由于树结构的较为复杂，故比较其是否相同较为复杂，若可以转为数组、字符串等形式则可使检查更为简便
    // 故将该树及其子树进行序列化，便于比较
    public String buildSerial(TreeNode node) {
        // 若该树为空，则以 # 作为标记
        if(node == null) {
            return "#";
        }

        // 序列化该树及其子树，递归的过程并不容易理解，无需过多的关注，只需明白递归操作可以让该树及其子树进行相同的操作（序列化）
        String serial = node.val + "," + buildSerial(node.left) + "," + buildSerial(node.right);
        // 将该序列化结果添加入 map 集合
        // 若该序列化结果已经存在，则获取其值，在原结果上加一，若该序列化结果不存在，初始化为 1
        // 使用 hashMap 的目的有两个：
        // 1. 用于存储序列化结果
        // 2. 用于结果查重
        count.put(serial, count.getOrDefault(serial, 0) + 1);
        // 若该序列化结果出现过两次，则将其添加入 list 集合
        if(count.get(serial) == 2) {
            list.add(node);
        }

        return serial;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

//请实现两个函数，分别用来序列化和反序列化二叉树。 
//
// 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字
//符串反序列化为原始的树结构。 
//
// 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方
//法解决这个问题。 
//
// 
//
// 示例： 
//
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
// 
//
// 
//
// 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-b
//inary-tree/ 
// Related Topics 树 设计 
// 👍 166 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rserialize(root, "");
    }

    // 序列化逻辑
    public String rserialize(TreeNode root, String str) {
        // 若为空树
        if(root == null) {
            str += "None,";
        }
        // 不为空树
        else {
            // 前序遍历
            str += str.valueOf(root.val) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }

        return str;
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        LinkedList<String> dataList = new LinkedList<>(Arrays.asList(dataArray));
        return rdeserialize(dataList);
    }

    // 反序列化逻辑
    public TreeNode rdeserialize(List<String> list) {

        // 健壮性判断
        if(list == null || list.size() == 0) {
            return null;
        }

        // 若为 "None"， 表示该处为空节点
        if(list.get(0).equals("None")) {
            list.remove(0);
            return null;
        }

        // 根节点
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        // 已经使用，移除该节点值
        list.remove(0);
        // 递归
        root.left = rdeserialize(list);
        root.right = rdeserialize(list);

        return root;
    }


/*    public String rserialize(TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        }
        else {
            str += String.valueOf(root.val) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }

        return str;
    }

    public TreeNode rdeserialize(List<String> list) {

        if (list == null || list.size() == 0) {
            return null;
        }
        if (list.get(0).equals("None")) {
            list.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = rdeserialize(list);
        root.right = rdeserialize(list);

        return root;
    }*/
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

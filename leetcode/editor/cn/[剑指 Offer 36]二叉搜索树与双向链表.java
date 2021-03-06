//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。 
//
// 
//
// 为了让您更好地理解问题，以下面的二叉搜索树为例： 
//
// 
//
// 
//
// 
//
// 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是
//第一个节点。 
//
// 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。 
//
// 
//
// 
//
// 
//
// 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。 
//
// 
//
// 注意：本题与主站 426 题相同：https://leetcode-cn.com/problems/convert-binary-search-tree-
//to-sorted-doubly-linked-list/ 
//
// 注意：此题对比原题有改动。 
// Related Topics 分治算法 
// 👍 243 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    Node head, pre;
    public Node treeToDoublyList(Node root) {

        if(root == null) {
            return null;
        }

        dfs(root);

        head.left = pre;
        pre.right = head;

        return head;
    }

    // 实质是二叉搜索树的中序遍历
    public void dfs(Node cur) {
        // 健壮性判断
        if(cur == null) {
            return;
        }

        // 递归左子树
        dfs(cur.left);

        // 若前驱节点不为空
        if(pre != null) {
            // 前驱节点的下一节点为当前节点
            pre.right = cur;
        }
        // 若前驱节点为空
        else {
            // 则当前节点为头节点
            head = cur;
        }

        // 当前节点的上一位为前驱节点
        cur.left = pre;
        // 前驱节点后移一位
        pre = cur;

        // 递归右子树
        dfs(cur.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

import sun.security.krb5.internal.crypto.NullEType;

/*
 * @lc app=leetcode.cn id=563 lang=java
 *
 * [563] 二叉树的坡度
 *
 * https://leetcode-cn.com/problems/binary-tree-tilt/description/
 *
 * algorithms
 * Easy (46.59%)
 * Total Accepted:    2.3K
 * Total Submissions: 4.9K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个二叉树，计算整个树的坡度。
 * 
 * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
 * 
 * 整个树的坡度就是其所有节点的坡度之和。
 * 
 * 示例:
 * 
 * 
 * 输入: 
 * ⁠        1
 * ⁠      /   \
 * ⁠     2     3
 * 输出: 1
 * 解释: 
 * 结点的坡度 2 : 0
 * 结点的坡度 3 : 0
 * 结点的坡度 1 : |2-3| = 1
 * 树的坡度 : 0 + 0 + 1 = 1
 * 
 * 
 * 注意:
 * 
 * 
 * 任何子树的结点的和不会超过32位整数的范围。
 * 坡度的值不会超过32位整数的范围。
 * 
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    //TODO:
    private int sum1 = 0;
    private int sum2 = 0;

    public int findTilt(TreeNode root) {
        return func2(root);
    }

    private int func1(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left != null)
            getSum(root.left, 1);
        if (root.right != null)
            getSum(root.right, 2);
        return Math.abs(sum1 - sum2);
    }

    private void getSum(TreeNode root, int type) {
        if (root == null)
            return;
        if (type == 1) {
            sum1 += root.val;
        } else {
            sum2 += root.val;
        }
        if (root.left != null)
            getSum(root.left, type);
        if (root.right != null)
            getSum(root.right, type);
    }

    private int func2(TreeNode root){
        ArrayList<Integer> tilt = new ArrayList();
        sumNodes(root, tilt);
        int sum =0;
        for (Integer t: tilt) {
            sum = sum + t;
        }
        return sum;
    }

    private int sumNodes(TreeNode root , List<Integer> tilt) {
        if (root == null) {
            return 0;
        }
        int left = sumNodes(root.left , tilt);
        int right = sumNodes(root.right , tilt);
        tilt.add(Math.abs(left -right));
        return left + right + root.val;
    }

}

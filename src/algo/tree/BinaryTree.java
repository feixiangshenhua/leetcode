/**
 * Project Name: 邮乐支付系统
 * File Name: BinaryTree
 * Package Name: algo.tree
 * Date: 2019/9/27 17:42
 * Copyright (c) 2019, 上海邮乐网络技术有限公司
 * author：xiao.y
 */
package algo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: BinaryTree <br>
 * Function: 二叉树. <br>
 * Date: 2019/9/27 17:42 <br>
 */
public class BinaryTree {
    /**
     * 先序编列
     * @param root
     */
    void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.data);  // 此处为伪代码，表示打印 root 节点
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历
     * @param root
     */
    void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.println(root.data); // 此处为伪代码，表示打印 root 节点
        inOrder(root.right);
    }

    /**
     * 后序遍历
     * @param root
     */
    void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);  // 此处为伪代码，表示打印 root 节点
    }

    void levelOrder(TreeNode root) {
        List<List<TreeNode>> lists = new ArrayList<>();
        levelHelper(root, 0, lists);
    }

    void levelHelper(TreeNode root, int height, List<List<TreeNode>> list) {
        if (root == null) return;
        if (list.size() <= height) {
            list.add(new LinkedList<>());
        }
        list.get(height).add(root);
        levelHelper(root.left, height + 1, list);
        levelHelper(root.right, height + 1, list);
    }

}
class TreeNode{
    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }
}
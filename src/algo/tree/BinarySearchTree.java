/**
 * Project Name: 邮乐支付系统
 * File Name: BinarySearchTree
 * Package Name: algo.tree
 * Date: 2019/9/29 10:22
 * Copyright (c) 2019, 上海邮乐网络技术有限公司
 * author：xiao.y
 */
package algo.tree;

/**
 * ClassName: BinarySearchTree <br>
 * Function: 二叉查找树. <br>
 * Date: 2019/9/29 10:22 <br>
 */
public class BinarySearchTree {
    TreeNode tree;

    /**
     * 查找
     * @param data
     * @param root
     * @return
     */
    public TreeNode find(int data, TreeNode root) {
        while (root != null) {
            if (root.data == data){
                return root;
            }else if (root.data > data) {
                find(data, root.left);
            }else {
                find(data, root.right);
            }
        }
        return null;
    }

    /**
     * 二叉树的插入
     * @param data
     * @param root
     */
    public void insert(int data, TreeNode root) {
        if (root == null) {
            root = new TreeNode(data);
        }else {
            while (root != null) {
                if (root.data > data) {
                    if (root.left == null) {
                        root.left = new TreeNode(data);
                        return;
                    }
                    root = root.left;
                }else {
                    if (root.right == null) {
                        root.right = new TreeNode(data);
                        return;
                    }
                    root = root.right;
                }
            }
        }
    }

    public void delete(int data,  TreeNode root) {
        TreeNode p = root; // p指向要删除的节点，初始化指向根节点
        TreeNode pp = null; // pp记录的是p的父节点
        while(p.data != data) {
            pp = p;
            if (p.data > data) {
                p = p.left;
            }else {
                p = p.right;
            }
        }
        if (p == null) return; // 没有找到
        // 要删除的节点有两个子节点
        if (p.left != null && p.right != null) {
            TreeNode minNode = p.right;
            TreeNode minPNode = p;
            while (minNode.left != null) {
                minPNode = minNode;
                minNode = minPNode.left;
            }
            p.data = minNode.data;
            pp = minPNode;
        }
        // 删除节点是叶子节点或者仅有一个子节点
        else {
            if (p.left == null && p.right == null) {
                pp.left = null;
                pp.right = null;
            }else {
                TreeNode node = p.left == null? p.right : p.left;
                if (pp.left == p) {
                    pp.left = node;
                }else {
                    pp.right = node;
                }
            }

        }
    }

    public TreeNode findMin() {
        if (tree == null) return null;
        TreeNode p = tree;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    public TreeNode findMax() {
        if (tree == null) return null;
        TreeNode p = tree;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }
}

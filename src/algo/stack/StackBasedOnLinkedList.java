/**
 * Project Name: 邮乐支付系统
 * File Name: StackBasedOnLinkedList
 * Package Name: algo.stack
 * Date: 2019/9/17 10:33
 * Copyright (c) 2019, 上海邮乐网络技术有限公司
 * author：xiao.y
 */
package algo.stack;

/**
 * ClassName: StackBasedOnLinkedList <br>
 * Function: 基于链表实现的栈. <br>
 * Date: 2019/9/17 10:33 <br>
 */
public class StackBasedOnLinkedList {
    private Node top = null;

    public void push(int value) {
        Node newNode = new Node(value, null);
        // 判断是否栈空
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    /**
     * 我用-1表示栈中没有数据。
     */
    public int pop() {
        if (top == null) {
            return -1;
        }
        int value = top.data;
        top = top.next;
        return value;
    }

    public void printAll() {
        Node p = top;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    private static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

}
/**
 * Project Name: 邮乐支付系统
 * File Name: QueueBasedOnLinkedList
 * Package Name: algo.queue
 * Date: 2019/9/17 17:19
 * Copyright (c) 2019, 上海邮乐网络技术有限公司
 * author：xiao.y
 */
package algo.queue;

/**
 * ClassName: QueueBasedOnLinkedList <br>
 * Function: 基于链表实现的队列. <br>
 * Date: 2019/9/17 17:19 <br>
 */
public class QueueBasedOnLinkedList {
    // 队列的队首和队尾
    private Node head = null;
    private Node tail = null;

    // 入队
    public void enqueue(String value) {
        if (tail == null) {
            Node newNode = new Node(value, null);
            head = newNode;
            tail = newNode;
        } else {
            tail.next = new Node(value, null);
            tail = tail.next;
        }
    }

    // 出队
    public String dequeue() {
        if (head == null) return null;

        String value = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return value;
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    private static class Node {
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }
    }
}

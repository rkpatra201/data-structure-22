package commons;

import java.util.List;

public class Node {
    public Integer data;
    public Node next;
    public Node prev;
    public Node right;
    public Node last;
    public Node root;
    public int size;

    public void appendDll(int data) {
        if (this.data == null) {
            this.data = data;
            this.last = this;
            this.prev = this;
            this.root = this;
        } else {
            Node temp = new Node();
            temp.data = data;
            temp.prev = getLast();
            getLast().next = temp;
            this.last = temp;
        }
    }

    public void append(int data) {
        size++;
        if (this.data == null) {
            this.data = data;
            this.last = this;
            this.root = this;
            return;
        }
        Node temp = new Node();
        temp.data = data;
        getLast().next = temp;
        this.last = temp;
    }

    private Node getLast() {
        return this.last;
    }

    public List<Integer> asArray() {
        return DsUtils.linkedListAsArray(this);
    }
    public List<Integer> asArray_1() {
        return DsUtils.linkedListAsArray_1(this);
    }

    public Node reverse() {
        // 1, 2, 3, 4, 5
        //  2, 1, 3, 4, 5
        Node oldRoot = root;
        Node current = root.next; // 2,3,4,5
        root.next = null; // root 1 - null
        while (current != null) {
            Node currentNext = current.next; // 3 - 4 -5
            Node temp = current; // 2
            temp.next = root; // 2 - 1 - null
            root = temp; // root 2 - 1 - null
            current = currentNext; // 3 - 4 - 5
        }
        root.last = oldRoot;// unused in this context
        return root;
    }
}

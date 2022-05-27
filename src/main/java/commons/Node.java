package commons;

import java.util.List;

public class Node {
    public Integer data;
    public Node next;
    public Node right;
    public Node last;
    public int size;

    public void append(int data) {
        size++;
        if (this.data == null) {
            this.data = data;
            this.last = this;
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
}

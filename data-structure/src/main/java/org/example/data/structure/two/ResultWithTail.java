package org.example.data.structure.two;

public class ResultWithTail {
    public LinkedListNode tail;
    public int size;
    public ResultWithTail(LinkedListNode tail, int size) {
        this.tail = tail;
        this.size = size;
    }

    static ResultWithTail getTailAndSize(LinkedListNode list) {
        if (list == null) return null;

        int size = 1;
        LinkedListNode current = list;
        while (current.next != null) {
            size++;
            current = current.next;
        }
        return new ResultWithTail(current, size);
    }
}

import java.util.*;


class ListNode<T> {
    T data;
    ListNode<T> next;
    ListNode(T data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}

class LList<T> {
    ListNode<T> head;
    LList() {
        head = null;
    }
    LList(ListNode<T> node) {
        this.head = node;
    }

    public void traverse() {
        ListNode<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
        }
        System.out.println();
    }
}



public class LinkedListImpl {

    public static void main (String args []) {

    }
}
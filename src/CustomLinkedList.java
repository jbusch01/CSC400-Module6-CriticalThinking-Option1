import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomLinkedList {
    private Node head;

    // Method for inserting a new node
    public void insert(int data) {
        Node newNode = new Node(data);
        // If list is empty, set new node as head
        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // Method for deleting a node
    public void delete(int data) {
        if (head == null) return;

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node prev = head;
        Node current = head.next;

        while (current != null) {
            if (current.data == data) {
                prev.next = current.next;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    // Iterator method to allow traversal
    public Iterator<Integer> iterator() {
        return new LinkedListIterator();
    }

    // Building block for LinkedList
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Enables external iteration using jav's iterator interface
    private class LinkedListIterator implements Iterator<Integer> {
        private Node current = head;

        // Returns True if current node isn't null
        @Override
        public boolean hasNext() {
            return current != null;
        }

        // Returns current node's data
        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int data = current.data;
            current = current.next;
            return data;
        }
    }
}
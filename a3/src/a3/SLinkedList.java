package a3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation of {@code LList<T>} as a singly linked list.
 */
public class SLinkedList<T> implements LList<T> {

    /**
     * Number of values in the linked list.
     */
    private int size;
    /**
     * First and last nodes of the linked list (null if size is 0)
     */
    private Node<T> head, tail;

    /**
     * Creates: an empty linked list.
     */
    public SLinkedList() {
        size = 0;
        head = tail = null;
    }

    boolean classInv() {
        assert size >= 0;
        if (size == 1){
            head = tail;
        }
        return true;
    }

    public int size() {
        return size;
    }

    public T head() {
        return head.data();
    }

    public T tail() {
        return tail.data();
    }

    public void prepend(T v) {
        assert classInv();
        Node<T> n = new Node<>(v, head);
        head = n;
        if (tail == null) tail = head;
        size++;
        assert classInv();
    }


    /**
     * Return a representation of this list: its values, with "[" at the beginning, "]" at the
     * end, and adjacent ones separated by ", " . Takes time proportional to the length of this
     * list. E.g. for the list containing 4 7 8 in that order, the result it "[4, 7, 8]".
     * E.g. for the list containing two empty strings, the result is "[, ]"
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("[");
        Node<T> n = head;
        while (n != null) {
            res.append(n.data());
            // do not add ", " if node n is last node [3, 4]
            if (n.next() != null) {
                res.append(", ");
            }
            // move pointer
            n = n.next();
        }
        return res + "]";
    }

    /**
     * append(T v): This method must run in constant time rather than iterating through the list
     */
    public void append(T v) {
        // TODO 2
        Node<T> n = new Node<>(v, null);

        if (tail != null) {
            tail.setNext(n);
        }

        tail = n;

        if (head == null) head = tail;
        size++;
        assert classInv();
    }

    /**
     * Insert value x before y
     * @param x insert value
     * @param y insert before y
     */
    public void insertBefore(T x, T y) {
        assert classInv();
        // TODO 3
        Node<T> prev = new Node<>(null, head);
        Node<T> current = head;
        if (head.data().equals(y)) {
            prepend(x);
        } else {
            // stop loop when the value of next node equal to y
            while (current != null && (!current.data().equals(y))) {
                // move pointer
                prev = prev.next();
                current = current.next();
            }
            Node<T> n = new Node<>(x, current);
            prev.setNext(n);
            n.setNext(current);
        }
        size++;
    }

    /**
     * Use for loop to get the value of index number
     *
     * @param k index number
     * @return k's node value
     */
    public T get(int k) {
        assert classInv();
        Node<T> n = head, tNode = null;
        if (head == null) return null;
        for (int i = 0; i <= k; i++) {
            tNode = n;
            n = n.next();
        }
        return tNode.data();
    }

    /**
     * contains(T elem):
     * This method should return true if elem is in the linked list, and false otherwise.
     */
    public boolean contains(T value) {
        Node<T> elem = head;
        while (elem != null) {
            if (elem.data().equals(value)) {
                return true;
            } else elem = elem.next();
        }
        return false;
    }

    /**
     * remove(T x): This method returns whether x was removed or not.
     * If x is successfully removed, the method should return true, otherwise it should return false.
     * If there are more than 1 items in the list that have value x,
     * the method should remove the first instance of x from the list.
     */
    public boolean remove(T x) {
        Node<T> prev = new Node<>(null, head);
        Node<T> current = head;
        if (!contains(x)) return false;
        while (current != null && !x.equals(current.data())) {
            prev = current;
            current = current.next();
        }
        if (current == head) {
            head = head.next();
        }
        prev.setNext(current.next());
        size--;
        return true;
    }

    /**
     * Iterator support. This method makes it possible to write
     * a for-loop over a list, e.g.:
     * <pre>*
     * {@code LList<String> lst = ... ;}
     * {@code for (String s : lst) {}
     *   ... use s here ...
     * }
     * }
     */
    @Override
    public Iterator<T> iterator() {
        assert classInv();
        return new Iterator<T>() {
            private Node<T> current = head;

            public T next() throws NoSuchElementException {
                if (current != null) {
                    T result = current.data();
                    current = current.next();
                    return result;
                } else {
                    throw new NoSuchElementException();
                }
            }

            public boolean hasNext() {
                return (current != null);
            }
        };
    }
}

package a3;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SLinkedListTest {
    @Test
    void emptyList() {
        LList<Integer> lst0 = new SLinkedList<>();
        assertEquals(lst0.size(), 0);
    }

    @Test
    void append12() {
        LList<Integer> l1 = new SLinkedList<>();
        l1.append(42);
        assertEquals(1, l1.size());
        assertEquals(42, l1.head());
        assertEquals(42, l1.tail());
        l1.append(21);
        assertEquals(2, l1.size());
        assertEquals(42, l1.head());
        assertEquals(21, l1.tail());
        l1.append(45);
        assertEquals(3, l1.size());
        assertEquals(42, l1.head());
        assertEquals(45, l1.tail());
        assertEquals("[42, 21, 45]", l1.toString());

        LList<String> l2 = new SLinkedList<String>();
        l2.append("");
        assertEquals(1, l2.size());
        assertEquals("", l2.head());
        assertEquals("", l2.tail());
        assertEquals("[]", l2.toString());
        l2.append("hello");
        l2.append("");
        l2.append("world");
        assertEquals(4, l2.size());
        assertEquals("", l2.head());
        assertEquals("world", l2.tail());
        assertEquals("[, hello, , world]", l2.toString());
        l2.append("");
        assertEquals("", l2.tail());
        assertEquals("[, hello, , world, ]", l2.toString());
    }

    @Test
    void prepend12() {
        LList<Integer> l1 = new SLinkedList<>();
        l1.prepend(42);
        assertEquals(1, l1.size());
        assertEquals(42, l1.head());
        assertEquals(42, l1.tail());
        l1.prepend(21);
        assertEquals(2, l1.size());
        assertEquals(21, l1.head());
        assertEquals(42, l1.tail());
        assertEquals("[21, 42]", l1.toString());
        l1.prepend(1);
        assertEquals(3, l1.size());
        assertEquals(1, l1.head());
        assertEquals(42, l1.tail());
        assertEquals("[1, 21, 42]", l1.toString());

        LList<String> l2 = new SLinkedList<String>();
        l2.prepend("");
        assertEquals(1, l2.size());
        assertEquals("", l2.head());
        assertEquals("", l2.tail());
        assertEquals("[]", l2.toString());
        l2.prepend("");
        assertEquals(2, l2.size());
        assertEquals("", l2.head());
        assertEquals("", l2.tail());
        assertEquals("[, ]", l2.toString());


    }

    @Test
    void test_get() {
        LList<Integer> lst = new SLinkedList<>();
       assertEquals(null, lst.get(0));

        for (int i = 0; i < 5; i++) lst.append(i);
        assertEquals(5, lst.size());

        for (int i = 0; i < 5; i++) {
            assertEquals(i, lst.get(i));
            lst.append(i);
        }
        System.out.println(lst);
        System.out.println(lst.get(0));

    }

    @Test
    void test_toString() {
        LList<Integer> l1 = new SLinkedList<>();
        l1.append(42);
        l1.prepend(2);
        assertEquals("[2, 42]", l1.toString());
        l1.append(5);
        assertEquals("[2, 42, 5]", l1.toString());
        l1.remove(2);
        assertEquals("[42, 5]", l1.toString());
        // cannot delete an element that does not exist in the list
        l1.remove(50);
        assertEquals("[42, 5]", l1.toString());
        l1.prepend(3);
        assertEquals("[3, 42, 5]", l1.toString());

        l1.remove(3);
        assertEquals("[42, 5]", l1.toString());

    }

    @Test
    void test_insertBefore() {
        LList<Integer> l1 = new SLinkedList<>();
        l1.append(42);
        l1.insertBefore(21,42);
        assertEquals("[21, 42]", l1.toString());
        l1.insertBefore(5, 21);
        assertEquals("[5, 21, 42]", l1.toString());
        l1.prepend(3);
        assertEquals("[3, 5, 21, 42]", l1.toString());
        l1.insertBefore(1,42);
        assertEquals("[3, 5, 21, 1, 42]", l1.toString());

    }

    @Test
    void test_contains(){
        LList<Integer> l1 = new SLinkedList<>();
        assertEquals(false,l1.contains(3));
        l1.append(42);
        l1.prepend(3);
        assertEquals(true, l1.contains(3));
        assertEquals(true, l1.contains(42));
        assertEquals(false, l1.contains(5));
    }

    @Test
    void test_remove(){
        LList<Integer> l1 = new SLinkedList<>();
        assertEquals(false, l1.remove(0));
        // remove tail node test
        l1.append(3);
        l1.prepend(10); // [10, 3]
        assertEquals(true, l1.remove(3));
        assertEquals(1, l1.size());
        assertEquals("[10]", l1.toString());
        assertEquals(true, l1.remove(10));
        assertEquals(false, l1.remove(8));

        // remove head node
        l1.append(3);
        l1.append(5);
        assertEquals("[3, 5]", l1.toString());
        assertEquals(true, l1.remove(3));
        assertEquals("[5]", l1.toString());

        // test middle node
        l1.append(10);
        l1.append(20);
        l1.append(30);
        assertEquals(true, l1.remove(20));
    }
}
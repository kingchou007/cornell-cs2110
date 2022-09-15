package a2;
/**
 * Please provide the following information
 * Name: Kane Li
 * NetID: jl3485
 * Testing Partner Name: Una Wu
 * Testing Partner NetID: yw523
 * Tell us what you thought about the assignment: Spend too much time :)
 */

/**
 * A mutable list of {@code Student} objects.
 */
public class StudentList {
    // Implementation: the StudentList is implemented
    // as a resizable array data structure. It should contain
    // an array that has a large enough capacity to hold all the elements,
    // plus possibly extra elements. It should be able to hold
    // a large number of students but not use up a large amount
    // of memory if it holds a small number of students.

    // TODO 10: Add instance variables for the StudentList and write a class invariant
    // You may not use any classes from the java.util package.

    boolean classInv() {
        return size >= 0 && capacity >= 0 && capacity >= size;

    }

    /**
     * How long you spent on this assignment
     */
    public static double Spent = 10;

    private Student[] list;
    private int capacity;
    private int size = 0;

    /**
     * Constructor: A new empty {@code StudentList}.
     */
    public StudentList() {
        // TODO 11
        // The capacity of the StudentList is not the same as the size.
        // The capacity is the length of the backing array.
        // We suggest starting with a capacity of 5.
        // If the backing array runs out of space, double the size of the backing array
        // and copy all elements to the new backing array
        capacity = 5;
        list = new Student[capacity];

    }

    /**
     * The number of elements in this StudentList.
     */
    public int size() {
        // TODO 12
        // Note: Do not confuse size and capacity.
        int size = 0;
        // do not count null
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                size += 1;
            }
        }

        return size;
    }

    /**
     * The element in the list at position i. Positions start from 0.
     * Requires: 0 <= i < size of StudentList
     */
    public Student get(int i) {
        // TODO 13
        return list[i];

    }

    /**
     * Effect: Add Student s to the end of the list.
     */
    public void append(Student s) {
        // TODO 14
        // Make sure that BEFORE adding a Student to the array, you
        // ensure that the capacity of the array is enough to add a
        // Student to it.
        // Note: Make sure you are keeping the class invariant for ALL classes true.
        assert classInv();
        if (size == list.length) {
            Student[] tempList = new Student[list.length * 2];

            for (int i = 0; i < list.length; i++) {
                tempList[i] = list[i];
            }
            tempList[tempList.length / 2] = s;
            list = tempList;

        } else {
            list[size] = s;
        }

        size += 1;

    }

    /**
     * Returns: whether this list contains Student s.
     */
    public boolean contains(Student s) {
        // TODO 15
        assert classInv();

        for (int i = 0; i < list.length; i++) {
            if (list[i] == s) {
                return true;
            }
        }

        return false;
    }

    /**
     * Effect: If Student s is in this StudentList, remove Student s from the array and return true.
     * Otherwise return false. Elements other than s remain in the same relative order.
     */
    public boolean remove(Student s) {
        // TODO 16
        // Note: Make sure you are keeping the class invariant for ALL classes true.
        assert classInv();
        if (contains(s)) {
            Student[] tempList = new Student[list.length - 1];
            int tempIndex = findIndex(s);

            for (int j = 0; j < tempIndex; j++) {
                tempList[j] = list[j];
            }
            for (int l = tempIndex + 1; l < list.length - 1; l++) {
                tempList[l - 1] = list[l];
            }
            list = tempList;
            return true;
        }

        return false;
    }

    // TODO 17 you may want to write some private helper methods
    private int findIndex(Student s) {
        int tempIndex = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == s) {
                tempIndex = i;
            }
        }
        return tempIndex;
    }

    /**
     * The String representation of this StudentList
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(get(i));
        }
        sb.append("]");
        return sb.toString();
    }

}

package a2;

public class Student {
    // TODO 1 Add instance variables and write the class invariant
    // Declare the following fields. These fields will hold information describing each Student.
    // Make the fields private and include comments describing each of them in the form of a class invariant
    // * firstName. First name of this Student. Must be a non-empty String.
    // * lastName. Last name of this Student. Must be a non-empty String.
    // * year. The year this Student is in school. E.g. 1 if Freshman, 2 if Sophomore, etc. Must be > 0
    // * course. The Course this Student is enrolled in. This Student may be enrolled in at most 1 course.
    //  null if this Student is not enrolled in any course.

    private String firstName;
    private String lastName;
    private int year;

    private Course course; //


    boolean classInv() {
        if (firstName.isEmpty() || lastName.isEmpty() || year < 0) {
            return false;
        }
        return true;
    }

    /**
     * Constructor: Create a new Student with first name f, last name l, and year y.
     * This student is not enrolled in any Courses.
     * Requires: f and l have at least one character and y > 0.
     */
    public Student(String f, String l, int y) {
        //TODO 2
        firstName = f;
        lastName = l;
        year = y;
    }

    /**
     * The first name of this Student.
     */
    public String firstName() {
        assert classInv();
        return firstName;
    }

    /**
     * The last name of this Student.
     */
    public String lastName() {
        assert classInv();
        return lastName;
    }

    /**
     * The first and last name of this Student in the format "First Last".
     */
    public String fullName() {
        return firstName + " " + lastName;
    }

    /**
     * The year in school this Student is in.
     */
    public int year() {
        // TODO 6
        assert classInv();
        return year;
    }

    /**
     * The course this student is enrolled in.
     */
    public Course course() {
        // TODO 7
        assert classInv();
        return course; //
    }

    /**
     * Enroll this Student in Course c.
     * Requires: The student is not enrolled in a course already.
     */
    public void joinCourse(Course c) {
        // TODO 8
        assert classInv();
        course = c;

    }

    /**
     * Drop this Student from their Course. Requires: This student is enrolled in a course already.
     */
    public void leaveCourse() {
        // TODO 9
        assert classInv();
        course = null;

    }

    /**
     * Return the full name of this Student
     */
    public String toString() {
        return fullName();
    }
}
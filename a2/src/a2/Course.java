package a2;

public class Course {

    /**
     * List of all students enrolled in this Course.
     */
    private StudentList students;
    /**
     * The hour at which lecture for this Course is held (in 24-hour time). 0 <= hour <= 23
     */
    private int hour;
    /**
     * The minutes at which lecture for this Course is held. 0 <= min <= 59 The lectures for this
     * course are at hour:min
     */
    private int min;
    /**
     * The location of lectures at this course (e.g. Statler Hall Room 185) Must be non-empty
     */
    private String location;
    /**
     * The last name of the professor of this course (e.g. Myers, Muhlberger, Gries) Must be
     * non-empty
     */
    private String prof;
    /**
     * The name of this course (e.g. Object-Oriented Programming and Data Structures) Must be
     * non-empty
     */
    private String name;

    private boolean classInv() {
        if (hour < 0 || hour > 24 || min > 59 || min <= 0) {
            return false;
        }

        if (prof.isEmpty() || location.isEmpty()) {
            return false;
        }

        return true;

    }


    /**
     * Constructor: Create new Course with name n, professor last name prof, location loc,<br> and
     * lectures are held at time hour:min. The course has no students. Precondition: n, prof, and
     * loc have at least one character in them, 0 <= hr <= 23, 0 <= min <= 59.
     */
    public Course(int hour, int min, String location, String prof, String name) {
        // TODO 18
        // Note that an empty StudentList is not the same as null
        this.hour = hour;
        this.min = min;
        this.prof = prof;
        this.location = location;
        this.name = name;
        students = new StudentList();
    }

    /**
     * Return the name of this course.
     */
    public String getName() {
        // TODO 19
        return name;
    }

    /**
     * Return the time at which lectures are held for this course in the format hour:min AM/PM using
     * 12-hour time. For example, "11:15 AM", "1:35 PM". Add leading zeros to the minutes if necessary.
     */
    public String getLectureTime() {
        // TODO 20
        assert classInv();

        String time = "";

        if (hour < 12) {
            if (min <= 9) {
                time = hour + ":" + "0" + min + " AM";
            } else {
                time = hour + ":" + min + " AM";
            }
        } else if (hour > 12 && hour <= 23) {
            int h = hour - 12;
            if (min <= 9) {
                time = h + ":" + "0" + min + " PM";
            } else {
                time = h + ":" + min + " PM";
            }
        } else if (hour == 12) {
            time = hour + ":" + min + " PM";
        } else if (hour == 24) {
            time = 00 + ":" + min + " AM";
        }

        return time;
    }

    /**
     * Return the location of lectures in this course.
     */
    public String getLocation() {
        // TODO 21
        return location;
    }

    /**
     * Return the name of the professor in the format "Professor LastName"
     */
    public String getProfessor() {
        // TODO 22
        assert classInv();
        return prof;
    }

    /**
     * Return the String representation of the list of students enrolled in this course
     */
    public String getStudents() {
        //TODO 23
        assert classInv();
        return students.toString();
    }

    /**
     * Enroll a new student s to this course. If Student s is already enrolled in a course, they
     * cannot enroll in this course. Return true if the student was successfully enrolled in the
     * course.
     */
    public boolean enrollStudent(Student s) {
        // TODO 24
        // Remember that the class invariant of all classes must be kept true.
        // In other words, make sure that every field is correctly modified based on its
        // Javadoc comments.
        assert classInv();

        // cannot enroll if Student s is already enrolled in a course
        if (s.course() == null) {
            s.joinCourse(this);
            students.append(s);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Drop Student s from this course. If Student s is not enrolled in this course, they cannot be
     * dropped from this course. Return true if the student was successfully dropped from the
     * course.
     */
    public boolean dropStudent(Student s) {
        // TODO 25
        // Remember that the class invariant of all classes must be kept true.
        // In other words, make sure that every field is correctly modified based on its
        // Javadoc comments.
        assert classInv();

        if (s.course() == this) {
            s.leaveCourse();
            students.remove(s);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Print the Course information in tabular format
     */
    public void print() {
        System.out.printf("%-40s%-12s%-20s%-40s",
                name, getLectureTime(), prof, location);
    }
}
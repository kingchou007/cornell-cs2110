package a2;

/**
 * Test harness for Assignment 2
 */
public class A2Test {
    public static void main(String[] args) {
        testStudent();
        testEmptyList();
        testSize();
        testGet();
        testAppend();
        testContains();
        testRemove();
        testGetName();
        testGetLectureTime();
        testGetLocation();
        testGetProfessor();
        testGetStudents();
        testEnrollStudents();
        testDropStudents();
    }

    public static void testStudent() {
        Student s = new Student("Bill", "Nye", 4);
        System.out.println("s.firstName() = " + s.firstName());
        System.out.println("expected = Bill");
        System.out.println("s.lastName() = " + s.lastName());
        System.out.println("expected = Nye");
        System.out.println("s.course() = " + s.course());
        System.out.println("expected = null");
    }

    public static void testEmptyList() {
        StudentList list = new StudentList();
        Student s = new Student("Bill", "Nye", 4);
        System.out.println("list.size() = " + list.size());
        System.out.println("expected = 0");
        System.out.println("list.contains(s) = " + list.contains(s));
        System.out.println("expected = false");
    }


    public static void testSize() {
        StudentList list = new StudentList();
        Student s = new Student("Kane", "Li", 1);
        Student s1 = new Student("Jim", "Chou", 3);
        Student s2 = new Student("Luke", "Li", 1);
        Student s3 = new Student("Rico", "Wei", 4);
        Student s4 = new Student("a", "a", 4);
        Student s5 = new Student("b", "b", 3);
        list.append(s);
        list.append(s1);
        list.append(s2);
        list.append(s3);
        list.append(s4);
        list.append(s5);
        System.out.println("list.size() = " + list.size());
        System.out.println("expected = 6");

    }

    public static void testGet() {
        StudentList list = new StudentList();
        Student s = new Student("Kane", "Li", 3);
        Student s1 = new Student("Jim", "Chou", 1);
        list.append(s);
        list.append(s1);
        System.out.println("list.get(1) = " + list.get(1));
        System.out.println("expected = Jim Chou");
        System.out.println("list.get(2) = " + list.get(2));
        System.out.println("expected = null");
    }

    public static void testAppend() {
        StudentList list = new StudentList();
        Student s = new Student("Bill", "Nye", 4);
        Student s1 = new Student("Kane", "Li", 3);
        Student s2 = new Student("Jim", "Chou", 1);
        Student s3 = new Student("Rico", "Wei", 4);
        Student s4 = new Student("Maka", "Baka", 1);
        Student s5 = new Student("Cookie", "Monster", 2);
        list.append(s);
        System.out.println("list.size() = " + list.size());
        System.out.println("expected = 1");
        System.out.println("list.toString() = " + list.toString());
        System.out.println("expected = [Bill Nye]");
        list.append(s1);
        list.append(s2);
        list.append(s3);
        list.append(s4);
        list.append(s5);
        System.out.println("list.size() = " + list.size());
        System.out.println("expected = 6");
        System.out.println("list.toString() = " + list.toString());
        System.out.println("expected = [Bill Nye, Kane Li, Jim Chou, Rico Wei, Maka Baka, Cookie Monster]");
    }

    public static void testContains() {
        StudentList list = new StudentList();
        Student s = new Student("Kane", "Li", 3);
        Student s1 = new Student("Jim", "Chou", 1);
        Student s3 = new Student("Rico", "Wei", 4);
        list.append(s);
        list.append(s1);
        System.out.println("list.contains(s) = " + list.contains(s));
        System.out.println("expected = true");
        System.out.println("list.contains(s3) = " + list.contains(s3));
        System.out.println("expected = false");
    }

    /**
     * failed test
     */
    public static void testRemove() {
        StudentList list = new StudentList();
        Student s = new Student("Kane", "Li", 3);
        Student s1 = new Student("Jim", "Chou", 1);
        Student s2 = new Student("Mia", "Zhao", 2);
        Student s3 = new Student("Rico", "Wei", 4);
        list.append(s);
        list.append(s1);
        list.append(s3);
        System.out.println("list.remove(s1) = " + list.remove(s1));
        System.out.println("expected = true");
        System.out.println("list.remove(s2) = " + list.remove(s2));
        System.out.println("expected = false");
        System.out.println("list.size = " + list.size());
        System.out.println("expected = 2");
        System.out.println("list.contains(s1) = " + list.contains(s1));
        System.out.println("expected = false");
        System.out.println("list.toString() = " + list.toString());
        System.out.println("expected = [Kane Li, Rico Wei]");

    }

    public static void testGetName() {
        Course c = new Course(15, 21, "Gates Hall", "Robert",
                "Object-Oriented Programming and Data Structures");
        System.out.println("c.getName = " + c.getName());
        System.out.println("expected = Object-Oriented Programming and Data Structures");
    }

    public static void testGetLectureTime() {
        Course c = new Course(15, 21, "Gates Hall", "Robert",
                "Object-Oriented Programming and Data Structures");
        Course c1 = new Course(9, 03, "Road Hall", "Maha Harry", "Foundation of Robotics");
        Course c2 = new Course(12, 12, "Road Hall", "Maha Harry", "Foundation of Robotics");
        Course c3 = new Course(24, 30, "Road Hall", "Maha Harry", "Foundation of Robotics");
        System.out.println("c.getLectureTime = " + c.getLectureTime());
        System.out.println("expected = 3:21 PM");
        System.out.println("c1.getLectureTime = " + c1.getLectureTime());
        System.out.println("expected = 9:03 AM");
        System.out.println("c2.getLectureTime = " + c2.getLectureTime());
        System.out.println("expected = 12:12 PM");
        System.out.println("c3.getLectureTime = " + c3.getLectureTime());
        System.out.println("expected = 00:30 AM");


    }

    public static void testGetLocation() {
        Course c = new Course(15, 21, "Gates Hall", "Robert",
                "Object-Oriented Programming and Data Structures");

        System.out.println("c.getLocation = " + c.getLocation());
        System.out.println("expected = Gates Hall");
    }

    public static void testGetProfessor() {
        Course c = new Course(15, 21, "Gates Hall", "Robert",
                "Object-Oriented Programming and Data Structures");

        System.out.println("c.getProfessor = " + c.getProfessor());
        System.out.println("expected = Professor Robert");

    }

    public static void testGetStudents() {
        Student s = new Student("Kane", "Li", 3);
        Student s1 = new Student("Bill", "Nye", 4);

        Course c1 = new Course(9, 30, "Road Hall", "Maha Harry", "Foundation of Robotics");

        System.out.println("c1.getStudents() = " + c1.getStudents());
        System.out.println("expected = []");
        c1.enrollStudent(s);
        c1.enrollStudent(s1);
        System.out.println("c1.getStudents() = " + c1.getStudents());
        System.out.println("expected = " + "[Kane Li, Bill Nye]");

    }

    public static void testEnrollStudents() {
        Student s = new Student("Kane", "Li", 3);

        Course c1 = new Course(9, 30, "Road Hall", "Maha Harry", "Foundation of Robotics");
        Course c2 = new Course(21, 30, "Statler", "White", "CS 1110");

        System.out.println("c1.enrollStudent(s) = " + c1.enrollStudent(s));
        System.out.println("expected = true");
        System.out.println("c2.enrollStudent(s) = " + c2.enrollStudent(s));
        System.out.println("expected = false");


    }

    public static void testDropStudents() {
        Student s = new Student("Kane", "Li", 3);
        Student s1 = new Student("Bill", "Nye", 4);
        Course c1 = new Course(9, 30, "Road Hall", "Maha Harry", "Foundation of Robotics");
        Course c2 = new Course(21, 30, "Statler", "White", "CS 1110");

        c1.enrollStudent(s);
        c1.enrollStudent(s1);

        System.out.println("c1.dropStudent(s1) = " + c1.dropStudent(s1));
        System.out.println("expected = true");
        System.out.println("c1.getStudents() = " + c1.getStudents());
        System.out.println("expected = [Kane Li]");

        System.out.println("c2.dropStudent(s) = " + c2.dropStudent(s));
        System.out.println("expected = false");
    }


}

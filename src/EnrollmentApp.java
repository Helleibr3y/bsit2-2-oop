import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EnrollmentApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Course>  courses  = new ArrayList<>();
        HashMap<String, ArrayList<String>> enrollments = new HashMap<>();
        String[] validPrograms = {"BSIT", "BSCS"};

        int choice = -1;
        while (choice !=0) {
            printMenu();
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("\n---REGISTER STUDENT---");
                    System.out.print("Student ID: ");

                    String id = sc.nextLine();

                    System.out.print("Full Name: ");
                    String name = sc.nextLine();

                    System.out.print("Program: ");
                    String program = sc.nextLine().toUpperCase();

                    boolean valid = false;

                    for (String p : validPrograms) {
                        if (p.equals(program)) {
                            valid = true;
                            break;
                        }
                    }

                    if (!valid) {
                        System.out.println("Invalid Program!");
                        break;
                    }

                    System.out.print("Year Level: ");
                    int year = Integer.parseInt(sc.nextLine());

                    if (year < 1 || year > 4) {
                        System.out.println("Invalid Year Level!");
                        break;
                    }

                    students.add(new Student(id, name, program, year));

                    System.out.println("[OK] Student Registered!");

                    break;

                case 2:
                    System.out.println("\n--- ADD COURSE ---");
                    System.out.print("Course Code: ");
                    String code = sc.nextLine();

                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Units: ");
                    int units = Integer.parseInt(sc.nextLine());

                    System.out.print("Capacity: ");
                    int capacity = Integer.parseInt(sc.nextLine());

                    courses.add(new Course(code, title, units, capacity));

                    System.out.println("[OK] Course Added!");

                    break;

                case 3:
                    System.out.println("\n--- ENROLL STUDENT ---");

                    System.out.print("Student ID: ");
                    String studentId = sc.nextLine();

                    Student student = findStudent(students, studentId);

                    if (student == null) {
                        System.out.println("Student not found!");
                        break;
                    }

                    System.out.print("Course Code: ");
                    String courseCode = sc.nextLine();

                    Course course = findCourse(courses, courseCode);

                    if (course == null) {
                        System.out.println("Course not found!");
                        break;
                    }

                    if (course.isFull()) {
                        System.out.println("Course is Full!");
                        break;
                    }

                    enrollments.putIfAbsent(studentId, new ArrayList<>());

                    if (enrollments.get(studentId).contains(courseCode)) {
                        System.out.println("Student already enrolled!");
                        break;
                    }

                    enrollments.get(studentId).add(courseCode);

                    course.addOneEnrollee();

                    System.out.println("[OK] " + student.getFullName() + " enrolled successfully.");

                    break;

                case 4:

                    System.out.println("\n--- ALL STUDENTS ---");

                    if (students.isEmpty()) {
                        System.out.println("No students yet.");
                    } else {

                        for (Student s : students) {
                            System.out.println(s.describe());
                        }

                    }

                    break;

                case 5:

                    System.out.println("\n--- ALL COURSES ---");

                    if (courses.isEmpty()) {
                        System.out.println("No courses yet.");
                    } else {

                        for (Course c : courses) {

                            System.out.println(
                                    c.getCourseCode()
                                            + " | "
                                            + c.getTitle()
                                            + " | "
                                            + c.getUnits()
                                            + " units | "
                                            + c.getEnrolledCount()
                                            + "/"
                                            + c.getCapacity());

                        }

                    }

                    break;

                case 6:

                    System.out.println("\n--- STUDENT LOAD ---");

                    System.out.print("Student ID: ");

                    String sid = sc.nextLine();

                    Student stu = findStudent(students, sid);

                    if (stu == null) {
                        System.out.println("Student not found!");
                        break;
                    }

                    ArrayList<String> list = enrollments.get(sid);

                    if (list == null || list.isEmpty()) {
                        System.out.println("No enrolled courses.");
                        break;
                    }

                    int totalUnits = 0;

                    System.out.println("\nStudent: " + stu.getFullName());

                    for (String cc : list) {

                        Course c = findCourse(courses, cc);

                        if (c != null) {

                            System.out.println(c.getCourseCode()
                                    + " - "
                                    + c.getTitle()
                                    + " ("
                                    + c.getUnits()
                                    + " units)");

                            totalUnits += c.getUnits();

                        }

                    }

                    System.out.println("--------");

                    System.out.println("Total Units: " + totalUnits);

                    break;

                case 0:

                    System.out.println("Thank you for using the Liceo Enrollment System!");

                    break;

                default:

                    System.out.println("Invalid Choice.");

            }

        }

    }

    static void printMenu() {

        System.out.println("\n=========");
        System.out.println("LICEO ENROLLMENT SYSTEM");
        System.out.println("===========");
        System.out.println("[1] Register Student");
        System.out.println("[2] Add Course Offering");
        System.out.println("[3] Enroll Student to Course");
        System.out.println("[4] View All Students");
        System.out.println("[5] View All Courses");
        System.out.println("[6] View Student Load (Courses + Total Units");
        System.out.println("[0] Exit");
        System.out.print("Enter Choice: ");

    }

    static Student findStudent(ArrayList<Student> students, String id) {

        for (Student s : students) {

            if (s.getStudentId().equals(id)) {
                return s;
            }

        }

        return null;

    }

    static Course findCourse(ArrayList<Course> courses, String code) {

        for (Course c : courses) {

            if (c.getCourseCode().equals(code)) {
                return c;
            }
        }

        return null;

    }
}
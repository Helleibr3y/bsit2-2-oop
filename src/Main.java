import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final int MAX = 10;

        int[] studentId = new int [MAX];
        String[] fullName = new String[MAX];
        int[] age = new int [MAX];
        String[] course = new String[MAX];
        double[] grade = new double[MAX];
        boolean[] enrolledStatus = new boolean[MAX];

        int count = 0;
        int choice;

        do {
            System.out.println("\n===Student Information System===");
            System.out.println("[1] Add Student");
            System.out.println("[2] View All Students");
            System.out.println("[3] Search Student by ID");
            System.out.println("[4] View Statistics");
            System.out.println("[5] Exit");
            choice = input.nextInt();

            switch (choice) {

                case 1:
                    if (count == MAX) {
                        System.out.println("Student list is already full");
                        break;
                    }
                    System.out.print("Enter Student ID:");
                    studentId[count] = input.nextInt();

                    input.nextLine();

                    System.out.print("Enter Full Name:");

                    fullName[count] = input.nextLine();

                    System.out.print("Enter Age:");
                    age[count] = input.nextInt();

                    if (age[count] <= 0) {
                        System.out.println("Invalid Age");
                        break;
                    }

                    input.nextLine();

                    System.out.print("Enter Course:");
                    course[count] = input.nextLine();

                    System.out.print("Enter Grade:");
                    grade[count] = input.nextDouble();

                    if (grade[count] < 0 || grade[count] > 100) {
                        System.out.println("Invalid grade!");
                        break;
                    }

                    System.out.print("Is Enrolled (true/false):");
                    enrolledStatus[count] = input.nextBoolean();

                    count++;

                    System.out.println("Student added successfully!");
                    break;

                case 2:

                    if (count == 0) {
                        System.out.println("No students found.");
                    } else {

                        System.out.println("\n--- STUDENT RECORDS ---");

                        System.out.printf("%-5s %-20s %-5s %-10s %-8s %-15s\n",
                                "ID", "NAME", "AGE", "COURSE", "GRADE", "STANDING");

                        for (int i = 0; i < count; i++) {

                            String standing;

                            if (grade[i] >= 90)
                                standing = "Dean's Lister";
                            else if (grade[i] >= 75)
                                standing = "Passed";
                            else
                                standing = "Failed";

                            System.out.printf("%-5d %-20s %-5d %-10s %-8.2f %-15s\n",
                                    studentId[i], fullName[i], age[i], course[i], grade[i], standing);
                        }
                    }
                    break;

                case 3:

                    System.out.print("Enter Student ID to search: ");
                    int search = input.nextInt();

                    boolean found = false;

                    for (int i = 0; i < count; i++) {

                        if (studentId[i] == search) {

                            System.out.println("\nStudent Found!");
                            System.out.println("ID: " + studentId[i]);
                            System.out.println("Name: " + fullName[i]);
                            System.out.println("Age: " + age[i]);
                            System.out.println("Course: " + course[i]);
                            System.out.println("Grade: " + grade[i]);
                            System.out.println("Enrolled: " + enrolledStatus[i]);

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found.");
                    }

                    break;

                case 4:

                    if (count == 0) {
                        System.out.println("No students available.");
                    } else {

                        double total = 0;
                        double highest = grade[0];
                        int topIndex = 0;

                        for (int i = 0; i < count; i++) {

                            total += grade[i];

                            if (grade[i] > highest) {
                                highest = grade[i];
                                topIndex = i;
                            }
                        }

                        System.out.println("\n--- STATISTICS ---");
                        System.out.println("Total Students: " + count);
                        System.out.printf("Average Grade: %.2f\n", total / count);
                        System.out.println("Top Student: " + fullName[topIndex] +
                                " (" + grade[topIndex] + ")");
                    }

                    break;

                case 5:
                    System.out.println("Thank you for using the Student Information System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice !=5);

        input.close();
    }
}
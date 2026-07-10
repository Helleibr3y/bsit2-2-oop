//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Library library = new Library();

        int choice;

        do {

            System.out.println("\n===== LIBRARY INFORMATION SYSTEM =====");
            System.out.println("1. Add book");
            System.out.println("2. List all books");
            System.out.println("3. Borrow book");
            System.out.println("4. Return book");
            System.out.println("5. Search book");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter title: ");
                    String title = input.nextLine();

                    System.out.print("Enter author: ");
                    String author = input.nextLine();

                    Book book = new Book(title, author);
                    library.addBook(book);

                    break;

                case 2:

                    library.listBooks();

                    break;

                case 3:

                    System.out.print("Enter title to borrow: ");
                    title = input.nextLine();

                    library.borrowBook(title);

                    break;

                case 4:

                    System.out.print("Enter title to return: ");
                    title = input.nextLine();

                    library.returnBook(title);

                    break;

                case 5:

                    System.out.print("Enter title to search: ");
                    title = input.nextLine();

                    library.searchBook(title);

                    break;

                case 0:

                    System.out.println(">> Thank you for using the Library System. Goodbye!");
                    break;

                default:

                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        input.close();
    }
}
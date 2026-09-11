// UserManager.java
// Stores the users. Notice it only ever mentions User - never Admin,
// Teacher or Student. That is the point: it depends on the abstraction.
import java.util.ArrayList;

public class UserManager {

    private ArrayList<User> users = new ArrayList<>();

    // Already written for you - study how it works.
    public void add(User user) {
        if (user == null) {                     // safety check
            System.out.println("Cannot add a null user.");
            return;
        }
        users.add(user);
        System.out.println("Added: " + user.getName() + " (" + user.role() + ")");
    }

    // Already written for you.
    public void listAll() {
        if (users.isEmpty()) {
            System.out.println("No users yet.");
            return;
        }
        String header =
                "ID   NAME         EMAIL                    ROLE     PERMISSIONS";
        System.out.println(header);
        System.out.println("-".repeat(69));
        for (User u : users) {
            u.display(); // one loop, three different classes
        }
        System.out.println("Total users: " + users.size());
    }

    // TODO 10 (done): loop through users; return the one whose getId()
    // matches, or null if nobody matches. UserManager never needs to
    // know or care whether the matching object is an Admin, Teacher,
    // or Student — it only ever sees "User".
    public User findById(int id) {
        for (User u : users) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null; // no match found
    }

    // TODO 11 (done): reuse findById so we don't duplicate the search
    // logic. If nothing is found, return false. Otherwise remove the
    // found user from the list and return true.
    public boolean deleteById(int id) {
        User found = findById(id);
        if (found == null) {
            return false;
        }
        users.remove(found);
        return true;
    }

    // TODO 12 (done): guard against an empty list first, then print the
    // header, loop and call printExport() (the default method from
    // Exportable) on every user, then print the footer. Because each
    // subclass provides its own toCsv(), the SAME printExport() call
    // produces different-length CSV lines for Admin vs Teacher/Student.
    public void exportAll() {
        if (users.isEmpty()) {
            System.out.println("Nothing to export.");
            return;
        }
        System.out.println("--- CSV EXPORT ---");
        for (User u : users) {
            u.printExport();
        }
        System.out.println("--- END OF EXPORT ---");
    }

    public int count() { return users.size(); }
}
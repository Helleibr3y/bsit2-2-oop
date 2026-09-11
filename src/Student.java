
public class Student extends User {

    private String course;

    public Student(int id, String name, String email, String course) {
        super(id, name, email); // must be the first line
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public String role() {
        return "STUDENT";
    }

    @Override
    public String permissions() {
        return "read only";
    }

    @Override
    public String toCsv() {
        // Reuses User's toCsv() (id,name,email,role) and tacks on course.
        return super.toCsv() + "," + course;
    }
}
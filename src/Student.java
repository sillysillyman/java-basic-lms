import java.util.ArrayList;

public class Student {

    private final int id;
    private String name;
    private ArrayList<Subject> subjectList;
    private Report report;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.subjectList = new ArrayList<>();
        this.report = new Report(id);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Subject> getSubjectList() {
        return subjectList;
    }
}
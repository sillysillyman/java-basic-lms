import java.util.ArrayList;

public class Student {

    private final int id;
    private final String name;
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

    public Report getReport() {
        return report;
    }

    public void initSubjectList(ArrayList<Subject> subjects) {
        subjectList.addAll(subjects);
        initReport();
    }

    private void initReport() {
        for (Subject subject : subjectList) {
            report.table.put(subject, null);
        }
    }

    public void printSubjectList() {
        System.out.print("+");
        System.out.print("-".repeat(2));
        System.out.print("+");
        System.out.print("-".repeat(20));
        System.out.print("+");
        System.out.print("-".repeat(15));
        System.out.println("+");
        System.out.printf("|%2s|", "ID");
        System.out.printf("%20s|", "Subject");
        System.out.printf("%15s|\n", "Type");
        System.out.print("+");
        System.out.print("=".repeat(2));
        System.out.print("+");
        System.out.print("=".repeat(20));
        System.out.print("+");
        System.out.print("=".repeat(15));
        System.out.println("+");
        for (var subject : subjectList) {
            System.out.printf("|%2d|", subject.getId());
            System.out.printf("%20s|", subject.name());
            System.out.printf("%15s|\n", subject.isRequired() ? "required"
                : "selective");
            System.out.print("+");
            System.out.print("-".repeat(2));
            System.out.print("+");
            System.out.print("-".repeat(20));
            System.out.print("+");
            System.out.print("-".repeat(15));
            System.out.println("+");
        }
    }
}
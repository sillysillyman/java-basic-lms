import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Student {

    private final int id;
    private final String name;
    private ArrayList<Subject> subjectList;
    private Map<Subject, Score> report;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.subjectList = new ArrayList<>();
        this.report = new HashMap<>();
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

    public Map<Subject, Score> getReport() {
        return report;
    }

    public void initSubjectList(ArrayList<Subject> subjects) {
        subjectList.addAll(subjects);
        initReport();
    }

    private void initReport() {
        for (Subject subject : subjectList) {
            report.put(subject, null);
        }
    }

    public boolean addSubjectScore(Subject subject, int scoreInt) {
        if (scoreInt < 0 || 100 < scoreInt) {
            System.out.print("The score must be between 0 and 100. ");
            return false;
        }
        if (report.get(subject) == null) {
            subjectList.add(subject);
            report.put(subject, new Score(subject, new ArrayList<>()));
        }
        Score score = report.get(subject);
        if (score.getScores().size() >= 10) {
            System.out.print("The student has already taken the subject 10 times. ");
            return false;
        }
        report.get(subject).addScoreOfASubject(subject, scoreInt);
        return true;
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
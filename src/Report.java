import java.util.HashMap;
import java.util.Map;

public class Report {

    Map<Subject, Score> table;
    private int studentId;

    public Report(int studentId) {
        this.studentId = studentId;
        this.table = new HashMap<>();
    }

    public int getStudentId() {
        return studentId;
    }

    public Map<Subject, Score> getTable() {
        return table;
    }

    public boolean addSubjectScore(Subject subject, Integer num) {
        if (num < 0 || 100 < num) {
            System.out.println("Invalid score: the score must be between 0 and 100.");
            return false;
        }
        Score score = table.get(subject);
        if (score.getScores().size() >= 10) {
            System.out.println("The student has already taken the course 10 times.");
            return false;
        }
        // TO BE IMPLEMENTED
        return true;
    }
}

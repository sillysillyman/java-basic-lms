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

    public boolean addSubjectScore(Subject subject, int scoreInt) {
        if (scoreInt < 0 || 100 < scoreInt) {
            System.out.print("The score must be between 0 and 100. ");
            return false;
        }
        Score score = table.get(subject);
        if (score.getScores().size() >= 10) {
            System.out.print("The student has already taken the subject 10 times. ");
            return false;
        }
        table.get(subject).addScoreOfASubject(subject, scoreInt);
        return true;
    }
}

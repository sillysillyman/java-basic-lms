import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Map.Entry;

public class Score {

    private final int subjectId;
    private final int studentId;
    private ArrayList<Entry<Integer, String>> scores;

    public Score(Subject subject, int studentId, ArrayList<Entry<Integer, String>> scores) {
        this.subjectId = subject.getId();
        this.studentId = studentId;
        this.scores = scores;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public int getStudentId() {
        return studentId;
    }

    public ArrayList<Entry<Integer, String>> getScores() {
        return scores;
    }

    public void addScoreOfASubject(Subject subject, int scoreInt) {
        scores.add(new SimpleEntry<Integer, String>(scoreInt, getGradeByScore(subject, scoreInt)));
    }

    public String getGradeByScore(Subject subject, int scoreInt) {
        if (subject.isRequired()) {
            if (95 <= scoreInt) {
                return "A";
            } else if (90 <= scoreInt) {
                return "B";
            } else if (80 <= scoreInt) {
                return "C";
            } else if (70 <= scoreInt) {
                return "D";
            } else if (60 <= scoreInt) {
                return "F";
            } else {
                return "N";
            }
        } else {
            if (90 <= scoreInt) {
                return "A";
            } else if (80 <= scoreInt) {
                return "B";
            } else if (70 <= scoreInt) {
                return "C";
            } else if (60 <= scoreInt) {
                return "D";
            } else if (50 <= scoreInt) {
                return "F";
            } else {
                return "N";
            }
        }
    }

    public boolean addScore(int scoreInt) {
        // TO BE IMPLEMENTED
        return true;
    }
}


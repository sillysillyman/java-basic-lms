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

    public boolean addScore(Integer num) {
        // TO BE IMPLEMENTED
        return true;
    }
}


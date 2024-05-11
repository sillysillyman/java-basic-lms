import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Map.Entry;

public class Score {

    private final Subject subject;
    private ArrayList<Entry<Integer, String>> scores;

    public Score(Subject subject, ArrayList<Entry<Integer, String>> scores) {
        this.subject = subject;
        this.scores = scores;
    }

    public Subject getSubject() {
        return subject;
    }

    public ArrayList<Entry<Integer, String>> getScores() {
        return scores;
    }

    public void addScoreOfASubject(Subject subject, int scoreInt) {
        scores.add(new SimpleEntry<Integer, String>(scoreInt, getGradeByScore(subject, scoreInt)));
    }

    public void printScores() {
        int i = 1;
        System.out.print("+");
        System.out.print("-".repeat(3));
        System.out.print("+");
        System.out.print("-".repeat(8));
        System.out.print("+");
        System.out.print("-".repeat(8));
        System.out.println("+");
        System.out.printf("|%3s|", "");
        System.out.printf("%8s|", "Score");
        System.out.printf("%8s|\n", "Grade");
        System.out.print("+");
        System.out.print("=".repeat(3));
        System.out.print("+");
        System.out.print("=".repeat(8));
        System.out.print("+");
        System.out.print("=".repeat(8));
        System.out.println("+");
        for (var score : scores) {
            System.out.printf("|%3d|", i++);
            System.out.printf("%8d|", score.getKey());
            System.out.printf("%8s|\n", score.getValue());
            System.out.print("+");
            System.out.print("-".repeat(3));
            System.out.print("+");
            System.out.print("-".repeat(8));
            System.out.print("+");
            System.out.print("-".repeat(8));
            System.out.println("+");
        }
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


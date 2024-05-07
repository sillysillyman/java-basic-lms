import java.util.ArrayList;

public enum Subject {
    JAVA(1, true),
    OOP(2, true),
    SPRING(3, true),
    JPA(4, true),
    MYSQL(5, true),
    DEGINE_PATTERN(6, false),
    SPRING_SECURITY(7, false),
    REDIS(8, false),
    MONGODB(9, false);

    private final int id;
    private final boolean isRequired;

    Subject(int id, boolean isRequired) {
        this.id = id;
        this.isRequired = isRequired;
    }

    public static void printAllSubjects() {
        for (var subject : Subject.values()) {
            System.out.println(
                subject.getId() + ". " + subject.name() + "(" + (subject.isRequired() ? "required"
                    : "selective") + ")");
        }
    }

    public static Subject findById(int id) {
        for (Subject subject : Subject.values()) {
            if (subject.getId() == id) {
                return subject;
            }
        }
        return null;
    }

    public static boolean isValidSubjects(ArrayList<Subject> subjects) {
        int isRequiredCnt = 0;
        int isSelectiveCnt = 0;
        for (Subject subject : subjects) {
            if (subject.isRequired()) {
                ++isRequiredCnt;
            } else {
                ++isSelectiveCnt;
            }
        }
        return isRequiredCnt >= 3 && isSelectiveCnt >= 2;
    }

    public int getId() {
        return id;
    }

    public boolean isRequired() {
        return isRequired;
    }
}

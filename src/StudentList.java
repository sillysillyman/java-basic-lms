import java.util.HashMap;
import java.util.Map;

public class StudentList {

    private static Map<Integer, Student> list;

    public StudentList(Map<Integer, Student> list) {
        this.list = list;
    }

    public static Map<Integer, Student> getList() {
        return list;
    }
}


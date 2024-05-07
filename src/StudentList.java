import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class StudentList {

    private static Map<Integer, Student> list;

    public StudentList(Map<Integer, Student> list) {
        this.list = list;
    }

    public static Map<Integer, Student> getList() {
        return list;
    }

    public ArrayList<Entry<Integer, Student>> getDuplicateStudentNameList(String name) {
        ArrayList<Entry<Integer, Student>> duplicateStudentNameList = new ArrayList<>();
        for (var entry : list.entrySet()) {
            if (entry.getValue().getName().equals(name)) {
                duplicateStudentNameList.add(entry);
            }
        }
        return duplicateStudentNameList;
    }
}


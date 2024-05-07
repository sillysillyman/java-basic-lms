import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class StudentList {

    private static Map<Integer, Student> list;

    public StudentList(Map<Integer, Student> list) {
        this.list = list;
    }

    public Map<Integer, Student> getList() {
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

    public Student getStudentByName(Scanner sc) {
        Student student;
        while (true) {
            System.out.print("Enter the student name: ");
            String name = sc.next();
            ArrayList<Entry<Integer, Student>> duplicateStudentNameList = getDuplicateStudentNameList(
                name);
            if (duplicateStudentNameList.isEmpty()) {
                System.out.println(
                    "There is no student having such name in the list. Please try again.");
            } else if (duplicateStudentNameList.size() == 1) {
                student = duplicateStudentNameList.get(0).getValue();
                break;
            } else {
                System.out.println("The name you entered is not unique.");
                while (true) {
                    System.out.print("Enter the ID: ");
                    boolean isValidId = false;
                    int studentId = sc.nextInt();
                    sc.nextLine();

                    for (var entry : duplicateStudentNameList) {
                        if (entry.getKey() == studentId) {
                            isValidId = true;
                            break;
                        }
                    }
                    if (isValidId) {
                        student = list.get(studentId);
                        break;
                    }
                    System.out.println("The ID you entered is not valid. Please try again.");
                }
                break;
            }
        }
        return student;
    }

    public int getNewId() {
        int newId = 0;

        while (true) {
            if (!list.containsKey(++newId)) {
                break;
            }
        }
        return newId;
    }

    public void printAllStudents() {
        if (list.isEmpty()) {
            System.out.println("There are no students in the list.");
            return;
        }
        int maxIndexWidth = Integer.toString(list.size()).length();
        var maxIdWidth = Integer.toString(list.keySet().stream().max(Integer::compare).orElse(3))
            .length();
        var maxNameWidth = list.values().stream().map(Student::getName).map(String::length)
            .max(Integer::compare).orElse(20);
        System.out.print("+");
        System.out.print("-".repeat(maxIndexWidth));
        System.out.print("+");
        System.out.print("-".repeat(maxIdWidth + 5));
        System.out.print("+");
        System.out.print("-".repeat(maxNameWidth + 5));
        System.out.println("+");
        System.out.printf("|%" + maxIndexWidth + "s|", "");
        System.out.printf("%" + (maxIdWidth + 5) + "s|", "ID");
        System.out.printf("%" + (maxNameWidth + 5) + "s|\n", "Name");
        System.out.print("+");
        System.out.print("=".repeat(maxIndexWidth));
        System.out.print("+");
        System.out.print("=".repeat(maxIdWidth + 5));
        System.out.print("+");
        System.out.print("=".repeat(maxNameWidth + 5));
        System.out.println("+");

        int i = 1;
        for (var entry : list.entrySet()) {
            System.out.printf("|%" + maxIndexWidth + "d|", i++);
            System.out.printf("%" + (maxIdWidth + 5) + "d|", entry.getKey());
            System.out.printf("%" + (maxNameWidth + 5) + "s|\n", entry.getValue().getName());
            System.out.print("+");
            System.out.print("-".repeat(maxIndexWidth));
            System.out.print("+");
            System.out.print("-".repeat(maxIdWidth + 5));
            System.out.print("+");
            System.out.print("-".repeat(maxNameWidth + 5));
            System.out.println("+");
        }
    }

    public void addStudent(Student student) {
        list.put(student.getId(), student);
    }

    public void setSampleData() {
        Student student1 = new Student(1, "kevin");
        Student student2 = new Student(2, "james");
        Student student3 = new Student(3, "tom");
        Student student4 = new Student(4, "charles");
        Student student5 = new Student(5, "jason");
        Student student6 = new Student(6, "peter");
        Student student7 = new Student(7, "john");
        Student student8 = new Student(8, "mark");

        student1.initSubjectList(new ArrayList<>(
            Arrays.asList(Subject.JAVA, Subject.OOP, Subject.SPRING, Subject.MYSQL,
                Subject.DESIGN_PATTERN)));
        student2.initSubjectList(new ArrayList<>(
            Arrays.asList(Subject.JAVA, Subject.OOP, Subject.JPA, Subject.MYSQL,
                Subject.SPRING_SECURITY)));
        student3.initSubjectList(new ArrayList<>(
            Arrays.asList(Subject.JAVA, Subject.SPRING, Subject.JPA, Subject.DESIGN_PATTERN,
                Subject.REDIS)));
        student4.initSubjectList(new ArrayList<>(
            Arrays.asList(Subject.OOP, Subject.SPRING, Subject.JPA, Subject.SPRING_SECURITY,
                Subject.MONGODB)));
        student5.initSubjectList(new ArrayList<>(
            Arrays.asList(Subject.JAVA, Subject.OOP, Subject.SPRING, Subject.MONGODB,
                Subject.MYSQL)));
        student6.initSubjectList(new ArrayList<>(
            Arrays.asList(Subject.JAVA, Subject.OOP, Subject.JPA, Subject.MYSQL,
                Subject.DESIGN_PATTERN)));
        student7.initSubjectList(new ArrayList<>(
            Arrays.asList(Subject.JAVA, Subject.SPRING, Subject.JPA, Subject.DESIGN_PATTERN,
                Subject.SPRING_SECURITY)));
        student8.initSubjectList(new ArrayList<>(
            Arrays.asList(Subject.OOP, Subject.SPRING, Subject.JPA, Subject.REDIS,
                Subject.MONGODB)));

        list.put(student1.getId(), student1);
        list.put(student2.getId(), student2);
        list.put(student3.getId(), student3);
        list.put(student4.getId(), student4);
        list.put(student5.getId(), student5);
        list.put(student6.getId(), student6);
        list.put(student7.getId(), student7);
        list.put(student8.getId(), student8);

    }
}


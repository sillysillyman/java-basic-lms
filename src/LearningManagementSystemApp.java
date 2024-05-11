import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;


public class LearningManagementSystemApp {

    private static Scanner sc = new Scanner(System.in);
    private static StudentList studentList = new StudentList(new HashMap<>());

    public static void main(String[] args) {
        studentList.setSampleData();
        try {
            displayMainView();
        } catch (Exception e) {
            System.out.println("Error detected!");
            System.out.println("Terminating the program...");
        }
    }

    private static void displayMainView() throws InterruptedException {
        boolean flag = true;

        while (flag) {
            System.out.println("\n==================================================");
            System.out.println("Processing Learning Management System...");
            System.out.println("1. manage students");
            System.out.println("2. manage scores");
            System.out.println("3. terminate program");
            System.out.print("Select an option: ");
            int option = Integer.parseInt(sc.next());

            switch (option) {
                case 1 -> displayStudentView(); // student management
                case 2 -> displayScoreView(); // score management
                case 3 -> flag = false; // program termination
                default -> {
                    System.out.println("Invalid input. Please try again.");
                }
            }
        }
        System.out.println("Terminating the program...");
    }

    private static void displayStudentView() {
        boolean flag = true;

        System.out.println("\n==================================================");
        System.out.println("Processing student management...");
        while (flag) {
            System.out.println("1. register student");
            System.out.println("2. inquire student list");
            System.out.println("3. move to main view back");
            System.out.print("Select an option: ");
            int option = Integer.parseInt(sc.next());

            switch (option) {
                case 1 -> {
                    registerStudent(); // student registration
                    flag = false;
                }
                case 2 -> {
                    inquireStudent(); // making student list inquiry
                    flag = false;
                }
                case 3 -> flag = false; // movement to main view back
                default -> System.out.println("Invalid input. Please try again.");
            }
        }
    }

    private static void registerStudent() {
        System.out.println("Registering a student...");
        System.out.print("Enter the student name: ");
        String name = sc.next();
        sc.nextLine();

        ArrayList<Entry<Integer, Student>> duplicateStudentNameList = studentList.getDuplicateStudentNameList(
            name);
        if (!duplicateStudentNameList.isEmpty()) {
            System.out.println("Maybe you are already registered.");
            for (var duplicateStudent : duplicateStudentNameList) {
                System.out.println(duplicateStudent.getKey() + ". " + duplicateStudent.getValue());
            }
            while (true) {
                System.out.println("Are you sure to register? (y/n)");
                String answer = sc.next();
                sc.nextLine();
                if (answer.equals("y")) {
                    break;
                } else if (answer.equals("n")) {
                    return;
                } else {
                    System.out.println("Invalid input. Please try again.");
                }
            }
        }
        int newId = studentList.getNewId();
        Student student = new Student(newId, name);
        while (true) {
            System.out.println(
                "Select subjects you are willing to take. You must choose at least 3 required subjects and at least 2 selective subjects.");
            Subject.printAllSubjects();
            System.out.println("Enter IDs separated by whitespaces. (e.g. 1 2 3)");

            String[] subjectStringIds = sc.nextLine().split("\\s+");
            int[] subjectIds = new int[subjectStringIds.length];
            for (int i = 0; i < subjectIds.length; i++) {
                subjectIds[i] = Integer.parseInt(subjectStringIds[i]);
            }
            ArrayList<Subject> subjects = new ArrayList<>();
            for (int subjectId : subjectIds) {
                subjects.add(Subject.findById(subjectId));
            }
            if (Subject.isValidSubjects(subjects)) {
                student.initSubjectList(subjects);
                break;
            } else {
                System.out.println(
                    "The number of subjects you chose is not enough. Please try again.");
            }
        }
        studentList.addStudent(student);
        System.out.println("Success to register the student.");
    }

    private static void inquireStudent() {
        System.out.println("Inquiring the student list...");
        studentList.printAllStudents();
        System.out.println("Success to inquire the student list.");
    }

    private static void displayScoreView() {
        boolean flag = true;

        System.out.println("\n==================================================");
        System.out.println("Processing score management...");
        while (flag) {
            System.out.println("1. register a student's exam scores by subject");
            System.out.println("2. update a student's score of a subject");
            System.out.println("3. inquire a student's grades of a subject");
            System.out.println("4. move to the main view back.");
            System.out.print("Select an option: ");
            int input = sc.nextInt();

            switch (input) {
                case 1 -> {
                    registerScore(); // registration of a student score by subject;
                    flag = false;
                }
                case 2 -> {
                    updateScoreBySubject(); // update of a student score
                    flag = false;
                }
                case 3 -> {
                    inquireGradesBySubject(); // inquiry of a student grades
                    flag = false;
                }
                case 4 -> flag = false; // movement to main view back
                default -> System.out.println("Invalid input. Please try again.");
            }
        }
    }

    private static void registerScore() {
        System.out.println("Registering score of a subject...");
        Student student = studentList.getStudentByName(sc);
        while (true) {
            Subject.printAllSubjects();
            System.out.print("Enter a subject name you want to register: ");
            String subjectName = sc.next();
            Subject subject = Subject.valueOf(subjectName);
            System.out.print("Enter the score you got: ");
            int scoreInt = sc.nextInt();
            sc.nextLine();
            if (!student.addSubjectScore(subject, scoreInt)) {
                System.out.println("Please try again.");
            } else {
                break;
            }
        }
        System.out.println("Success to register.");
    }

    private static void updateScoreBySubject() {
        System.out.println("Updating score by a subject...");
        // TO BE IMPLEMENTED
        System.out.println("Success to update.");
    }

    private static void inquireGradesBySubject() {
        System.out.println("Inquiring grades by a subject...");
        Student student = studentList.getStudentByName(sc);
        student.printSubjectList();
        System.out.println("Enter the subject you want to inquire: ");
        String subjectString = sc.next();
        sc.nextLine();
        Subject subject = Subject.valueOf(subjectString);

        Score score = student.getReport().get(subject);
        score.printScores();
        System.out.println("Success to inquire.");
    }

}

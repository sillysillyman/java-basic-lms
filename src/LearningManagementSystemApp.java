import java.util.HashMap;
import java.util.Scanner;


public class LearningManagementSystemApp {

    private static Scanner sc = new Scanner(System.in);
    private static StudentList studentlist = new StudentList(new HashMap<Integer, Student>());

    public static void main(String[] args) {
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
                    Thread.sleep(2000);
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
                    inquireStudent(); // making student list inquiry}
                    flag = false;
                }
                case 3 -> flag = false; // movement to main view back
                default -> {
                    System.out.println("Invalid input. Please try again.");
                }
            }
        }
    }

    private static void registerStudent() {
        System.out.println("Registering a student...");
        System.out.print("Enter the student name: ");
        String studentName = sc.next();

        System.out.println("Success to register the student.");
    }

    private static void inquireStudent() {
        System.out.println("Inquiring the student list...");
        // TO BE IMPLEMENTED
        System.out.println("Success to inquire the student list.");
    }

    private static void displayScoreView() {
        boolean flag = true;

        System.out.println("\n==================================================");
        System.out.println("Processing score management...");
        while (flag) {
            System.out.println("1. register a student's exam scores by subject");
            System.out.println("2. update a student's course score");
            System.out.println("3. inquire a student's grades by course of a subject");
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
                case 4 -> flag = false; // 메인 화면 이동
                default -> {
                    System.out.println("Invalid input. Please try again.");
                }
            }
        }
    }

    private static void registerScore() {
        System.out.println("Registering score of a subject...");
        // TO BE IMPLEMENTED
        System.out.println("Success to register");
    }

    private static void updateScoreBySubject() {
        System.out.println("Updating score by a subject.");
        // TO BE IMPLEMENTED
        System.out.println("Success to update.");
    }

    private static void inquireGradesBySubject() {
        System.out.println("Inquiring grades by a subject.");
        // TO BE IMPLEMENTED
        System.out.println("Success to inquire.");
    }

}

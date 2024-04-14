import java.sql.Connection;
import java.util.InputMismatchException;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MemberSubmenu {

    public static void MyTrainingSessionOptions() {
        Scanner scanner = new Scanner(System.in);

        int lowerBound = 0;
        int upperBound = 3;
        int userInput;

        while (true) {
            try {
                System.out.println("------------------My Training Sessions------------------");
                System.out.println("1. View My Sessions");
                System.out.println("2. Create Session");
                System.out.println("3. Drop Session");
                System.out.println("0. Back");

                System.out.println("Enter your choice: ");
                userInput = scanner.nextInt();

                if (userInput >= lowerBound && userInput <= upperBound) {
                    break;
                } else {
                    System.out.println("Please try a valid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please try a valid option.");
                scanner.next();
            }
        }

        switch (userInput) {
            case 0:
                Main.MainMenu();
                break;
            case 1:
                MemberQueries.ListMySessions(Main.currentMember);
                Main.memberMenu();
                break;
            case 2:
                BookPTSession();
                break;
            case 3:

                break;
            default:
                System.out.println("Invalid input. Please try again.");
                break;
        }

        scanner.close();
    }

    public static void GoalPrompt() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a goal you would like to add");

        String userInput = scanner.nextLine();

        MemberQueries.CreateGoal(userInput);

        scanner.close();
    }

    public static void BookPTSession() {
        int methodcurrentMember = Main.currentMember;
        // list trainers
        PTQueries.ListTrainers();

        System.out.println("Select a trainer you'd like to train with and time");
        System.out.println("Format: (Trainer #) (Time)");

        Scanner scanner = new Scanner(System.in);

        // seeds input
        String userInput = scanner.nextLine();

        String[] parts = userInput.split(" ", 2);

        String trainern = parts[0];
        String time = parts[1];

        MemberQueries.createPTSession(trainern, time);
        Main.memberMenu();
        scanner.close();

    }

    public static void dropSession() {
        int methodcurrentMember = Main.currentMember;
        // list trainers
        PTQueries.ListTrainers();

        System.out.println("Select a Training Session number you would like to drop");

        Scanner scanner = new Scanner(System.in);

        MemberQueries.ListMySessions(methodcurrentMember);
        // seeds input
        int userInput = scanner.nextInt();

        MemberQueries.dropPTSession(userInput);

        scanner.close();

    }

    public static void AddExercise() {
        int methodcurrentMember = Main.currentMember;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the exercise");
        String exerciseName = scanner.nextLine();
        System.out.println("Please enter the splitDay");
        String splitDay = scanner.nextLine();
        String query = "INSERT INTO Workouts (MemberID, workoutName, splitDay) VALUES (" + methodcurrentMember + ", '"
                + exerciseName + "', '" + splitDay + "')";
        Main.adminQuery(query);
        Main.memberMenu();

    }
}

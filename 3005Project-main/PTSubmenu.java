import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PTSubmenu {

    public static void TrainerOptions() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("------------------Trainer Options------------------");
        System.out.println("1. View Schedule");
        System.out.println("2. View Members");
        System.out.println("3. My Members");
        System.out.println("0. Back");
        System.out.println("Enter your choice: ");

        int userInput = scanner.nextInt();

        switch (userInput) {
            case 0:
                Main.MainMenu();
                break;
            case 1:
                PTQueries.mySchedule();
                TrainerOptions();
                break;
            case 2:
                PTQueries.listMembers();
                TrainerOptions();
                break;
            case 3:
                PTQueries.myMembers();
                TrainerOptions();
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                break;
        }
        scanner.close();
    }

    public static void viewSchedule() {
        Scanner scanner = new Scanner(System.in);

        int lowerBound = 0;
        int upperBound = 3;
        int userInput;

        while (true) {
            try {
                System.out.println("------------------My Schedule------------------");
                System.out.println("1. Edit Schedule");
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
            case 1:

                break;
            case 0:
                PTQueries.ListTrainers();
                break;
            default:
                System.out.println("Please try a valid options");
                break;
        }

        scanner.close();
    }

    public static void createTrainer() {
        Scanner scanner5 = new Scanner(System.in);
        System.out.println("------------------Create Trainer------------------");
        System.out.println("What is the name of the trainer?");
        String name = scanner5.nextLine();
        System.out.println("What is the age of the trainer?");
        int age = scanner5.nextInt();
        scanner5.close();
        PTQueries.createTrainer(name, age);

    }
}

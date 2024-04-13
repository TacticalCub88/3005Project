import java.util.InputMismatchException;
import java.util.Scanner;

public class PTSubmenu {
    public static void ListTrainers() {
        Scanner scanner = new Scanner(System.in);

        int lowerBound = 0;
        int upperBound = 999;
        int userInput;

        while (true) {
            try {
                System.out.println("------------------Listing Trainers:------------------");
                System.out.println("0. Back");

                System.out.println("Select a Trainer: ");
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
        /////// TO CHANGE
        switch (userInput) {
            case 0:
                Main.MainMenu();
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                break;
        }

        scanner.close();
    }

    public static void TrainerOptions() {
        Scanner scanner = new Scanner(System.in);

        int lowerBound = 0;
        int upperBound = 3;
        int userInput;

        while (true) {
            try {
                System.out.println("------------------Trainer Options------------------");
                System.out.println("1. View Schedule");
                System.out.println("2. View Members");
                System.out.println("3. My Members");
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
                break;
            case 2:
                break;
            case 3:
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

    public static void createTrainer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------Create Trainer------------------");
        System.out.println("What is the name of the trainer?");
        String name = scanner.nextLine();
        System.out.println("What is the age of the trainer?");
        int age = scanner.nextInt();
        PTQueries.createTrainer(name, age);

    }
}

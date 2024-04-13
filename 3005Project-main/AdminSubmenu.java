
import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminSubmenu {
    public static void ListAdmins() {
        Scanner scanner = new Scanner(System.in);

        int lowerBound = 0;
        int upperBound = 999;
        int userInput;

        while (true) {
            try {
                System.out.println("------------------Listing Admins:------------------");
                System.out.println("Select an Admin: ");

                AdminQueries.ListAdmins();
                System.out.println("0. Back");
                System.out.println("999. Create Admin");
                System.out.println("Select an Admin: ");
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

        if (userInput == 0) {
            Main.MainMenu();
        } else if (userInput == 999) {
            CreateAdmin();
            Main.adminMenu();
        } else {
            // will reference this as the id
            AdminOptions(userInput);
        }

        scanner.close();
    }

    public static void AdminOptions(int adminID) {
        Scanner scanner = new Scanner(System.in);

        int lowerBound = 0;
        int upperBound = 3;

        int userInput;

        while (true) {
            try {
                System.out.println("------------------Admin Options:------------------");
                System.out.println("0. Back");
                System.out.println("2. Update Admin");

                System.out.println("Select an option: ");
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
                // RemoveAdmin();
                break;
            case 2:
                UpdateAdmin();
                System.out.println("Admin updated successfully.");
                Main.adminMenu();
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                break;
        }

        scanner.close();
    }

    public static void CreateAdmin() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a username and password");

        String username = scanner.nextLine();
        String password = scanner.nextLine();
        if (username != null && password != null) {
            AdminQueries.AddAdmin(username, password);
        }

        scanner.close();

    }

    public static void UpdateAdmin() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Which username would you like to update? (Name)");
        String username = scanner.nextLine();
        String password = scanner.nextLine();

        if (username != null && password != null) {
            AdminQueries.UpdateAdmin(username, password);
        }

        scanner.close();

    }

    public static void processPayment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the persons id you would like to proecss: ");
        PTQueries.listMembers();
        int person = scanner.nextInt();
        System.out.println("Please enter the amount you would like to process: ");
        double amount = scanner.nextDouble();
        AdminQueries.processPayment(person, amount);
        scanner.close();

    }
}

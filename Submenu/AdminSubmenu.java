import Queries.AdminQueries;

public class AdminSubmenu {
    public static void ListAdmins() {
        Scanner scanner = new Scanner(System.in);

        int lowerBound = 0;
        int upperBound = 999;
        int userInput;

        while (true) {
            try {
                System.out.println("------------------Listing Admins:------------------");
                System.out.println("0. Back");

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
        switch (userInput) {
            case 0:
                MainMenu();
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

    public static void AdminOptions() {
        Scanner scanner = new Scanner(System.in);

        int lowerBound = 0;
        int upperBound = 3;

        int userInput;

        while (true) {
            try {
                System.out.println("------------------Admin Options:------------------");
                System.out.println("0. Back");
                System.out.println("1. Add Admin");
                System.out.println("2. Remove Admin");
                System.out.println("3. Update Admin");

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
                MainMenu();
                break;
            case 1:
                AdminQueries.AddAdmin();
                break;
            case 2:
                AdminQueries.RemoveAdmin();
                break;
            case 3:
                AdminQueries.UpdateAdmin();
                break;
            default:
                System.out.println("Invalid input. Please try again.");
}

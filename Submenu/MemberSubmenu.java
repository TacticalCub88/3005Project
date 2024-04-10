import Queries.MemberQueries;

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
                MainMenu();
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
}

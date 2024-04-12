import java.sql.Connection;
import java.util.InputMismatchException;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Submenu.adminMenu;
import Submenu.MemberSubmenu;
import Submenu.NewUserSubmenu;
import Submenu.PTSubmenu;

public class Main {
    static Connection connection = null;

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/3005Project";
        String user = "postgres";
        String password = "3348";

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("connected");
            } else {
                System.out.println("not connected");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }

        MainMenu();
    }

    public static void MainMenu() {
        Scanner scanner = new Scanner(System.in);

        int lowerBound = 0;
        int upperBound = 5;

        int userInput;

        while (true) {
            try {
                System.out.println("------------------User Type------------------");
                System.out.println("1. Member");
                System.out.println("2. Personal Trainer");
                System.out.println("3. Admin");
                System.out.println("4. New User");
                System.out.println("0. Exit");
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
                System.out.println("Closing Program");
                System.exit(0);
            case 1:
                memberMenu();
                break;
            case 2:
                PTMenu();
                break;
            case 3:
                adminMenu();
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                break;
        }

        scanner.close();
    }

    public static void memberMenu() {
        Scanner scanner = new Scanner(System.in);

        int lowerBound = 0;
        int upperBound = 5;

        int userInput;

        while (true) {
            try {
                System.out.println("------------------Member------------------");
                System.out.println("1. Goals");
                System.out.println("2. Create Goal");
                System.out.println("3. Training Session");
                System.out.println("4. Exercise Plan");
                System.out.println("5. Classes");
                System.out.println("0. Back to User Type Menu");
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
            case 1:
                MemberSubmenu.MyGoals();
                break;
            case 2:
                MemberSubmenu.CreateGoal();
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                break;
        }

        scanner.close();
    }

    public static void PTMenu() {

        Scanner scanner = new Scanner(System.in);

        int lowerBound = 0;
        int upperBound = 2;

        int userInput;

        while (true) {
            try {
                System.out.println("------------------Personal Trainers------------------");
                System.out.println("1. List Trainers");
                System.out.println("2. Create");
                System.out.println("0. Back to User Type Menu");
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
            default:
                System.out.println("Invalid input. Please try again.");
                break;
        }

        scanner.close();
    }

    public static void adminMenu() {
        Scanner scanner = new Scanner(System.in);

        int lowerBound = 0;
        int upperBound = 7;
        int userInput;

        while (true) {
            try {
                System.out.println("------------------Admin Menu------------------");
                System.out.println("1. List Members");
                System.out.println("2. Show Trainers");
                System.out.println("3. Process Payment");
                System.out.println("4. View Rooms");
                System.out.println("5. View Equipment");
                System.out.println("6. View Classes");
                System.out.println("7. Create Class");
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
}
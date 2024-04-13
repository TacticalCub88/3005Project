import java.sql.Connection;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static Connection connection = null;
    public static int currentMember = 0;
    public static int currentTrain = 0;
    public static int currentAdmin = 1;

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

    public static void adminQuery(String SQL) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void runCreate(String SQL, String output) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.executeUpdate();
            System.out.println(output);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void listGoals(String SQL) {
        try {
            PreparedStatement pstmt = connection.prepareStatement(SQL);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString("achievement");
                Date startDate = rs.getDate("dateCreated");
                boolean achieved = rs.getBoolean("achieved");

                System.out.println(
                        "Name: " + name + " Start Date: " + startDate + " Achieved: " + achieved);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public static void ListAdmins(String SQL) {
        try {
            PreparedStatement pstmt = connection.prepareStatement(SQL);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                String name = rs.getString("username");
                int aid = rs.getInt("AID");
                System.out.println(
                        aid + ". Name: " + name);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public static void listTrainers(String SQL) {
        try {
            PreparedStatement pstmt = connection.prepareStatement(SQL);
            ResultSet rs = pstmt.executeQuery();
            System.out.println("------------------ Trainers ------------------");

            while (rs.next()) {
                int id = rs.getInt("PTID");
                String name = rs.getString("PTName");

                System.out.println(
                        "TrainerID: " + id + " | Name: " + name);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public static void listMembers(String SQL) {
        try {
            PreparedStatement pstmt = connection.prepareStatement(SQL);
            ResultSet rs = pstmt.executeQuery();
            System.out.println("------------------MEMBERS------------------");

            while (rs.next()) {
                int id = rs.getInt("MemberID");
                String name = rs.getString("memberName");
                boolean am = rs.getBoolean("ActiveMember");
                String achievements = rs.getString("Achievements");

                System.out.println(
                        id + ". " + name + " | Active member: " + am + " | Achievements: " + achievements);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public static void listEqupiment(String SQL) {
        try {
            PreparedStatement pstmt = connection.prepareStatement(SQL);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("EquipmentID");
                String name = rs.getString("EquipmentName");
                boolean needsMaintenance = rs.getBoolean("needsMaintenance");

                System.out.println(
                        "Equip No." + id + " | Name: " + name + " | Needs Maintenance: " + needsMaintenance);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public static void listSessions(String SQL) {
        try {
            PreparedStatement pstmt = connection.prepareStatement(SQL);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String id = rs.getString("PTSessionID");
                String trainer = rs.getString("PTName");
                String time = rs.getString("sessionTime");

                System.out.println(
                        "Session No.  " + id + " Trainer: " + trainer + "Time: " + time);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public static void listRooms(String SQL) {
        try {
            PreparedStatement pstmt = connection.prepareStatement(SQL);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("RID");
                String name = rs.getString("roomName");
                int capacity = rs.getInt("capacity");

                System.out.println(
                        "Room No. " + id + "| Name: " + name + "| Capacity: " + capacity + " ppl");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public static void listClasses(String SQL) {
        try {
            PreparedStatement pstmt = connection.prepareStatement(SQL);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ClassID");
                int rid = rs.getInt("RID");
                int createdBy = rs.getInt("createdBy");
                String name = rs.getString("className");

                System.out
                        .println("Class No. " + id + " | Room No. " + rid + " | Created By: " + createdBy + " | Name: "
                                + name);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public static void listTransactions(String SQL) {
        try {
            PreparedStatement pstmt = connection.prepareStatement(SQL);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("TransactionID");
                int memberID = rs.getInt("MemberID");
                int adminID = rs.getInt("ProcessedBy");
                double amount = rs.getDouble("Amount");
                String date = rs.getString("Date");

                System.out.println("Transaction No. " + id + " | Member No. " + memberID + " | Admin No. " + adminID
                        + " | Amount: " + amount + " | Date: " + date);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
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
            } catch (NoSuchElementException e) {
                System.out.println("No input detected. Please provide input.");
                scanner.next(); // consume the invalid input
            }
        }

        switch (userInput) {
            case 0:
                System.out.println("Closing Program");
                System.exit(0);
            case 1:
                Scanner scanner2 = new Scanner(System.in);
                PTQueries.listMembers();
                System.out.println("select a member");
                Main.currentMember = scanner2.nextInt();
                memberMenu();
                break;
            case 2:
                PTMenu();
                break;
            case 3:
                adminMenu();
                break;
            case 4:
                NewUserSubmenu.Createmember();
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
                System.out.println("1. Goals");// done
                System.out.println("2. Create Goal"); // done
                System.out.println("3. Training Sessions");
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
            } catch (NoSuchElementException e) {
                System.out.println("No input detected. Please provide input.");
                scanner.next(); // consume the invalid input
            }
        }

        switch (userInput) {
            case 0:
                MainMenu();
            case 1:
                MemberQueries.listGoals();
                break;
            case 2:
                MemberSubmenu.GoalPrompt();
                break;
            case 3:
                MemberSubmenu.MyTrainingSessionOptions();
                break;
            case 4:
                MemberSubmenu.ViewExercises();
                break;
            case 5:
                MemberSubmenu.ViewClasses();
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
        Scanner scanner1 = new Scanner(System.in);

        int lowerBound = 0;
        int upperBound = 8;
        int userInput;

        while (true) {
            try {
                System.out.println("------------------Admin Menu------------------");
                System.out.println("1. View Members"); // done
                System.out.println("2. Show Trainers"); // done
                System.out.println("3. Process Payment");
                System.out.println("4. View Rooms"); // done
                System.out.println("5. View Equipment"); // done
                System.out.println("6. View Classes"); // done
                System.out.println("7. Create Class");
                System.out.println("8. View Transactions");
                System.out.println("0. Back");

                System.out.println("Enter your choice: ");
                userInput = scanner1.nextInt();

                if (userInput >= lowerBound && userInput <= upperBound) {
                    break;
                } else {
                    System.out.println("Please try a valid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please try a valid option.");
                scanner1.next();
            } catch (NoSuchElementException e) {
                System.out.println("No input detected in adminMenu. Please provide input.");
                scanner1.next(); // consume the invalid input
            }
        }

        switch (userInput) {
            case 0:
                MainMenu();
                break;
            case 1:
                PTQueries.listMembers();
                adminMenu();
                break;
            case 2:
                PTQueries.ListTrainers();
                adminMenu();
                break;
            case 3:
                AdminSubmenu.processPayment();
                adminMenu();
                break;
            case 4:
                AdminQueries.listRooms();
                adminMenu();
                break;
            case 5:
                AdminQueries.listEqupiments();
                adminMenu();
                break;
            case 6:
                AdminQueries.listClasses();
                adminMenu();
                break;
            case 7:
                break;
            case 8:
                AdminQueries.listTransactions();
                adminMenu();
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                break;
        }

        scanner1.close();
    }
}
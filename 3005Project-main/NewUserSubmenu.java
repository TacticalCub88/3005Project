import java.util.Scanner;

public class NewUserSubmenu {
    public static void Createmember() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your information in the format: (Name) (Age)");
        // seeds input
        String userInput = scanner.nextLine();

        String[] parts = userInput.split(" ");

        String name = null;
        int age = 0;

        if (parts.length == 2) {
            name = parts[0];
            age = Integer.parseInt(parts[1]);
        } else {
            System.out.println("Invalid input format.");
        }

        if (name != null && age != 0) {
            MemberQueries.Create(name, age);
        }
        Main.MainMenu();
        scanner.close();

    }
}

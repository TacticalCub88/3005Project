public class PTQueries {
    public static void listMembers() {
        // Query to list all members
        String query = "SELECT * FROM fitnessMember";
        Main.listMembers(query);

    }

    public static void ListTrainers() {
        // Query to list all trainers
        String query = "SELECT * FROM personalTrainer";
        Main.listTrainers(query);

    }

    public static void createTrainer(String name, int age) {
        // Query to create a new trainer
        String query = "INSERT INTO personalTrainer (PTName, PTAge) VALUES ('" + name + "', " + age + ")";
        Main.adminQuery(query);
    }

    
}

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
}

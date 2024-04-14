public class PTQueries {
    public static void listMembers() {
        // Query to list all members
        String query = "SELECT * FROM fitnessMember";
        Main.listMembers(query);
        // Main.MainMenu();
    }

    public static void ListTrainers() {
        // Query to list all trainers
        String query = "SELECT * FROM personalTrainer";
        Main.listTrainers(query);

    }

    public static void createTrainer(String name, int age) {
        // Query to create a new trainer
        String query = "INSERT INTO personalTrainer (PTName, PTAge) VALUES ('" + name + "', " + age + ")";
        String success = "Personal Trainer: " + name + " age " + age + " has successfully been created";
        Main.runCreate(query, success);
    }

    public static void mySchedule() {
        String query = "SELECT PTSessions.sessionTime, fitnessMember.memberName FROM PTSessions JOIN fitnessMember ON PTSessions.MemberID = fitnessMember.MemberID WHERE PTSessions.PTID = "
                + Main.currentTrain;
        Main.ListTrainerSchedule(query);
    }

    public static void myMembers() {
        String query = "SELECT DISTINCT fitnessMember.memberName FROM PTSessions JOIN fitnessMember ON PTSessions.MemberID = fitnessMember.MemberID WHERE PTSessions.PTID = "
                + Main.currentTrain;
        Main.ListPTMembers(query);
    }
}

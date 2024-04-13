public class MemberQueries {

    // create user
    public static void Create(String name, int age) {
        String query = "INSERT INTO fitnessMember (memberName, Age) VALUES ('" + name + "', " + age + ")";
        String success = "Member: '" + name + "' age " + age + " has successfully been created";
        Main.runCreate(query, success);
    }

    public static void ListMySessions(int id) {
        String query = "SELECT PTSessions.*, personalTrainer.PTName " +
                "FROM PTSessions " +
                "INNER JOIN personalTrainer ON PTSessions.PTID = personalTrainer.PTID " +
                "WHERE PTSessions.MemberID = " + id;
        Main.listSessions(query);
    }

    public static void CreateGoal(String goal) {
        System.out.println("in method, here's goal: " + goal);
        int memberid = Main.currentMember;
        String query = "INSERT INTO Goal (MemberID, achievement, achieved,datecreated) VALUES (" + memberid + ", '"
                + goal
                + "', FALSE, CURRENT_DATE)";
        String success = "Goal: " + goal + " has been added";
        Main.runCreate(query, success);
        Main.memberMenu();
    }

    public static void listGoals() {
        System.out.println("Here are your goals: ");
        String query = "SELECT * FROM Goal WHERE MemberID = " + Main.currentMember;
        Main.listGoals(query);
        Main.memberMenu();
    }

    public static void createPTSession(String name, String time) {

    }

}

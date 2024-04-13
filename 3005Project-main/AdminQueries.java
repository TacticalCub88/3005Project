public class AdminQueries {

    public static void AddAdmin(String username, String password) {
        String query = "INSERT INTO Administrator (username, pwd) VALUES ('" + username + "', '" + password + "')";
        Main.adminQuery(query);
    }

    public static void UpdateAdmin(String username, String password) {
        String query = "UPDATE Administrator SET pwd = '" + password + "' WHERE username = '" + username + "'";
        Main.adminQuery(query);
    }

    public static void ListAdmins() {
        String query = "SELECT * FROM Administrator";
        Main.ListAdmins(query);
    }

    public static void listEqupiments() {
        String query = "SELECT * FROM Equipment";
        Main.listEqupiment(query);
    }

    public static void listRooms() {
        String query = "SELECT * FROM Room";
        Main.listRooms(query);
    }

    public static void listClasses() {
        String query = "SELECT * FROM fitnessClass";
        Main.listClasses(query);
    }

    public static void listTransactions() {
        String query = "SELECT * FROM Transactions";
        Main.listTransactions(query);
    }

    public static void processPayment(int person, double amount) {
        String query = "INSERT INTO Transactions (MemberID, Amount, ProcessedBy, Date) VALUES ('"
                + person + "', '" + amount + "', '" + 1 + "', CURRENT_TIMESTAMP)";
        // String query1 = "UPDATE fitnessMember SET ActiveMember = TRUE WHERE MemberID
        // = '" + person + "'";
        Main.adminQuery(query);
        // Main.adminQuery(query1);
        // Main.adminMenu();
    }
}

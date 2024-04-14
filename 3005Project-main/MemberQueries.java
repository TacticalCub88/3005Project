import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;

public class MemberQueries {

    // create user
    public static void Create(String name, int age) {
        String query = "INSERT INTO fitnessMember (memberName, Age) VALUES ('" + name + "', " + age + ")";
        String success = "Member: '" + name + "' age " + age + " has successfully been created";
        Main.runCreate(query, success);
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

    public static void ListMySessions(int id) {
        String query = "SELECT PTSessions.*, personalTrainer.PTName " +
                "FROM PTSessions " +
                "INNER JOIN personalTrainer ON PTSessions.PTID = personalTrainer.PTID " +
                "WHERE PTSessions.MemberID = " + id;
        Main.listPTSessionsForMember(query);
    }

    // input: 2024-04-10 08:00:00
    public static void createPTSession(String PTID, String time) {
        System.out.println(time);
        int memberid = Main.currentMember;

        String query = "INSERT INTO PTSessions(MemberID, PTID, sessionTime, createdBy) VALUES(" +
                memberid + "," + PTID + ",'" + time + "'," + memberid + ")";

        String success = "Personal training session with " + PTID + " at " + Timestamp.valueOf(time)
                + " has been created";
        Main.runCreate(query, success);
    }

    public static void dropPTSession(int sessionId) {
        int memberid = Main.currentMember;
        String query = "DELETE FROM PTSessions WHERE PTSessionID = " + String.valueOf(sessionId);
        String success = "Training Session id " + String.valueOf(sessionId) + " has been deleted";
        Main.runCreate(query, success);
        Main.memberMenu();
    }

    public static void ViewExercises() {
        int methodcurrentMember = Main.currentMember;
        String query = "SELECT * FROM Workouts WHERE MemberID = " + methodcurrentMember;
        Main.listWorkouts(query);
        Main.memberMenu();
    }

    public static void ViewClasses() {
        int methodcurrentMember = Main.currentMember;
        String query = "SELECT Join_Classes.*, fitnessClass.className, fitnessClass.RID " +
                "FROM Join_Classes " +
                "INNER JOIN fitnessClass ON Join_Classes.classID = fitnessClass.classID " +
                "WHERE Join_Classes.MemberID = " + methodcurrentMember;
        Main.listMemberClasses(query);
        Main.memberMenu();
    }

}

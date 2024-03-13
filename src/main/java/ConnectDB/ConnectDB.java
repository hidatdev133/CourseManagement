package ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectDB {

    public static Connection con;
    private static Statement st;
    private static String host, port, dbName, dbUser, dbPassword;

    public static void connectDB() {
        host = "localhost";
        port = "3306";
        dbUser = "root";
        dbName = "School";
        dbPassword = "";
        String dbPath = "jdbc:mysql://" + host + ":" + port + "/"
                + dbName + "?useUnicode=yes&characterEncoding=UTF-8";
        try {
            con = (Connection) DriverManager.getConnection(dbPath, dbUser, dbPassword);
            st = con.createStatement();
            System.out.println("Connected");
            doSelect();
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
    }

    public static Connection getConnection() {
        host = "localhost";
        port = "3306";
        dbUser = "root";
        dbName = "school";
        dbPassword = "";
        String dbPath = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
        try {
            con = DriverManager.getConnection(dbPath, dbUser, dbPassword);
            System.out.println("Connected to the database successfully.");
        } catch (SQLException ex) {
            System.out.println("Failed to connect to the database.");
            ex.printStackTrace();
        }
        return con;
    }

//run sql
    public static ResultSet doReadQuery(String sql) {
        ResultSet rs = null;

        try {
            if (st == null || con.isClosed()) {
                connectDB(); // Ensure connection is established
            }
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    private static void doSelect() {
        String query = "SELECT * FROM course";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int courseid = rs.getInt("CourseID");
                String title = rs.getString("Title");
                int credits = rs.getInt("Credits");
                int departmentid = rs.getInt("DepartmentID");
                System.out.println(courseid + " " + title + " " + credits + " " + departmentid);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConnectDB.connectDB();
    }
}

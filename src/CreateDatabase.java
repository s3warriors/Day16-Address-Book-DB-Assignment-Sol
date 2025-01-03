import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "password")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE DATABASE AddressBookDB");
            System.out.println("Database AddressBookDB created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


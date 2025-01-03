// UC 1: Create Address Book Database
import java.sql.*;

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


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// UC 2: Create Address Book Table
public class CreateTable {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AddressBookDB", "root", "password")) {
            String query = "CREATE TABLE Contacts (" +
                    "contact_id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "first_name VARCHAR(50), " +
                    "last_name VARCHAR(50), " +
                    "address VARCHAR(100), " +
                    "city VARCHAR(50), " +
                    "state VARCHAR(50), " +
                    "zip INT, " +
                    "phone_number VARCHAR(15), " +
                    "email VARCHAR(50));";

            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Contacts created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

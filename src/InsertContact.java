import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// UC 3: Insert New Contacts
public class InsertContact {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AddressBookDB", "root", "password")) {
            String query = "INSERT INTO Contacts (first_name, last_name, address, city, state, zip, phone_number, email) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, "John");
            preparedStatement.setString(2, "Doe");
            preparedStatement.setString(3, "123 Elm St");
            preparedStatement.setString(4, "New York");
            preparedStatement.setString(5, "NY");
            preparedStatement.setInt(6, 10001);
            preparedStatement.setString(7, "1234567890");
            preparedStatement.setString(8, "john.doe@example.com");
            preparedStatement.executeUpdate();

            System.out.println("Contact inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// UC 4: Edit Existing Contact
public class EditContact {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AddressBookDB", "root", "password")) {
            String query = "UPDATE Contacts SET phone_number = ? WHERE first_name = ? AND last_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, "5551234567");
            preparedStatement.setString(2, "John");
            preparedStatement.setString(3, "Doe");
            preparedStatement.executeUpdate();

            System.out.println("Contact updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

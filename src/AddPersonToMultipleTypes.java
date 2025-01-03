import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// UC 11: Add a Person to Both Friend and Family
public class AddPersonToMultipleTypes {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AddressBookDB", "root", "password")) {
            String query = "INSERT INTO Contacts (first_name, last_name, address, city, state, zip, phone_number, email, address_book_name, type) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Adding the same person to Friends
            preparedStatement.setString(1, "John");
            preparedStatement.setString(2, "Doe");
            preparedStatement.setString(3, "123 Elm St");
            preparedStatement.setString(4, "New York");
            preparedStatement.setString(5, "NY");
            preparedStatement.setInt(6, 10001);
            preparedStatement.setString(7, "1234567890");
            preparedStatement.setString(8, "john.doe@example.com");
            preparedStatement.setString(9, "MyContacts");
            preparedStatement.setString(10, "Friends");
            preparedStatement.executeUpdate();

            // Adding the same person to Family
            preparedStatement.setString(10, "Family");
            preparedStatement.executeUpdate();

            System.out.println("Person added to both Friend and Family.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

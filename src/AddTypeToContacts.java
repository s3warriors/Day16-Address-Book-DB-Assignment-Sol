import java.sql.*;

// UC 9: Identify Address Books by Name and Type
public class AddTypeToContacts {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AddressBookDB", "root", "password")) {
            String alterQuery = "ALTER TABLE Contacts ADD address_book_name VARCHAR(50), ADD type VARCHAR(50)";
            Statement statement = connection.createStatement();
            statement.executeUpdate(alterQuery);

            String updateQuery = "UPDATE Contacts SET address_book_name = ?, type = ? WHERE first_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, "MyContacts");
            preparedStatement.setString(2, "Friends");
            preparedStatement.setString(3, "John");
            preparedStatement.executeUpdate();

            System.out.println("Address book type added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

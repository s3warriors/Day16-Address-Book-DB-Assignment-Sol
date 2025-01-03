import java.sql.*;

// UC 10: Count Contact Persons by Type
public class CountByType {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AddressBookDB", "root", "password")) {
            String query = "SELECT type, COUNT(*) AS count FROM Contacts GROUP BY type";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Type: " + ((ResultSet) resultSet).getString("type") + ", Count: " + resultSet.getInt("count"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// UC 12: Draw the ER Diagram (Conceptual - Not Code)
/*
Entities:
1. Contacts
   - Attributes: contact_id, first_name, last_name, address, city, state, zip, phone_number, email, address_book_name, type

Relationships:
- Contacts are grouped by address_book_name and type.

Normalization:
- Ensure no redundant data (e.g., separate address into street, city, state, zip if needed).
- Maintain atomic attributes (e.g., phone_number and email).
*/


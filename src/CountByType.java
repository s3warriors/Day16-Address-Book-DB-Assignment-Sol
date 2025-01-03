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

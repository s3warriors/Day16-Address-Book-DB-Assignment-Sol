import java.sql.*;
import java.util.Scanner;

// UC 8: Retrieve Entries Sorted by Name for a Given City
public class SortedEntriesByCity {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AddressBookDB", "root", "password")) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter city:");
            String city = scanner.nextLine();

            String query = "SELECT * FROM Contacts WHERE city = ? ORDER BY first_name, last_name";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, city);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Name: " + resultSet.getString("first_name") + " " + resultSet.getString("last_name"));
            }

            scanner.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

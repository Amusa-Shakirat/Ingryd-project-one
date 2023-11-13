import java.sql.*;
import java.util.Scanner;

public class ProjectOne {
    int count = 1;
    public static void main(String[] args) {

        ProjectOne projectOne = new ProjectOne();
        projectOne.createTable();
        projectOne.populateTable();
        System.out.println(projectOne.populateTable());



    }
    void createTable(){
        try(Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/project_one","smat","Darasimi@1");
            Statement statement= connection.createStatement()) {

            statement.execute("CREATE TABLE IF NOT EXISTS project(name Text, email Text, age Int, location Text, designation Text)");

            //PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO project(name,email, age, location, designation) VALUES(?, ?, ?, ?, ?)");

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    int populateTable() {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_one", "smat", "Darasimi@1");
             Scanner scanner = new Scanner(System.in)){
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO project(name,email, age, location, designation) VALUES(?, ?, ?, ?, ?)");




            do {
                System.out.print("Enter value for name: ");
                String name = scanner.nextLine();

                System.out.print("Enter value for email: ");
                String email = scanner.nextLine();

                System.out.print("Enter value for age: ");
                int age = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter value for location: ");
                String location = scanner.nextLine();

                System.out.print("Enter value for destination: ");
                String destination = scanner.nextLine();

                // Set values for the prepared statement
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, email);
                preparedStatement.setInt(3, age);
                preparedStatement.setString(4, location);
                preparedStatement.setString(5, destination);

                // Execute the SQL query to insert data
                preparedStatement.execute();
                count++;

            } while(count <= 10);

        } catch(Exception exception){
            System.out.println(exception.getMessage());
        }

        return count;
    }
}




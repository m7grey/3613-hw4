/*
    JDBC
    Use your java code to connect to CUNY_DB we used in class to show all classes you have registered.
    You need to show your name and course names.
*/
import java.sql.*;

public class SimpleJdbc {
  public static void main(String[] args)
          throws SQLException, ClassNotFoundException {
    // Load the JDBC driver
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    System.out.println("Driver loaded");

    // Connect to a database
    Connection connection = DriverManager.getConnection("jdbc:sqlserver://s16988308.onlinehome-server.com:1433;databaseName=CUNY_DB;" + "integratedSecurity=false;", "cst3613", "password1");
    System.out.println("Database connected. Query with LastName: Yarosh ");


    // Create a statement
    Statement statement = connection.createStatement();

    // Execute a statement


    ResultSet resultSet = statement.executeQuery
            ("select firstName, mi, lastName, deptId from Students where lastName "
                    + " = 'Yarosh'");

    // Iterate through the result and print the student names
    while (resultSet.next())
      System.out.println(
              resultSet.getString(1) + "\t" +
              resultSet.getString(3)  + "\t" +
                      resultSet.getString(4)
      );

    resultSet.close();
    // Close the connection
    connection.close();
  }
}
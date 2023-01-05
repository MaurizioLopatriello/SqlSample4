import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SqlClass4 {

    public static void main(String[] args) {

        ArrayList italianStudents = new ArrayList();
        ArrayList germanStudents = new ArrayList();

        String query2 = "Select last_name , first_name from german_students";
        String query = "Select last_name , first_name  from italian_students;";

        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "dev1", "dev1");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next()) {
                italianStudents.add(resultSet.getString("first_name") + " "
                        + resultSet.getString("last_name") + " "
                );

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(italianStudents);


        try {
            Connection connection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "dev1", "dev1");

            Statement statement2 = connection2.createStatement();

            ResultSet germanResultSet = statement2.executeQuery(query2);

            while (germanResultSet.next()) {
                germanStudents.add(germanResultSet.getString("first_name") + " "
                        + germanResultSet.getString("last_name") + " "
                );

            }

        }catch (Exception e){
            e.printStackTrace();


        }

        System.out.println(germanStudents);
    }
}





import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Methods {
    MyDataBase myDataBase = new MyDataBase();
    public void SortedStudentsOutput()
    {
        Connection connection = null;
        try {
            connection = myDataBase.openConnection();
            String query = "SELECT students.surname, students.name, students.middle_name, studentsTest.var FROM `studentsTest`, `students` WHERE studentsTest.id_student = students.id_student ORDER BY students.surname ASC";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                String surnam = resultSet.getString("students.surname");
                String nam = resultSet.getString("students.name");
                String midname = resultSet.getString("students.middle_name");
                int var = resultSet.getInt("studentsTest.var");
                System.out.println(surnam +" " + nam + " " + midname + " | " + var + " вариант");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            myDataBase.closeConnection(connection);
        }
    }
    public void SearchStudents(String surname)
    {
        Connection connection = null;
        try {
            connection = myDataBase.openConnection();
            String query = "SELECT studentsTest.var FROM `studentsTest`, `students` WHERE studentsTest.id_student = students.id_student AND students.surname = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,surname);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                int var = resultSet.getInt("studentsTest.var");
                System.out.println("Вариант введёного студента: " + var);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            myDataBase.closeConnection(connection);
        }
    }
    public void SearchStudentsVar(String tempVar)
    {
        Connection connection = null;
        try {
            connection = myDataBase.openConnection();
            String query = "SELECT students.surname, students.name, students.middle_name, studentsTest.var FROM `studentsTest`, `students` WHERE studentsTest.id_student = students.id_student AND studentsTest.var = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,tempVar);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                String surname = resultSet.getString("students.surname");
                String name = resultSet.getString("students.name");
                String midname = resultSet.getString("students.middle_name");
                int variant = resultSet.getInt("studentsTest.var");
                System.out.println(surname + " " + name + " " + midname + " | " + variant);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            myDataBase.closeConnection(connection);
        }
    }
}

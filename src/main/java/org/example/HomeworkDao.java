package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HomeworkDao {
    public static void addHomework(Homework homework) throws SQLException {
        String query = "INSERT INTO homework ( name, description) VALUES (?, ?)";
        PreparedStatement statement = DataBaseConnection.getConnection().prepareStatement(query);
        statement.setString(1, homework.getName());
        statement.setString(2, homework.getDescription());
        statement.executeUpdate();

    }

    public static void deleteHomework(int id) throws SQLException {
        String query = "DELETE FROM homework WHERE id=?";
        PreparedStatement statement = DataBaseConnection.getConnection().prepareStatement(query);
        statement.setInt(1, id);
        statement.executeUpdate();

    }
}

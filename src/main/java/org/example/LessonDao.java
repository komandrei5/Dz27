package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LessonDao {
    public static void addLesson(Lesson lesson) throws SQLException {
        String query = "INSERT INTO lesson (name, lesson_updateAt, homework_id) VALUES (?, ?, ?)";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, lesson.getName());
            statement.setTimestamp(2, new Timestamp(System.currentTimeMillis()));

            Homework homework = lesson.getHomework();
            if (homework != null) {
                statement.setInt(3, homework.getId());
            }
            statement.executeUpdate();
        }
    }


    public static void deleteLesson(int id) throws SQLException {
        String query = "DELETE FROM lesson WHERE id=?";
        PreparedStatement statement = DataBaseConnection.getConnection().prepareStatement(query);
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    public static List<Lesson> getAllLessons() throws SQLException {
        List<Lesson> lessons = new ArrayList<>();
        String query = "SELECT * FROM Lesson LEFT JOIN Homework ON Lesson.homework_id = Homework.id";
        PreparedStatement statement = DataBaseConnection.getConnection().prepareStatement(query);
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("Lesson.id");
            String name = resultSet.getString("Lesson.name");
            int homeworkId = resultSet.getInt("Homework.id");
            String homeworkName = resultSet.getString("Homework.name");
            String homeworkDescription = resultSet.getString("Homework.description");

            Homework homework = new Homework(homeworkName, homeworkDescription);
            Lesson lesson = new Lesson( name, homework);
            lessons.add(lesson);
        }

        return lessons;
    }

    public static Lesson getLessonById(int lessonId) throws SQLException {

        String query = "SELECT Lesson.id, Lesson.name, Lesson.create_at, Homework.id, Homework.name, Homework.description FROM Lesson JOIN Homework ON Lesson.homework_id = Homework.id WHERE Lesson.id = ?";
        PreparedStatement statement = DataBaseConnection.getConnection().prepareStatement(query);

        statement.setInt(1, lessonId);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            String lessonName = rs.getString(2);
            java.sql.Timestamp updatedAt = rs.getTimestamp(3);
            int homeworkId = rs.getInt(4);
            String homeworkName = rs.getString(5);
            String homeworkDescription = rs.getString(6);
            Homework homework = new Homework(homeworkName, homeworkDescription);
            return new Lesson( lessonName, homework);
        }
        return null;
    }
}

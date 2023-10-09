package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class HomeworkDaoTest {
    @Test
    public void testAddHomework() throws SQLException{
        Homework homework = new Homework("Test Homework", "Description for Test Homework");
        homework.setName("Test Homework");
        homework.setDescription("This is a test homework");

        HomeworkDao.addHomework(homework);
        assertDoesNotThrow(() -> HomeworkDao.addHomework(homework));

    }

    @Test
    public void testDeleteHomework() throws SQLException {
        int idHomework = 1;
        HomeworkDao.deleteHomework(idHomework);
        assertTrue(true);

    }
}
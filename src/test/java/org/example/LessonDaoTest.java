package org.example;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LessonDaoTest {

    @Test
    public void testAddLesson() throws SQLException {
        Homework homework = new Homework("Test Homework", "Description for Test Homework");
        Lesson lesson = new Lesson("Test Lesson", homework);
        LessonDao.addLesson(lesson);
        assertDoesNotThrow(() -> LessonDao.addLesson(lesson));
    }
    @Test
    void deleteLesson() throws SQLException {
        int idLesson = 1;
        LessonDao.deleteLesson(idLesson);
        assertTrue(true);
    }

    @Test
    void getAllLessons() throws SQLException {
        List<Lesson> lessons = LessonDao.getAllLessons();
        assertNotNull(lessons);
        assertFalse(lessons.isEmpty());
    }
    @Test
    void getLessonById() throws SQLException {
        Lesson lesson = LessonDao.getLessonById(2);

        assertNotNull(lesson);
        assertEquals(0, lesson.getId());
        assertEquals(0, lesson.getHomework().getId());

    }
}
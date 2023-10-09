package org.example;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

@Data
@Accessors(chain = true)
@ToString
public class Lesson {
    private int id;
    private String name;
    private Homework homework;
    private Timestamp updatedAt;

    public Lesson(String name, Homework homework) {
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}

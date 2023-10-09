package org.example;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors (chain = true)
public class Homework {
    private int id;
    private String name;
    private String description;
    public Homework(String homeworkName, String homeworkDescription) {

    }
}

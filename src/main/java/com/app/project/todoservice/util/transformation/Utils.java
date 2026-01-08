package com.app.project.todoservice.util.transformation;

import java.time.Instant;

public class Utils {

    public static Integer getRandomInt() {
        return Instant.now().getNano();
    }
}

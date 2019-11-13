package com.example.task04;

import java.io.*;
import java.time.temporal.ChronoUnit;

import lombok.NonNull;

public class RotationFileHandler implements MessageHandler {
    private ChronoUnit duration;
    private long time;
    private String path;

    public RotationFileHandler(@NonNull ChronoUnit duration) {
        this.duration = duration;
        this.time = System.currentTimeMillis();
        this.path = "log" + time + ".txt";
    }

    @Override
    public void print(@NonNull String message) {
        if (System.currentTimeMillis() - time >= duration.getDuration().toMillis()) {
            time = System.currentTimeMillis();
            this.path = "log" + time + ".txt";
        }
        try (FileWriter fw = new FileWriter(this.path, true)) {
            fw.append(message + '\n');
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

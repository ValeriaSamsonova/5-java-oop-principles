package com.example.task04;

import java.io.*;

import lombok.NonNull;

public class FileHandler implements MessageHandler {
    private final String path;

    public FileHandler(String path) {
        this.path = path;
    }

    @Override
    public void print(@NonNull String message) {
        try (FileWriter writer = new FileWriter(path, true)) {
            writer.append(message + "\n");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

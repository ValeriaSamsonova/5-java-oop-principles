package com.example.task04;

import lombok.NonNull;

public class ConsoleHandler implements MessageHandler {
    @Override
    public void print(@NonNull String message) {
        System.out.println(message);
    }
}
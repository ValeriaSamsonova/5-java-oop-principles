package com.example.task04;

import lombok.NonNull;

public interface MessageHandler {
    void print(@NonNull String message);
}

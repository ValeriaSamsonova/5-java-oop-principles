package com.example.task04;

import java.util.ArrayList;
import java.util.List;

import lombok.NonNull;

public class MemoryHandler implements MessageHandler {
    private final MessageHandler hndl;
    private final int limit;
    private List<String> messages = new ArrayList<String>();

    public MemoryHandler(MessageHandler hndl, int limit) {
        this.limit = limit;
        this.hndl = hndl;
    }

    @Override
    public void print(@NonNull String message) {
        messages.add(message);
        if (messages.size() > limit) {
            for (String msg : messages) {
                hndl.print(msg);
            }
            messages.clear();
        }
        try {
            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    System.out.println("Shutdown");
                    messages.clear();
                }
            });
        } catch (Exception excpt) {
            System.out.println(excpt.getMessage());
        }
    }


}

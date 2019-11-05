package com.example.task01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import lombok.NonNull;

enum LogLevels {
    DEBUG,
    INFO,
    WARNING,
    ERROR
}

public class Logger {
    private LogLevels thisLevel;
    private String name;
    private static int maxLevel = 0;
    private static List<Logger> loggerList = new ArrayList<>();

    public Logger(@NonNull String Name) {
        for (Logger e : loggerList) {
            if (e.name.equals(Name)) {
                throw new IllegalArgumentException();
            }
        }
        name = Name;
        loggerList.add(this);
    }

    public static Logger getLogger(@NonNull String Name) {
        for (Logger e : loggerList) {
            if (e.name.equals(Name)) {
                return e;
            }
        }
        throw new IllegalArgumentException();
    }

    public String getName() {
        return this.name;
    }

    public LogLevels getLevel() {
        return thisLevel;
    }

    public void setLevel(@NonNull LogLevels lvl) {
        thisLevel = lvl;

        switch (lvl) {
            case DEBUG:
                maxLevel = 1;
                break;
            case INFO:
                maxLevel = 2;
                break;
            case ERROR:
                maxLevel = 3;
                break;
            case WARNING:
                maxLevel = 4;
                break;
            default:
                break;
        }
    }

    public void log(@NonNull LogLevels level, @NonNull String message) {
        log(level, message, (Object) null);
    }

    public void log(@NonNull LogLevels level, @NonNull String message, @NonNull Object... obj) {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        System.out.println("[" + level + "] " + sdfDate.format(new Date()) + " " + this.name + " - " + String.format(message, obj));
    }

    public void debug(@NonNull String msg) {
        if (maxLevel < 1) {
            setLevel(LogLevels.DEBUG);
        }
        if (maxLevel == 1) {
            log(LogLevels.DEBUG, msg);
        }
    }

    public void debug(@NonNull String template, @NonNull Object... obj) {
        if (maxLevel < 1) {
            setLevel(LogLevels.DEBUG);
        }
        if (maxLevel == 1) {
            log(LogLevels.DEBUG, template, obj);
        }
    }

    public void info(@NonNull String msg) {
        if (maxLevel < 2) {
            setLevel(LogLevels.INFO);
        }
        if (maxLevel == 2) {
            log(LogLevels.INFO, msg);
        }
    }

    public void info(@NonNull String template, @NonNull Object... obj) {
        if (maxLevel < 2) {
            setLevel(LogLevels.INFO);
        }
        if (maxLevel == 2) {
            log(LogLevels.INFO, template, obj);
        }
    }

    public void warning(@NonNull String msg) {
        if (maxLevel < 3) {
            setLevel(LogLevels.WARNING);
        }
        if (maxLevel == 3) {
            log(LogLevels.WARNING, msg);
        }
    }

    public void warning(@NonNull String template, @NonNull Object... obj) {
        if (maxLevel < 3) {
            setLevel(LogLevels.WARNING);
        }
        if (maxLevel == 3) {
            log(LogLevels.WARNING, template, obj);
        }
    }

    public void error(@NonNull String msg) {
        if (maxLevel < 4) {
            setLevel(LogLevels.ERROR);
        }
        if (maxLevel == 4) {
            log(LogLevels.ERROR, msg);
        }
    }

    public void error(@NonNull String template, @NonNull Object... obj) {
        if (maxLevel < 4) {
            setLevel(LogLevels.ERROR);
        }
        if (maxLevel == 4) {
            log(LogLevels.ERROR, template, obj);
        }
    }
}

package com.example.spartafinalproject.logging;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LogSetup {
    public static void setup(){
        LogManager logManager = LogManager.getLogManager();
        logManager.reset();

        Logger rootLogger = Logger.getLogger("");
        rootLogger.addHandler(FileHandlerConfig.getFileHandler());
        rootLogger.setLevel(Level.CONFIG);
    }

    public  static void close(){
        Logger rootLogger = Logger.getLogger("");
        rootLogger.removeHandler(FileHandlerConfig.getFileHandler());
    }
}

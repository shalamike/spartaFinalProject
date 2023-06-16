package com.example.spartafinalproject.logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

public class FileHandlerConfig {
    private static FileHandler fileHandler;
    public static FileHandler getFileHandler(){
        if(fileHandler==null){
            try{
                fileHandler=new FileHandler("src/main/logs/logFile.log",false);
                fileHandler.setLevel(Level.ALL);
                fileHandler.setFormatter(new SimpleFormatter() {
                    @Override
                    public synchronized String format(LogRecord record) {
                        return record.getMessage() + System.lineSeparator();
                    }
                });
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return fileHandler;
    }
}

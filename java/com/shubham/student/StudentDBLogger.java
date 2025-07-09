package com.shubham.student;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StudentDBLogger extends Thread {
    private final String message;
    private static final String Log_File_Path = System.getProperty("user.dir") + File.separator + "student-actions.log";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public StudentDBLogger(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(300); 
            String timestamp = LocalDateTime.now().format(formatter);
            String fullMessage = "[" + timestamp + "] " + message;

            try (FileWriter fw = new FileWriter(Log_File_Path, true);) {
                fw.write(fullMessage + "\n");
            }

            System.out.println("[Logger] " + fullMessage);
        } catch (InterruptedException | IOException e) {
            System.out.println("Logger error: " + e.getMessage());
        }
    }
}
 
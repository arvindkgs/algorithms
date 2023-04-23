package com.akgs.algo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HelloWorld {
    public static void main(String[] args) {
        executeCommand("pwd");
    }
    // execute system command
    public static void executeCommand(String command) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
            final InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            System.out.println("Command executed successfully");
            String line = "";
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

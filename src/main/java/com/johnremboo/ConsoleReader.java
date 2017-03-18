package com.johnremboo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Igor on 18.03.2017.
 */
public class ConsoleReader {
    private static BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

    public static String read() {
        try {
            String line = consoleReader.readLine();

            if (line.equals("exit"))
                System.exit(0);

            return line;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

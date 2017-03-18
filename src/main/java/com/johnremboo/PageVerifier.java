package com.johnremboo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Pattern;

import static java.lang.System.out;

/**
 * Created by Igor Orekhov on 18.03.2017.
 */
public class PageVerifier {
    private StringBuilder builder;

    public Page verify() {
        String address;

        out.println("Enter URL or type 'exit': ");
        address = ConsoleReader.read();

        if (!isCorrectAddress(address)) {
            out.println("Incorrect URL: \"" + address + "\"");
            return null;
        }

        String data = parseHtml(address);

        if (!isCorrectHtml(data)) {
            out.println("This URL - " + address + " - does not contain HTML entry");
            return null;
        }

        return new Page(data, true);
    }

    private boolean isCorrectHtml(String page) {
        Pattern pattern = Pattern.compile("<!doctype html.*<html>.*<head>.*</head>.*<body>.*</body>.*</html>");
        return pattern.matcher(page).matches();
    }

    private String parseHtml(String address) {
        try {
            URL url = new URL(address);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
            builder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null)
                builder.append(line);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    private boolean isCorrectAddress(String address) {
        return address.startsWith("http://");
    }
}

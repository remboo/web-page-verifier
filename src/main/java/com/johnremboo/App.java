package com.johnremboo;

import java.io.*;
import java.util.*;

/**
 * Created by Igor Orekhov on 18.03.2017.
 */
public class App {
    private static HashMap<String, Integer> words;

    public static void main(String[] args) throws IOException {
        PageVerifier pageVerifier = new PageVerifier();
        WordsCounter wordsCounter = new WordsCounter();

        Page page = pageVerifier.verify();

        if (page != null && page.isVerified())
            wordsCounter.process(page);
    }
}

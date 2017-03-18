package com.johnremboo;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by Igor Orekhov on 18.03.2017.
 */
public class WordsCounter {
    public void process(Page page) {
        String data = deleteHtmlTags(page);

        StringTokenizer tokenizer = new StringTokenizer(data, " \t\n\r,.;-");
        Map<String, Integer> words = new HashMap<>();

        int wordsCounter = 0;

        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();

            if (word.matches(".*\\d+.*") || word.matches(".*\\W+.*") || word.contains("_"))
                continue;

            wordsCounter++;

            if (words.containsKey(word)) {
                words.put(word, words.get(word) + 1);
            } else {
                words.put(word, 1);
            }
        }

        System.out.println("Total number of words: " + wordsCounter);
        System.out.println("Number of unique words: " + words.size());
        System.out.println("=============================================");

        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            System.out.println("word: '" + entry.getKey() + "' repetitions - " + entry.getValue());
        }
    }

    private static String deleteHtmlTags(Page page) {
        String[] params = {"style", "image", "object", /*"script"*/};
        String data = page.getData();

        for (String s : params) {
            String param = "<" + s + ">" + ".*" + "</" + s + ">";
            data = data.replaceAll(param, "");
        }
        return data.replaceAll("<.*?>", "");
    }
}

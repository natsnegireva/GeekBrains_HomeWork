package homework3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class WordArray {

    public static void UniqueWords(String[] words) {
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        System.out.println("Список уникальных слов в массиве " + uniqueWords);
        System.out.println();
    }

    public static void CountWords(String[] words) {
        HashMap<String, Integer> wordToCount = new HashMap<>();
        for (String word : words) {
            if (!wordToCount.containsKey(word)) {
                wordToCount.put(word, 0);
            }
            wordToCount.put(word, wordToCount.get(word) + 1); // перезаписываем значение для ключа
        }
        System.out.println("Сколько раз встречается каждое слово");
        for (String word : wordToCount.keySet()) {
            System.out.print(wordToCount.get(word) + " - " + word + " | ");
        }
    }
}

package homework3;

public class Main {

    public static void main(String[] args) {
        // Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся)
        String[] words = new String[]{"apple", "orange", "lemon", "banana", "apricot",
                "avacado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon",
                "carrot", "carrot", "carrot", "lemon", "banana", "apricot", "leak", "kiwi",
                "mango", "mushrooms", "nut", "olive", "pea", "peanut", "peper", "pineapple",
                "pumkin", "potato", "grape", "melon", "apricot", "leak", "apricot", "avacado"};
        WordArray.UniqueWords(words);
        WordArray.CountWords(words);

    }
}







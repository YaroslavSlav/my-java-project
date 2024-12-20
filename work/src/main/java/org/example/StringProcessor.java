package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcessor {

    // Метод 1: Повтор строки N раз
    public static String repeatString(String s, int n) {
        if (n < 0) throw new IllegalArgumentException("N must be non-negative.");
        return s.repeat(n);
    }

    // Метод 2: Подсчет вхождений одной строки в другую
    public static int countOccurrences(String mainStr, String subStr) {
        if (subStr == null || subStr.isEmpty()) {
            throw new IllegalArgumentException("Substring cannot be null or empty.");
        }
        return mainStr.split(Pattern.quote(subStr), -1).length - 1;
    }

    // Метод 3: Замена '1', '2', '3' на "один", "два", "три"
    public static String replaceDigits(String input) {
        return input.replace("1", "один")
                .replace("2", "два")
                .replace("3", "три");
    }

    // Метод 4: Удаление каждого второго символа из StringBuilder
    public static void removeEverySecondChar(StringBuilder sb) {
        for (int i = 1; i < sb.length(); i++) {
            sb.deleteCharAt(i);
        }
    }

    // Метод 5 (*): Реверс слов с сохранением пробелов
    public static String reverseWordsPreserveSpaces(String input) {
        String[] words = input.trim().split("\\s+");
        StringBuilder result = new StringBuilder(input.length());
        int wordIndex = words.length - 1;

        for (char c : input.toCharArray()) {
            if (Character.isWhitespace(c)) {
                result.append(c);
            } else if (wordIndex >= 0) {
                result.append(words[wordIndex].charAt(0));
                if (words[wordIndex].length() > 1) {
                    words[wordIndex] = words[wordIndex].substring(1);
                } else {
                    wordIndex--;
                }
            }
        }
        return result.toString();
    }

    // Метод 6 (*): Замена 0xNNNNNNNN на десятичные числа
    public static String replaceHexWithDecimal(String input) {
        // Шаблон для поиска строк вида 0xNNNNNNNN
        Pattern pattern = Pattern.compile("0x([0-9A-Fa-f]{8})");
        Matcher matcher = pattern.matcher(input);
        StringBuffer result = new StringBuffer();

        // Обработка всех совпадений
        while (matcher.find()) {
            // Извлечение шестнадцатеричного числа
            String hex = matcher.group(1);
            // Преобразование в десятичное число
            long decimal = Long.parseLong(hex, 16);
            // Замена текущего совпадения на десятичное число
            matcher.appendReplacement(result, String.valueOf(decimal));
        }
        // Добавление оставшейся части строки
        matcher.appendTail(result);

        return result.toString();
    }

    // Тестирование всех методов
    public static void main(String[] args) {
        // Тест для метода 1
        System.out.println("Метод 1:");
        System.out.println(repeatString("abc", 3)); // "abcabcabc"
        System.out.println(repeatString("a", 0)); // ""

        // Тест для метода 2
        System.out.println("\nМетод 2:");
        System.out.println(countOccurrences("abababa", "aba")); // 2
        System.out.println(countOccurrences("hello", "l")); // 2

        // Тест для метода 3
        System.out.println("\nМетод 3:");
        System.out.println(replaceDigits("12345")); // "одиндватрит45"

        // Тест для метода 4
        System.out.println("\nМетод 4:");
        StringBuilder sb = new StringBuilder("abcdef");
        removeEverySecondChar(sb);
        System.out.println(sb.toString()); // "ace"

        // Тест для метода 5
        System.out.println("\nМетод 5:");
        System.out.println(reverseWordsPreserveSpaces("  aaa  bbb   cc dd ")); // "  dd  cc   bbb aaa "

        // Тест для метода 6
        System.out.println("\nМетод 6:");
        System.out.println(replaceHexWithDecimal("Васе 0x00000010 лет, его другу 0x0000001F лет.")); // "Васе 16 лет, его другу 31 лет."
    }

    public static String replaceNumbers(String s) {
        return s;
    }
}

import org.example.StringProcessor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringProcessorTest {

    @Test
    void testRepeatString() {
        assertEquals("aaa", StringProcessor.repeatString("a", 3));
        assertEquals("", StringProcessor.repeatString("a", 0));
        assertThrows(IllegalArgumentException.class, () -> StringProcessor.repeatString("a", -1));
    }

    @Test
    void testCountOccurrences() {
        assertEquals(3, StringProcessor.countOccurrences("banana", "a"));
        assertEquals(0, StringProcessor.countOccurrences("banana", "z"));
        assertThrows(IllegalArgumentException.class, () -> StringProcessor.countOccurrences("banana", ""));
        assertThrows(IllegalArgumentException.class, () -> StringProcessor.countOccurrences("banana", null));
    }

    @Test
    void testReplaceNumbers() {
        assertEquals("один два три", StringProcessor.replaceNumbers("1 2 3"));
        assertEquals("abc", StringProcessor.replaceNumbers("abc"));
        assertEquals("одинодин два", StringProcessor.replaceNumbers("11 2"));
    }

    @Test
    void testRemoveEverySecondCharacter() {
        StringBuilder input = new StringBuilder("abcdef");
        StringProcessor.removeEverySecondCharacter(input);
        assertEquals("ace", input.toString());

        input = new StringBuilder("12345");
        StringProcessor.removeEverySecondCharacter(input);
        assertEquals("135", input.toString());
    }

    @Test
    void testReverseWords() {
        assertEquals(" dd cc bbb aaa", StringProcessor.reverseWords(" aaa bbb cc dd"));
        assertEquals("hello ", StringProcessor.reverseWords("hello "));
        assertEquals("", StringProcessor.reverseWords(""));
    }

    @Test
    void testReplaceHexWithDecimal() {
        assertEquals("Васе 16 лет", StringProcessor.replaceHexWithDecimal("Васе 0x00000010 лет"));
        assertEquals("Привет 255!", StringProcessor.replaceHexWithDecimal("Привет 0x000000FF!"));
        assertEquals("Нет чисел", StringProcessor.replaceHexWithDecimal("Нет чисел"));
    }
}

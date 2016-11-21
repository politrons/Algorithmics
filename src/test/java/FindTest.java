import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.primitives.Chars;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.String.format;
import static java.lang.String.valueOf;


/**
 * @author Pablo Perez
 */
public class FindTest {

    @Test
    public void findNumbersCharacter() {
        String text = "abc1ag5t3b12x";
        List<Character> characters = Chars.asList(text.toCharArray()).stream()
                .filter(Character::isAlphabetic)
                .collect(Collectors.toList());
        System.out.println(characters);
    }

    @Test
    public void findNumberOfWords() {
        String text = "this is a test result should be 8";
        int words = Chars.asList(text.toCharArray()).stream()
                .filter(Character::isWhitespace)
                .collect(Collectors.toList()).size() + 1;
        System.out.println(words);
    }

    @Test
    public void findDuplicateNumber(){
        int[] numbers = new int[]{1, 2, 5, 4, 3, 2};
        int highestNumber = numbers.length - 1;
        int total = IntStream.of(numbers).sum();
        int duplicate = total - (highestNumber*(highestNumber+1)/2);
        System.out.println(duplicate);
    }

    private  static Multimap<Character, Character> dupChars = ArrayListMultimap.create();

    @Test
    public void findDuplicateCharacter() {
        String text="abcagtbx";
        for (char c : text.toCharArray()){
            dupChars.put(c, c);
        }
        for (Character character : dupChars.keySet()) {
            if(dupChars.get(character).size() > 1){
                System.out.println(String.format("Character %s duplicated", character));
            }
        }
    }

    @Test
    public void findDuplicateWords() {
        String text="find duplicated words those words are duplicated here";
        final List<String> allWords = Arrays.asList(text.split(" "));
        Multimap<String, String> words = ArrayListMultimap.create();
        allWords.stream()
                .forEach(word-> words.put(word, word));
        final List<String> duplicates = words.asMap().entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(duplicates.toString());
    }

    @Test
    public void removeDuplicated() {
        List<Character> uniques = Chars.asList("abcagtbx".toCharArray()).stream()
                .distinct()
                .collect(Collectors.toList());
        StringBuilder builder = new StringBuilder();
        uniques.forEach(builder::append);
        System.out.println(builder.toString());

    }


    @Test
    public void findCenterOfArray() {
        int[] number = new int[]{5, 2, 8, 4, 1, 6, 7, 3, 9, 10};
        Arrays.sort(number);
        int centerNumber = number[number.length /  2];
        System.out.println(format("Center number %d", centerNumber));
        System.out.printf(valueOf(number.length /  2));
    }

}

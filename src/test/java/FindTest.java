import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.primitives.Chars;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.String.format;
import static java.lang.String.valueOf;


/**
 * @author Pablo Perez
 */
public class FindTest {

    /**
     * Find the number of alphanumeric character in the string and avoid the numerics
     */
    @Test
    public void findAlphabeticCharacters() {
        String text = "abc1ag5t3b12x";
        List<Character> characters = Chars.asList(text.toCharArray()).stream()
                .filter(Character::isAlphabetic)
                .collect(Collectors.toList());
        System.out.println(characters);
    }

    /**
     * Find the number of words in a sentence, it´s handy use Character class to check char type
     * In this case whitespace+1 give us the number of words.
     */
    @Test
    public void findNumberOfWords() {
        String text = "this is a test result should be 8.";
        int words = Chars.asList(text.toCharArray()).stream()
                .filter(Character::isWhitespace)
                .collect(Collectors.toList()).size() + 1;
        System.out.println(words);
    }

    @Test
    public void findNumberOfWordsEfficient() {
        String text = "this is a test result should be 8.";
        int words = text.chars().mapToObj(c -> (char) c)
                .filter(c -> c == 32)
                .collect(Collectors.toList()).size() + 1;
        System.out.println(words);
    }

    /**
     * Equation to find the number duplicated in the array
     */
    @Test
    public void findDuplicateNumber() {
        int[] numbers = new int[]{1, 2, 5, 4, 3, 2};
        int highestNumber = numbers.length - 1;
        int total = IntStream.of(numbers).sum();
        int duplicate = total - (highestNumber * (highestNumber + 1) / 2);
        System.out.println(duplicate);
    }

    /**
     * Multimap it´s always particular handy to search for duplicities, since it will create a collection of the values.
     */
    @Test
    public void findDuplicateCharacter() {
        Multimap<Character, Character> dupChars = ArrayListMultimap.create();
        String text = "abcagtbx";
        for (char c : text.toCharArray()) {
            dupChars.put(c, c);
        }
        List<String> duplicates = dupChars.asMap().entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1)
                .map(Map.Entry::getKey)
                .map(c -> String.valueOf(c.charValue()))
                .collect(Collectors.toList());
        System.out.println(duplicates);
    }

    /**
     * Similar example than before but instead an array of chars we have an array of words,
     * once we split up by whitespace
     */
    @Test
    public void findDuplicateWords() {
        String text = "find duplicated words those words are duplicated here";
        final List<String> allWords = Arrays.asList(text.split(" "));
        Multimap<String, String> words = ArrayListMultimap.create();
        allWords.forEach(word -> words.put(word, word));
        List<String> duplicates = words.asMap().entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(duplicates);
    }

    /**
     * In order to remove duplicate stream distinct operator do all the job for us.
     */
    @Test
    public void removeDuplicated() {
        String collect = "abcagtbx".chars().mapToObj(c -> (char) c)
                .distinct()
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println(collect);
    }

    /**
     * Easy enough right? side/2 it´ the middle nothing fancy
     */
    @Test
    public void findCenterOfArray() {
        int[] number = new int[]{5, 2, 8, 4, 1, 6, 7, 3, 9, 10};
        Arrays.sort(number);
        int centerNumber = number[number.length / 2];
        System.out.println(format("Center number %d", centerNumber));
        System.out.println(valueOf(number.length / 2));
    }

    /**
     * Using two streams we iter the first one and per item we emitt all items of the second
     * stream to filter if together sum 5
     */
    @Test
    public void findNumbersThanSumTogether5() {
        final List<Integer> numbers = Arrays.asList(1, 8, 2, 7, 5, 4, 3, 6);
        final List<Integer> sum5Numbers = numbers.stream()
                .flatMap(number -> numbers.stream()
                        .filter(number1 -> number + number1 == 5))
                .collect(Collectors.toList());
        System.out.println(sum5Numbers);
    }

    int maxValue = 0;
    int maxNumber = 0;

    @Test
    public void findTheMostUsedInteger() {
        Multimap<Integer, Integer> multimap = ArrayListMultimap.create();
        final List<Integer> numbers = Arrays.asList(1, 1, 2, 3, 2, 1, 3, 4, 3, 3);
        numbers.forEach(number -> multimap.put(number, number));
        multimap.asMap().forEach((key, value) -> {
            if (value.size() > maxValue) {
                maxValue = value.size();
                maxNumber = key;
            }
        });
        System.out.println(maxNumber);
    }

    @Test
    public void findIfIsARotateArray() {
        boolean rotated = true;
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 8);
        final List<Integer> numbers1 = Arrays.asList(8, 6, 5, 4, 3, 2, 1);
        for (int i = 0; i < numbers.size(); i++) {
            if (!Objects.equals(numbers.get(i), numbers1.get(numbers.size() - i - 1))) {
                rotated = false;
            }
        }
        System.out.println(rotated);

    }

    @Test
    public void findUniqueElement() {
        Multimap<Integer, Integer> map = ArrayListMultimap.create();
        final List<Integer> numbers = Arrays.asList(1, 1, 3, 4, 4, 6, 6, 5);
        numbers.forEach(number -> map.put(number, number));
        final List<Integer> uniques = map.asMap().entrySet().stream()
                .filter(entry -> entry.getValue().size() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(uniques);
    }

    @Test
    public void searchBinarySearch() {
        int number[] = {10, 20, 30, 40, 50, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(searchBinarySearch(number, 40));
    }

    public int searchBinarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            // If the middle element matches the target, simply return middle Index.
            if (nums[middle] == target)
                return middle;
            // If the sequence, low to mid is increasing.
            if (nums[low] <= nums[middle]) {
                // As my low to mid seq is increasing, and If the target is bigger than mid, then I cannot
                //have my target b/w low to mid, process right half. Similar case for if the target is
                // lesser than low.
                if (target < nums[low] || target > nums[middle])
                    low = middle + 1;
                // else process the left half.
                else
                    high = middle - 1;
            }
            // If the sequence mid to hi is increasing.
            else {
                // As the sequcence mid to Hi is increasing, and If the  target is bigger than Hi or
                // lesser than Mid,  It cannot be in the right half. so Process left.
                if (target > nums[high] || target < nums[middle])
                    high = middle - 1;
                // Else process right.
                else
                    low = middle + 1;
            }
        }
        // Element not found.
        return -1;
    }



}

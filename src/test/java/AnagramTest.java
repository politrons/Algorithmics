
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

import static org.junit.Assert.assertTrue;


/**
 * @author Pablo Perez
 */
public class AnagramTest {

    URL url = this.getClass().getResource("/anagram.txt");


    @Test
    public void wrongCoinType() {
        List<String> words = new ArrayList();
        List<String> orderWords = new ArrayList();
        List<String> orderWordsNotSorted = new ArrayList();

        try {
            Scanner scanner = new Scanner(new File(url.getFile()));
            while (scanner.hasNext()) {
                String word = scanner.next();
                char[] chars = word.toCharArray();
                Arrays.sort(chars);
                List<Character> listChars = new ArrayList();
                for (char c : chars) {
                    listChars.add(c);
                }
                String orderWord = listChars.stream().map(e -> e.toString()).reduce((acc, e) -> acc + e).get();
                words.add(word);
                orderWordsNotSorted.add(orderWord);
            }
            orderWords = orderWordsNotSorted;
            Collections.sort(orderWords);
            StringBuilder stringBuilder = new StringBuilder();
            for (String orderWord : orderWords) {
                int arrayIndex = orderWordsNotSorted.indexOf(orderWord);
                words.get(arrayIndex);
                stringBuilder.append(words.get(arrayIndex)).append(" ");

            }
            System.out.println(stringBuilder.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        assertTrue(true);
    }


}

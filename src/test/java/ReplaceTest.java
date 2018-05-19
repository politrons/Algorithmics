import org.junit.Test;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;


/**
 * @author Pablo Perez
 */
public class ReplaceTest {


    @Test
    public void replaceTest() {
        String sentence = "thIs Is a test of replacement";
        char old = 73;
        char newOne = 105;
        assertTrue("this is a test of replacement".equals(replaceCharacter(sentence, old, newOne)));
    }


    private String replaceCharacter(String str, char old, char newOne) {
        String collect = str.chars().mapToObj(c -> (char) c)
                .filter(c -> c == old)
                .map(c -> str.replace(c, newOne))
                .collect(Collectors.joining());
        return collect;
    }

    @Test
    public void replaceCapitalCase() {
        String text = "This is a Test to RePlace CaPitaL CASES";
        StringBuilder builder = new StringBuilder();
        text.chars().mapToObj(c -> (char) c)
                .map(c -> {
                    if (Character.isUpperCase(c)) {
                        return Character.toLowerCase(c);
                    }
                    return c;
                }).forEach(builder::append);
        System.out.println(builder.toString());
    }


}

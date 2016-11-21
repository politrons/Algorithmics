import com.google.common.primitives.Chars;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;


/**
 * @author Pablo Perez
 */
public class ReplaceTest {


    @Test
    public void replaceTest() {
        String word = "this is a test of replacement";
        char old = 105;
        char newOne = 73;
        assertTrue("thIs Is a test of replacement".equals(replaceCharacter(word, old, newOne)));
    }


    public String replaceCharacter(String str, char old, char newOne) {
        return Chars.asList(str.toCharArray()).stream()
                .filter(c -> c == old)
                .map(c ->
                        str.replace(c, newOne))
                .findFirst().get();
    }

    @Test
    public void replaceCapitalCase() {
        String text = "This is a Test to RePlace CaPitaL CASES";
        List<Character> chars = Chars.asList(text.toCharArray()).stream()
                .map(c -> {
                    if (Character.isUpperCase(c)) {
                        return Character.toLowerCase(c);
                    }
                    return c;
                }).collect(Collectors.toList());
        StringBuilder builder = new StringBuilder();
        chars.forEach(builder::append);
        System.out.println(builder.toString());
    }


}

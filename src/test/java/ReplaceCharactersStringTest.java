import com.google.common.primitives.Chars;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


/**
 * @author Pablo Perez
 */
public class ReplaceCharactersStringTest {


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


}

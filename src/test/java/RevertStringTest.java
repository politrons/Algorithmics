
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


/**
 * @author Pablo Perez
 */
public class RevertStringTest {


    @Test
    public void oldFashionRevert() {
        String word="this is a test";
        char[] chars = word.toCharArray();
        StringBuilder revertWord =  new StringBuilder();
        for(int i= chars.length ; i > 0 ; i--){
            char c = chars[i-1];
            revertWord.append(String.valueOf(c));
        }
        assertTrue("tset a si siht".equals(revertWord.toString()));
    }

    @Test
    public void newFashionRevert() {
        String word="this is a test";
        assertTrue("tset a si siht".equals(new StringBuilder(word).reverse().toString()));
    }


}

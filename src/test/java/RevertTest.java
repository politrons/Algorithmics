
import org.junit.Test;

import static org.junit.Assert.assertTrue;


/**
 * @author Pablo Perez
 */
public class RevertTest {


    @Test
    public void oldFashionRevert() {
        String word="this is a test";
        char[] chars = word.toCharArray();
        final StringBuilder revertWord =  new StringBuilder();
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

    @Test
    public void reverseNumber(){
        int number = 17868;
        int reverse = 0;
        while(number != 0){
            reverse = (reverse*10)+(number%10);
            number = number/10;
        }
        System.out.println(reverse);
    }


}

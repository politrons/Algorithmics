import org.junit.Test;

import java.util.stream.IntStream;


/**
 * @author Pablo Perez
 */
public class ReverseNumberTest {


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

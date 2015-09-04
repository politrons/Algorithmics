import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;


/**
 * @author Pablo Perez
 */
public class CalcCenterPositionOfArrayTest {


    @Test
    public void oldFashionRevert() {
        int[] number = new int[]{5, 2, 8, 4, 1, 6, 7, 3, 9, 10};
        Arrays.sort(number);
        StringBuilder stringNumber = new StringBuilder();
        for (int i : number) {
            stringNumber.append(i);
        }
        System.out.printf(String.valueOf(stringNumber.toString().length() /  2));
    }


}

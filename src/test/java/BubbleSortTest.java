import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * @author Pablo Perez
 */
public class BubbleSortTest {


    @Test
    public void descendingSort() {
        int[] numbers = {5, 3, 6, 1, 2};
        int swap;
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int k = 0; k < numbers.length - 1; k++) {
                if (numbers[k] > numbers[k + 1]) {
                    swap = numbers[k];
                    numbers[k] = numbers[k + 1];
                    numbers[k + 1] = swap;
                }
            }
        }
        assertThat("[1,2,3,5,6]", is(Arrays.toString(numbers).trim()));

    }


}

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;


/**
 * @author Pablo Perez
 */
public class FindDuplicateNumberTest {


    @Test
    public void findDuplicateNumber(){
        int[] numbers = new int[]{1, 2, 5, 4, 3, 2};
        int highestNumber = numbers.length - 1;
        int total = IntStream.of(numbers).sum();
        int duplicate = total - (highestNumber*(highestNumber+1)/2);
        System.out.println(duplicate);
    }
}

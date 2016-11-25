import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author Pablo Perez
 */
public class PrimeNumbers {


    /**
     * Prime numbers. Numbers that only are divs from 1 and them self.
     * Here we just need to get the dividend and if it´s 0 we increase the counter.
     * So then only prime numbers will be divs by a max of 2.
     */
    @Test
    public void primeNumber() {
        List<Integer> digits = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> numbers = Arrays.asList(5, 2, 8, 4, 1, 6, 7, 3, 9, 10, 11, 12, 13, 14);
        List<Integer> primes = new ArrayList<>();
        for (Integer number : numbers) {
            int count = 0;
            for (Integer digit : digits) {
                if (number % digit == 0) {
                    count++;
                }
            }
            if (count <= 2) {
                primes.add(number);
            }
        }
        System.out.println("Primes:" + primes);
    }

}

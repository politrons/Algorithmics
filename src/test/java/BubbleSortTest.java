import org.junit.Test;

import java.util.Arrays;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.*;
import java.util.*;

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

    @Test
    public void insertionSort() {
        insertionSort(new int[]{7, 4, 3, 5, 6, 2});
    }

    private void insertionSort(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = 0; j < A.length - 1; j++) {
                if (A[j] > A[j + 1]) {
                    int tmp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = tmp;
                }
            }
        }

        for (int n : A) {
            System.out.print(n + " ");
        }
    }
}

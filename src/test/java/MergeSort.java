import org.junit.Test;

public class MergeSort {

    private int[] tempMergArr;
    private int length;

    @Test
    public void main() {
        int[] inputArr = {45, 23, 11, 89, 77, 98, 4, 28, 65, 43};

        this.length = inputArr.length;
        this.tempMergArr = new int[length];
        divideParts(0, length - 1, inputArr);

        for (int i : inputArr) {
            System.out.print(i);
            System.out.print(" ");
        }
    }


    private void divideParts(int lowerIndex, int higherIndex, int[] array) {

        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            divideParts(lowerIndex, middle, array);
            // Below step sorts the right side of the array
            divideParts(middle + 1, higherIndex, array);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex, array);
        }
    }

    private void mergeParts(int lowerIndex, int middle, int higherIndex, int[] array) {

        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }

    }
}
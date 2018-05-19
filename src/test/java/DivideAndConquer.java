public class DivideAndConquer {

    public static void main(String[] args) {

        int[] array = {3, 0, 0, 1, 0, 1, 3, 2, 0, 0, 0, 1, 2};
        System.out.println(ZeroCounter(array));
    }

    private static int ZeroCounter(int[] v) {
        if (v.length == 0 || v.length == 1)
            return 0;
        else
            return ZeroCounter(v, 1, v.length);
    }

    private static int ZeroCounter(int[] array, int from, int to) {
        int halfArraySize, result, leftHalf, rightHalf;
        if (from >= to)
            return 0;
        else {
            //Divide
            halfArraySize = getHalfArraySize(from, to);
            leftHalf = ZeroCounter(array, from, halfArraySize);
            rightHalf = ZeroCounter(array, halfArraySize + 1, to);
            //Conquer
            result = leftHalf + rightHalf;
            if ((halfArraySize < array.length - 1) && areConsecutiveValuesEquals(array, halfArraySize) && (array[halfArraySize] == 0))
                result++;

            return result;
        }

    }

    private static boolean areConsecutiveValuesEquals(int[] array, int halfArraySize) {
        return array[halfArraySize] == array[halfArraySize + 1];
    }

    private static int getHalfArraySize(int from, int to) {
        return (from + to) / 2;
    }

}


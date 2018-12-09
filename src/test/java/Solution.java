import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution {


    @Test
    public void runSolution() {
        assertEquals (findMinimumNumberOfCameras(1, new int[]{1, 2, 3, 4, 5}), 2);
        assertEquals(findMinimumNumberOfCameras(2, new int[]{2, 4, 5, 6, 7, 9, 11, 12}), 3);//4, 9 and 12
        assertEquals(findMinimumNumberOfCameras(10, new int[]{1, 15, 30, 40, 50}), 3);
    }

    /**
     * Max camera distance = (cameraRange * 2( left+right range))) + 1(middle) (left <- middle -> right)
     */
    public static int findMinimumNumberOfCameras(int cameraRange, int[] parkingSpaces) {
        int cameras = 1;
        int maxCameraRange = (cameraRange * 2) + 1;
        for (int x = 0; x < parkingSpaces.length; x++) {
            for (int y = x; y < parkingSpaces.length; y++) {
                int actualRange = parkingSpaces[y] - parkingSpaces[x];
                if (actualRange >= maxCameraRange) {
                    x = y - 2;
                    cameras += 1;
                    break;
                }
            }
        }
        return cameras;
    }

}

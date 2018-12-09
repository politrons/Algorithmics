import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution {


    @Test
    public void runSolution() {
        assertEquals(findMinimumNumberOfCameras(3, new int[]{1, 2, 3, 4, 7, 9, 12, 25, 26}), 3);//4,9,25
        assertEquals(findMinimumNumberOfCameras(1, new int[]{1, 2, 3, 4, 5}), 2);//camera 2 and 4
        assertEquals(findMinimumNumberOfCameras(2, new int[]{2, 4, 5, 6, 7, 9, 11, 12}), 3);//4, 9 and 12
        assertEquals(findMinimumNumberOfCameras(10, new int[]{1, 15, 30, 40, 50}), 3);
        assertEquals(findMinimumNumberOfCameras(5, new int[]{1, 15, 30, 40, 50}), 5);
        assertEquals(findMinimumNumberOfCameras(10, new int[]{100}), 1);
        assertEquals(findMinimumNumberOfCameras(100, new int[]{1}), 1);
    }

    /**
     * For every iteration of first loop [X] we calculate the [CameraParkingSpace] as the max threshold for [X]
     * * CameraParkingSpace =  left+right -> (cameraRange * 2) + [parkingSpaces[x]]
     * Then we start the next loop [Y] in [X + 1] since there's no point to calculate distance in the same parkingSpace.
     * Then we have two boolean conditions to
     */
    public static int findMinimumNumberOfCameras(int cameraRange, int[] parkingSpaces) {
        int cameras = 1;
        for (int x = 0; x < parkingSpaces.length; x++) {
            int cameraParkingSpace = (cameraRange * 2) + parkingSpaces[x];
            for (int y = x + 1; y < parkingSpaces.length; y++) {
                boolean maxRangeOutOfScope = parkingSpaces[y] > cameraParkingSpace;
                boolean previousParkingSpaceCannotReachNext = parkingSpaces[y] > (parkingSpaces[y - 1] + cameraRange);
                if (maxRangeOutOfScope || previousParkingSpaceCannotReachNext) {
                    x = y - 1;
                    cameras += 1;
                    break;
                }
            }
        }
        return cameras;
    }

}

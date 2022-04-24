import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class Rod {

    private HashMap<Integer, Integer> segmentValues;
    public Rod() {
        segmentValues = new HashMap<>();

        segmentValues.put(0, 0);
        segmentValues.put(1, 1);
        segmentValues.put(2, 5);
        segmentValues.put(3, 8);
        segmentValues.put(4, 9);
        segmentValues.put(5, 10);
        segmentValues.put(6, 17);
        segmentValues.put(7, 17);
        segmentValues.put(8, 20);
        segmentValues.put(9, 24);
        segmentValues.put(10, 30);

    }

    public int rodRequestReceiver(int totalRodLength) {

        int finalMax = 0;

        while(totalRodLength != 0) {
            if(totalRodLength > 10) {
            finalMax += calculateMaximumWorth(10);
            totalRodLength -= 10;
            }
            else {
                finalMax += calculateMaximumWorth(totalRodLength);
                totalRodLength = 0;
            }
        }
        return finalMax;
    }

    public int calculateMaximumWorth(int localRodLength) {

        int localMax = 0;

        //let's say the call is 15

        for(int i = 0; i < localRodLength; i++) {
            if(segmentValues.get(i) + segmentValues.get(localRodLength-i) > localMax) {
                localMax = segmentValues.get(i) + segmentValues.get(localRodLength-i);
            }
        }

        return localMax;
    }
}

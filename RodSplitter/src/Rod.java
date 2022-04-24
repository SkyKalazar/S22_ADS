import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class Rod {

    private static final Map<Integer, Integer> segmentValues = Map.ofEntries(entry(1,7), entry(2,5),
            entry(3,8), entry(4,9), entry(5,10), entry(6,17), entry(7,17), entry(8,20),
            entry(9,24), entry(10,30));

    public Rod() {

    }

    public int calculateMaximumWorth(int rodLength) {
        int max = 0;

        while(rodLength != 0) {
            int targetSegment = rodLength%10;
            max += segmentValues.get(targetSegment);
            rodLength -= targetSegment;
        }
        return max;
    }
}

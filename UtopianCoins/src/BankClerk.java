import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BankClerk {

    private ArrayList<Integer> denominations;
    private HashMap<Integer, Integer> bestExchange;

    public BankClerk() {
        denominations = new ArrayList<>(Arrays.asList(1, 7, 10, 22));
        bestExchange = new HashMap<>();
    }

    // Returns the smallest number of coins to which the capital can be exchanged to
    public int numberOfCoinsAsChange(int capital) {
        int optimal = capital-1;

        if(bestExchange.get(capital) != null) {
            optimal = bestExchange.get(capital);
        }
        else {
            for (int i = 0; i < denominations.size(); i++) {
                if (denominations.get(i) <= capital) {
                    int count = numberOfCoinsAsChange(capital - denominations.get(i));
                    if (count < optimal) {
                        optimal = count;
                        bestExchange.put(capital, optimal);
                    }
                }
            }
        }

        return ++optimal;
    }

}

import java.util.ArrayList;
import java.util.Arrays;

public class BankClerk {

    private ArrayList<Integer> denominations;

    public BankClerk() {
        denominations = new ArrayList<>(Arrays.asList(1, 7, 10, 22));
    }

    // Returns the smallest number of coins to which the capital can be exchanged to
    public int numberOfCoinsAsChange(int capital) {
        // Let us try with 15
        int count = 0;

        if(denominations.contains(capital)) {
            return capital;
        }

        while(capital != 0) {
            for(int i = 0; i < denominations.size(); i++) {

            }
            capital -= recursiveExchanger(capital);
            count++;
        }

        return count;
    }

    private int recursiveExchanger(int capital) {


        return 0;
    }
}

import java.util.Calendar;

public class FibonacciMain {

    public static void main(String[] args) {

        int sequenceTarget = 50;

        fibonacciIterative(sequenceTarget);

        double start = Calendar.getInstance().getTimeInMillis();
        fibonacciRecursive(sequenceTarget);
        double end = Calendar.getInstance().getTimeInMillis();
        double difference = end - start;
        System.out.println("Recursive " + difference);

    }

    public static void fibonacciIterative(int sequenceNumber) {

        double num1 = 0;
        double num2 = 1;
        double result;

        double start = Calendar.getInstance().getTimeInMillis();

        for(int i = 0; i < sequenceNumber; i++) {

            result = num1 + num2;
            num1 = num2;
            num2 = result;
        }

        double end = Calendar.getInstance().getTimeInMillis();
        double difference = end - start;
        System.out.println("Iterative " + difference);
    }

    public static int fibonacciRecursive(int sequenceNumber) {
        if(sequenceNumber <= 1) {
            return sequenceNumber;
        }
        return fibonacciRecursive(sequenceNumber-1) + fibonacciRecursive(sequenceNumber-2);

    }
}

package Launch;

import Token.Token;
import Token.Operand;
import Token.Operator;
import Visitor.Client;
import Token.Operation;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Client c = new Client();

        ArrayList<Token> tokens = new ArrayList<>();

        Operand num1 = new Operand(10);
        Operand num2 = new Operand(25);

        Operator op1 = new Operator(Operation.Addition);

        Operand num3 = new Operand(7);

        Operator op2 = new Operator(Operation.Subtraction);

        tokens.add(num1);
        tokens.add(num2);
        tokens.add(op1);
        tokens.add(num3);
        tokens.add(op2);

        System.out.println(c.evaluateExpression(tokens));
    }
}

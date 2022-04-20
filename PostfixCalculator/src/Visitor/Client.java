package Visitor;

import Token.Token;

import java.util.ArrayList;

public class Client {

    private CalculatorVisitor calculatorVisitor;

    public Client() {
        calculatorVisitor = new CalculatorVisitor();
    }

    public int evaluateExpression(ArrayList<Token> tokenList) {

        for(Token t : tokenList) {
            t.accept(calculatorVisitor);
        }

        return calculatorVisitor.getResult();
    }
}

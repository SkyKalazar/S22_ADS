package Visitor;

import Stack.LinkedStack;
import Token.Token;
import Token.Operand;
import Token.Operator;

import java.nio.charset.MalformedInputException;

public class CalculatorVisitor implements Visitor, Calculator {

    private LinkedStack<Token> tokenStack;

    public CalculatorVisitor() {
        tokenStack = new LinkedStack<Token>();
    }

    private void pushOperand(Operand operand) {
        tokenStack.push(operand);
    }

    private void performOperation(Operator operator) throws MalformedInputException {
        try {
            Operand a = (Operand)tokenStack.pop();
            Operand b = (Operand)tokenStack.pop();

            int in2 = a.getValue();
            int in1 = b.getValue();

            int result = switch (operator.getOperation()) {
                case Multiplication -> in1 * in2;
                case Addition -> in1 + in2;
                case Division -> in1 / in2;
                case Subtraction -> in1 - in2;
            };

            ;
            tokenStack.push(new Operand(result));
        }
        catch (Exception e) {
            throw new MalformedInputException(100);
        }

    }


    @Override
    public void visit(Operand operand) {
        pushOperand(operand);
    }

    @Override
    public void visit(Operator operator) {
        try {
            performOperation(operator);
        }
        catch (MalformedInputException e) {
            System.out.println("Illegal operation");
        }

    }

    @Override
    public int getResult() {
        try {
            Operand result = (Operand) tokenStack.pop();
            return result.getValue();
        }
        catch (Exception e) {
            System.out.println("Well, something went wrong");
            return -100;
        }
    }
}

import Stack.LinkedStack;
import Token.Token;
import Token.Operand;
import Token.Operator;
import Token.Operation;
import Visitor.CalculatorVisitor;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private CalculatorVisitor visitor;
    private LinkedStack<Token> stack;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        visitor = new CalculatorVisitor();
        stack = new LinkedStack<Token>();

        visitor.visit(new Operand(30));
        visitor.visit(new Operand(15));


    }
    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test void emptyStackThrowsEmptyStackException() {
        assertThrows(EmptyStackException.class, () -> stack.pop());
    }

    @Test void multiplyingTwoNumbersFromTheStack() {

        visitor.visit(new Operator(Operation.Multiplication));

        assertEquals(450, visitor.getResult());
    }

    @Test void addingTwoNumbersFromTheStack() {

        visitor.visit(new Operator(Operation.Addition));

        assertEquals(45, visitor.getResult());
    }

    @Test void subtractingTwoNumbersFromTheStack() {

        visitor.visit(new Operator(Operation.Subtraction));

        assertEquals(15, visitor.getResult());
    }

    @Test void dividingTwoNumbersFromTheStack() {

        visitor.visit(new Operator(Operation.Division));

        assertEquals(2, visitor.getResult());
    }

}
package Visitor;

import Token.Operand;
import Token.Operator;

public interface Visitor {

    void visit(Operand operand);

    void visit(Operator operator);
}

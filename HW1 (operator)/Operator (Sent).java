// Name: Ahmet Kaan  
// Surname: Demirci
// Student ID: 21050111031
package hw1;

enum OperatorType {
    Add, Subtract, Multiply, Divide, Value;

    String symbol() {
        switch (this) {
            case Add:
                return "+";
            case Subtract:
                return "-";
            case Multiply:
                return "*";
            case Divide:
                return "/";
            default:
                throw new IllegalArgumentException("invalid operator type");
        }
    }
}

public class Operator {

    final double value;
    final OperatorType operatorType;
    final Operator leftChild;
    final Operator rightChild;

    Operator(double value) {
        // student code
        this.value = value;
        this.operatorType = OperatorType.Value;
        this.leftChild = null;
        this.rightChild = null;
    }

    Operator(OperatorType operatorType, Operator leftChild, Operator rightChild) {
        if (operatorType == OperatorType.Value) {
            throw new IllegalArgumentException("OperatorType must: 'Add, Subtract, Multiply, or Divide'");
        }
        this.operatorType = operatorType;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.value = 0.0;
    }

    boolean isLeaf() {
        return operatorType == OperatorType.Value;
    }

    double getValue() {
        if (this.isLeaf()) {
            return value;
        } else {
            switch (operatorType) {
                case Add:
                    return leftChild.getValue() + rightChild.getValue();
                case Subtract:
                    return leftChild.getValue() - rightChild.getValue();
                case Multiply:
                    return leftChild.getValue() * rightChild.getValue();
                case Divide:
                    return leftChild.getValue() / rightChild.getValue();
                default:
                    throw new IllegalArgumentException("invalid operator type");
            }
        }
    }

    @Override
    public String toString() {
        if (this.isLeaf()) {
            return Double.toString(value);
        } else {
            return "(" + leftChild.toString() + " " + operatorType.symbol() + " " + rightChild.toString() + ")";
        }
    }

}

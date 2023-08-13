// Name: 
// Surname:
// Student ID:

enum OperatorType {
	Add, Subtract, Multiply, Divide, Value;
	
	String symbol() {
		switch (this) {
		// student code
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
	}
	
	Operator(OperatorType operatorType, Operator leftChild, Operator rightChild) {
		// student code
	}	
	
	boolean isLeaf() {
		// student code
	}
	
	double getValue() {
		// student code
	}
		
	@Override
	public String toString() {
		// student code
	}

}

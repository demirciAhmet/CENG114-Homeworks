
public class IntegerProcess extends Process<Integer> {
    
    public IntegerProcess() {
        super(0);
    }
    
    @Override
    protected Integer add(Integer a, Integer b) {
        return a + b;
    }

    @Override
    protected Integer subtract(Integer a, Integer b) {
        return a - b;
    }

    @Override
    protected Integer multiply(Integer a, Integer b) {
        return a * b;
    }

    @Override
    protected int distanceFunction(Integer num1, Integer num2) {
        return Math.abs(num1 - num2);
    }

    @Override
    protected String showContent(String str, String op, Integer num) {
        if (str == null) {
            if (num < 0) {
                return "(" + num + ")";
            }
            return "" + num;
        }
        if (num < 0) {
            return ("(" + str + op + "(" + num + ")" + ")");
        }
        return ("(" + str + op + num + ")");
    }
}   
/*Group members:

Osman Oğuz Erol
22050111048

Mehmet Emre Cebeci
21050111037

Ahmet Kaan Demirci
21050111031

*/
abstract class Process<T> {
	
    protected abstract T add(T a, T b);
    protected abstract T subtract(T a, T b);
    protected abstract T multiply(T a, T b);
    protected abstract int distanceFunction(T a, T b);
    protected abstract String showContent(String str, String op, T num);

    private T bestValue;
    private final T VALUE;
    private String result;
    private boolean isFirstRun = true;
    
    public Process(T baseValue){
        this.bestValue = baseValue;
        this.VALUE = baseValue;
    }
    
    public Process(T VALUE, T bestValue){
        this.bestValue = bestValue;
        this.VALUE = VALUE;
    }
    
    public void rSolver(T[] input, T target) {
        
        boolean[] isUsed = new boolean[input.length];
        
        if (rSolver(input, VALUE, target, isUsed, null)){
            System.out.println("The desired value has been found!");
        } else {
            System.out.println("The closest value has been found!");
        }
        System.out.println(result);
    }
    
    private boolean rSolver(T[] input, T currentValue, T targetValue, boolean[] isUsed, String currentOutput) {
        
        if (isFirstRun){
            bestValue = input[0];
            isFirstRun = false;
        }
        
        if (currentOutput != null && currentValue.equals(targetValue)) {
            bestValue = currentValue;
            result = currentOutput + " = " + currentValue;
            return true;
        }

        for (int i = 0; i < input.length; i++) {
            
            if (isUsed[i]) {
                continue;
            }

            isUsed[i] = true;
            
            if (currentOutput == null) {
                if (rSolver(input, add(currentValue, input[i]), targetValue, isUsed, "" + input[i])) {
                    return true;
                }
            } else {
                if (rSolver(input, add(currentValue, input[i]), targetValue, isUsed, showContent(currentOutput, " + ", input[i]))) {
                    return true;
                }

                if (rSolver(input, subtract(currentValue, input[i]), targetValue, isUsed, showContent(currentOutput, " - ", input[i]))) {
                    return true;
                }

                if (rSolver(input, multiply(currentValue, input[i]), targetValue, isUsed, showContent(currentOutput, " * ", input[i]))) {
                    return true;
                }

            }
            
            isUsed[i] = false;
            
        }
        
        if (currentOutput != null && distanceFunction(bestValue, targetValue) >= distanceFunction(currentValue, targetValue)) {
            bestValue = currentValue;
            result = currentOutput + " = " + currentValue;
        }
        
        return false;

    }
	
}

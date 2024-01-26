public class Test {
    public static void main(String[] args) {
        
        IntegerProcess integerProcess = new IntegerProcess();
        StringProcess stringProcess = new StringProcess();
        ColorProcess colorProcess = new ColorProcess();

        //INTEGER TESTS
        System.out.println("");
        System.out.println("-------------------INTEGER TESTS---------------------");
        System.out.println("");
        Integer[] integers1 = {3, -2};
        integerProcess.rSolver(integers1, 0);
        
        System.out.println("");
        Integer[] integers3 = {32, 1321, -65, -544, -1234 , 121};
        integerProcess.rSolver(integers3, 999999);
        
        System.out.println("");
        Integer[] integers2 = {-5, 7, -2, 3, -2, 2, -33, 5, -7, 86, 2, -34, 8, -739, 0, 3, -45, -3, 343};
        integerProcess.rSolver(integers2, 79);
        
        //STRING TESTS
        System.out.println("");
        System.out.println("-------------------STRING TESTS---------------------");
        System.out.println();
        String[] strings1 = {"L", "A", "E", "H", "R", "M"};
        stringProcess.rSolver(strings1, "AHMET");
        
        System.out.println("");
        String[] strings2 = {"G", "R", "L", "Y", "T", "S", "A"};
        stringProcess.rSolver(strings2, "GALATASARAY");
        
        System.out.println("");
        String[] strings3 = { "BOLLUK", "R", "U", "LUK", "GELIBOLU"};
        stringProcess.rSolver(strings3, "GELIN");
        
        /*
        Black: RGB(0,0,0)
        White: RGB(255,255,255)
        Red: RGB(255,0,0)
        Green: RGB(0,255,0)
        Blue: RGB(0,0,255)
        Yellow: RGB(255,255,0)
        Magenta: RGB(255,0,255)
        Cyan: RGB(0,255,255)
        */
        
        //COLOR TESTS
        System.out.println("");
        System.out.println("-------------------COLOR TESTS---------------------");
        System.out.println("");
        Color[] colors1 = {Color.RED, Color.GREEN};
        colorProcess.rSolver(colors1, Color.WHITE);
        
        System.out.println("");
        Color[] colors2 = {Color.MAGENTA, Color.GREEN, Color.BLUE, Color.CYAN, Color.YELLOW};
        colorProcess.rSolver(colors2, Color.WHITE);
        
        System.out.println("");
        Color[] colors3 = {Color.MAGENTA, Color.CYAN, Color.GREEN};
        colorProcess.rSolver(colors3, Color.YELLOW);
        
        
    }
}

public class ColorProcess extends Process<Color> {

    public ColorProcess() {
        super(Color.BLACK);
    }
    
    @Override
    protected Color add(Color a, Color b) {
        int red = Math.min(255, a.getRed() + b.getRed());
        int green = Math.min(255, a.getGreen() + b.getGreen());
        int blue = Math.min(255, a.getBlue() + b.getBlue());
        return new Color(red, green, blue);
    }

    @Override
    protected Color subtract(Color a, Color b) {
        int red = Math.max(0, a.getRed() - b.getRed());
        int green = Math.max(0, a.getGreen() - b.getGreen());
        int blue = Math.max(0, a.getBlue() - b.getBlue());
        return new Color(red, green, blue);
    }

    @Override
    protected Color multiply(Color a, Color b) {
        int red = Math.min(255, (a.getRed() * b.getRed()));
        int green = Math.min(255, (a.getGreen() * b.getGreen()));
        int blue = Math.min(255, (a.getBlue() * b.getBlue()));
        return new Color(red, green, blue);
    }

    @Override
    protected int distanceFunction(Color a, Color b) {
        int redDiff = a.getRed() - b.getRed();
        int greenDiff = a.getGreen() - b.getGreen();
        int blueDiff = a.getBlue() - b.getBlue();
        return Math.abs(redDiff) + Math.abs(greenDiff) + Math.abs(blueDiff);
    }

    
    @Override
    protected String showContent(String str, String op, Color color) {
        if (str == null) {
            return color.toString();
        }
        return "(" + str + op + color + ")";
    }
}

class Color {

    static final Color BLACK = new Color(0, 0, 0);
    static final Color WHITE = new Color(255, 255, 255);
    static final Color RED = new Color(255, 0, 0);
    static final Color GREEN = new Color(0, 255, 0);
    static final Color BLUE = new Color(0, 0, 255);
    static final Color YELLOW = new Color(255, 255, 0);
    static final Color MAGENTA = new Color(255, 0, 255);
    static final Color CYAN = new Color(0, 255, 255);

    private int red;
    private int green;
    private int blue;

    Color(int red, int green, int blue) {
        this.red = round(red);
        this.green = round(green);
        this.blue = round(blue);
    }

    protected int getRed() {
        return red;
    }

    protected int getGreen() {
        return green;
    }

    protected int getBlue() {
        return blue;
    }
    private int round(int value) {

        if (value > 255 / 2) {
            return 255;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        if (this.equals(BLACK)) {
            return "BLACK";
        } else if (this.equals(WHITE)) {
            return "WHITE";
        } else if (this.equals(RED)) {
            return "RED";
        } else if (this.equals(GREEN)) {
            return "GREEN";
        } else if (this.equals(BLUE)) {
            return "BLUE";
        } else if (this.equals(YELLOW)) {
            return "YELLOW";
        } else if (this.equals(MAGENTA)) {
            return "MAGENTA";
        } else if (this.equals(CYAN)) {
            return "CYAN";
        } else {
            return "not supported color";
        }
    }
    @Override
    public boolean equals(Object o) {
        if (o == this){
            return true;
        } else {
            if (o instanceof Color){
                Color color = (Color) o;
                return red == color.red && green == color.green && blue == color.blue;
            }
        }
        return false;
    }
}
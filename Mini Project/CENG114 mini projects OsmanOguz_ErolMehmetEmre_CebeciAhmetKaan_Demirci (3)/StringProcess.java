
public class StringProcess extends Process<String> {

    public StringProcess() {
        super("");
    }

    @Override
    protected String add(String a, String b) {
        return a + b;
    }

    @Override
    protected String subtract(String a, String b) {
        
        if (a.contains(b)) {
            int index = a.lastIndexOf(b);
            String newA = a.substring(0, index) + a.substring(index + b.length());
            return newA;
        } else {
            return a;
        }
        
    }

    @Override
    protected String multiply(String a, String b) {
        
        String newA = "";
        for (int i = 0; i < a.length(); i++) {
            newA += a.charAt(i);
            newA += b;
        }
        return newA;

    }

    @Override
    protected int distanceFunction(String a, String b) {
        int n1 = a.length();
        int n2 = b.length();
        int n = Math.max(n1, n2);

        int distance = 0;
        for (int i = 0; i < n; i++) {
            char ch1 = (i < n1 ? a.charAt(i) : ' ');
            char ch2 = (i < n2 ? b.charAt(i) : ' ');

            distance += Math.abs(ch1 - ch2);
        }

        return distance;
    }

    @Override
    protected String showContent(String str, String op, String num) {
        if (str == null) {
            return num;
        }
        return ("(" + str + op + num + ")");
    }


}
package algo;

public class ArraysAndStrings {

    public static String stringCompress(String x) {
        StringBuilder result = new StringBuilder();

       int count = 0;
        
        for (int i = 0; i < x.length(); i++) {
            count++;
            
            if (i + 1 == x.length() || x.charAt(i) != x.charAt(i + 1)) {
                result.append(x.charAt(i));
                result.append(count);
                count = 0;
            }

        }
        
        if (notsmaller(result.length(), x.length())) {
            return x;
        }
        
        return result.toString();
    }

    private static boolean notsmaller(int x, int y) {
        return x >= y;
    }
    
}

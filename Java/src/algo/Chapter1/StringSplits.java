package algo.Chapter1;

public class StringSplits {

    public static String[] splitWhiteSpaces(String x) {
        return x.split("\\s+");
    }
    
    public static String[] getAddress(String x) {
        return x.split("\\.");
    }
    
    public static String[] extractWordsFromSentence(String x) {
        return x.split("(?<=)\\s+");
    }
    
}

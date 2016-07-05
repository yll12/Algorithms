package algo.codesprint;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AorB {

    static String A;
    static String B;
    static String C;
    static StringBuilder A_ans;
    static StringBuilder B_ans;
    static String ansA;
    static String ansB;
    static int K;
    static String[] hexToBinTable = { "0000", "0001", "0010", "0011", "0100",
            "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100",
            "1101", "1110", "1111" };
    static char[] hexTable = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', 'A', 'B', 'C', 'D', 'E', 'F' };
    static int remainingChanges;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            solve(in);
        }
    }

    private static void solve(Scanner in) {
        K = in.nextInt();
        A = in.next();
        B = in.next();
        C = in.next();
        A_ans = new StringBuilder();
        B_ans = new StringBuilder();
        int minimumChanges = findminimum();
        ansA = A_ans.toString();
        ansB = B_ans.toString();
        if (ansA.equals("")) {
            ansA = "0";
        }
        if (ansB.equals("")) {
            ansB = "0";
        }
        System.out.println(ansA);
        System.out.println(ansB);
        if (minimumChanges > K) {
            System.out.println(-1);
        } else if (minimumChanges == K) {
            System.out.println(ansA);
            System.out.println(ansB);
        } else {
            remainingChanges = K - minimumChanges;
            tryReduce();
            System.out.println(ansA);
            System.out.println(ansB);
        }
    }

    private static int findminimum() {
        int minChanges = 0;
        int max = Math.max(A.length(), Math.max(B.length(), C.length()));
        A = padWithZeros(max, A);
        B = padWithZeros(max, B);
        C = padWithZeros(max, C);
        for (int i = 0; i < C.length(); i++) {
            char a = A.charAt(i);
            char b = B.charAt(i);
            char c = C.charAt(i);
            minChanges += modify(a, b, c);
        }
        return minChanges;
    }

    private static String padWithZeros(int max, String c) {
        return String.format("%" + max + "s", c).replace(' ', '0');
    }

    private static int modify(char a, char b, char c) {
        int required = 0;
        String binary_a = toBinary(a);
        String binary_b = toBinary(b);
        String binary_c = toBinary(c);
        StringBuilder resultingABinary = new StringBuilder();
        StringBuilder resultingBBinary = new StringBuilder();
        for (int i = 0; i < binary_c.length(); i++) {
            int digit_a = charToDigit(binary_a.charAt(i));
            int digit_b = charToDigit(binary_b.charAt(i));
            int digit_c = charToDigit(binary_c.charAt(i));
            required +=
                    compare(digit_a, digit_b, digit_c, resultingABinary,
                            resultingBBinary);
        }
        A_ans.append(toHex(resultingABinary.toString()));
        B_ans.append(toHex(resultingBBinary.toString()));
        return required;
    }

    private static int compare(int a, int b, int c,
            StringBuilder resultingABinary, StringBuilder resultingBBinary) {
        int changes = 0;
        if (c == 0) {
            resultingABinary.append(0);
            resultingBBinary.append(0);
            if (a == 1 && b == 1) {
                changes = 2;
            } else if (a == 1 || b == 1) {
                changes = 1;
            } 
        } else {
            if (a == 0 && b == 0) {
                resultingABinary.append(a);
                resultingBBinary.append(1);
                changes = 1;
            } else {
                resultingABinary.append(a);
                resultingBBinary.append(b);
            }
        }
        return changes;
    }

    private static int charToDigit(char x) {
        return Integer.parseInt(Character.toString(x));
    }

    private static String toHex(String binaryString) {
        int decimal = Integer.parseInt(binaryString, 2);
        if (decimal == 0) {
            return "";
        }
        String result = Integer.toHexString(decimal);
        if (Character.isLetter(result.charAt(0))) {
            return result.toUpperCase();
        } else {
            return result;
        }
    }

    private static String toBinary(char c) {
        return hexToBinTable[Integer.parseInt(Character.toString(c), 16)];
    }

    private static void tryReduce() {
        System.out.println(ansA);
        System.out.println(ansB);
        System.out.println(C);
        int max = Math.max(ansA.length(), Math.max(ansB.length(), C.length()));
        ansA = padWithZeros(max, ansA);
        ansB = padWithZeros(max, ansB);
        C = padWithZeros(max, C);
        A_ans = new StringBuilder();
        B_ans = new StringBuilder();
        for (int i = 0; i < C.length(); i++) {
            char a = ansA.charAt(i);
            char b = ansB.charAt(i);
            char c = C.charAt(i);
            tryReduce2(a, b, c);
        }
    }
    
    private static void tryReduce2(char a, char b, char c) {
        String binary_a = toBinary(a);
        String binary_b = toBinary(b);
        String binary_c = toBinary(c);
        StringBuilder resultingABinary = new StringBuilder();
        StringBuilder resultingBBinary = new StringBuilder();
        for (int i = 0; i < binary_c.length(); i++) {
            int digit_a = charToDigit(binary_a.charAt(i));
            int digit_b = charToDigit(binary_b.charAt(i));
            int digit_c = charToDigit(binary_c.charAt(i));
            tryReduce3(digit_a, digit_b, digit_c, resultingABinary,
                            resultingBBinary);
        }
        A_ans.append(toHex(resultingABinary.toString()));
        B_ans.append(toHex(resultingBBinary.toString()));
    }
    
    private static void tryReduce3(int a, int b, int c, 
        StringBuilder resultingABinary, StringBuilder resultingBBinary) {
        if (c == 0) {
            resultingABinary.append(a);
            resultingBBinary.append(b);
            return;
        } else {
            if (a == 1 && b == 1) {
                if (remainingChanges >= 1) {
                    resultingABinary.append(0);
                    resultingBBinary.append(b);
                    remainingChanges--;
                } else {
                    resultingABinary.append(a);
                    resultingBBinary.append(b);
                }
            } else if (a == 1 && b == 0) {
                if (remainingChanges >= 2) {
                    resultingABinary.append(0);
                    resultingBBinary.append(1);
                    remainingChanges -= 2;
                } else {
                    resultingABinary.append(a);
                    resultingBBinary.append(b);
                }
            } else {
                resultingABinary.append(a);
                resultingBBinary.append(b);
            }
        }
    }

}

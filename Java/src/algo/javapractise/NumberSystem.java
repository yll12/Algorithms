package algo.javapractise;

public class NumberSystem {

    public static char[] letters = { '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

    public static String decToBaseN(int x, int base) {
        if (x == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        while (x != 0) {
            result.insert(0, letters[x % base]);
            x /= base;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        understandingBinary();
        decimalToBaseNTest();
    }

    private static void decimalToBaseNTest() {
        int test = 26;
        System.out.println("Number to test is :" + test);
        for (int i = 2; i <= 16; i++) {
            System.out.printf("Number in %d-ary is %s\n", i,
                    decToBaseN(test, i));
        }
    }

    private static void understandingBinary() {
        int binVal1 = 0b1001;
        int binVal2 = 0b0100;
        System.out.printf("%s + %s = %s\n", Integer.toBinaryString(binVal1),
                Integer.toBinaryString(binVal2),
                Integer.toBinaryString(binVal1 + binVal2));
        int x = 100;
        int shift = 3;
        int y = x >> shift;
        System.out.println(x + " right shift by " + shift + " is equal to "
                + y);
        System.out.println(x + " divided by 2^" + shift + " is equal to " + x
                / (int) Math.pow(2, shift));

    }

}

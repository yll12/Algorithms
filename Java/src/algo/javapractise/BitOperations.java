package algo.javapractise;

import java.util.BitSet;

public class BitOperations {

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0};
        boolean[] binary = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            binary[i] = intToBool(arr[i]);
        }
        BitSet x = buildBinary(binary);
        System.out.println(x);
    }

    private static boolean intToBool(int input) {
        if (input < 0 || input > 1)
        {
            return true;
        }

        return input == 1;
    }
    
    private static BitSet buildBinary(boolean[] arr) {
        BitSet result = new BitSet(arr.length);
        for (int i = 0; i < arr.length; i++) {
            result.set(i, arr[i]);
        }
        return result;
    }

}

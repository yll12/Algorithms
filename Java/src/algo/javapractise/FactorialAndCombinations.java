package algo.javapractise;

public class FactorialAndCombinations {

    private final static int MOD = 1000000007;

    private static long[] factorials = new long[2000005];

    public static void preComputeFactorials() {
        factorials[0] = 1;
        for (int i = 1; i < 2000005; i++) {
            factorials[i] = (factorials[i - 1] * i) % MOD;
        }
    }

    // Computes a^k modulo p
    public static long pow(long a, long k, long p) {
        a %= p; // Ensure first a is less than p

        long result = 1;

        while (k > 0) {
            if (k % 2 == 1) {
                result = (result * a) % p;
            }
            a = (a * a) % p;
            k /= 2;
        }
        return result;
    }

    // Computes a^-1 modulo p
    // By Fermat's Little Theorem: a^(p-1) = 1 modulo p,
    // Hence a^-1 is congruent to a^(p-2) modulo p.
    public static long modInverse(long a, long p) {
        return pow(a, p - 2, p);
    }

    // Computes {n \choose k} modulo p
    public static long nChooseK(int n, int k, long p) {
        long result = factorials[n]; // result = n! mod p

        // result = n! / (n-k)! mod p
        result = (result * modInverse(factorials[n - k], p)) % p;

        // result = n! / ((n-k)! k!)mod p
        result = (result * modInverse(factorials[k], p)) % p;
        return result;
    }

    public static void main(String[] args) {
        preComputeFactorials();
        testFactorials();
        testFastExponential();
        testNChooseK();
    }

    private static void testFastExponential() {
        int a = 7;
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d^(2^%d) is: %d\n", a, i,
                    pow(a, (long) Math.pow(2, i), 13));
        }
    }

    private static void testNChooseK() {
        int n = 10;
        for (int i = 0; i <= 10; i++) {
            System.out.printf("(%d choose %d) is: %d\n", n, i,
                    nChooseK(n, i, MOD));
        }
    }

    private static void testFactorials() {
        for (int i = 0; i <= 10; i++) {
            System.out.printf("%d! is: %d\n", i, factorials[i]);
        }
    }

}

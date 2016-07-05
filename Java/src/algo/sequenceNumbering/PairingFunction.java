package algo.sequenceNumbering;

public class PairingFunction {

    static Pair pair = new Pair();
    static int n;

    public static void main(String[] args) {
        System.out.printf("z\t(x,y)\tn\n");
        for (int z = 1; z <= 100; z++) {
            compute(z);
            System.out.printf("%d\t(%d,%d)\t%d\n", z, pair.x, pair.y, n);
        }
        int z = computeZ(240, 5868);
        compute(z);
        System.out.println("3z is " + 3 * z);
        System.out.printf("Check correct z: (%d, %d)\n", pair.x, pair.y);
    }

    public static int computeZ(int x, int y) {
        return T(x + y - 2) + y;
    }
    
    public static int T(int n) {
        return (n * (n+1)) / 2;
    }
    
    public static void compute(int z) {
        int w = (int) (Math.floor((3 + Math.sqrt(8 * (z-1) + 1)) / 2.0));
        int t = (w - 2) * (w - 1) / 2;
        pair.y = z - t;
        pair.x = w - pair.y;
        n = pair.y + pair.x - 2;
    }

}

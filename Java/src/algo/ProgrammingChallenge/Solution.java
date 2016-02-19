package algo.ProgrammingChallenge;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int x = -n;
            int y = 2 * n;
            int l = 1;
            while (y >= 0) {
                x += 3 * l;
                y -= 5 * l;
                if (x >= 0) {
                    break;
                }
            }
            if (y < 0 || x < 0) {
                System.out.print("-1");
            } else {
                for (int i = 0; i < 3 * y; i++) {
                    System.out.print("5");
                }
                for (int i = 0; i < 5 * x; i++) {
                    System.out.print("3");
                }
            }
            System.out.println();
        }
        in.close();
    }
}

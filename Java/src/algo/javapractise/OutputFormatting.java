package algo.javapractise;

import java.util.Scanner;

public class OutputFormatting {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for (int i = 0; i < 3; i++) {
            String s1 = sc.next();
            int x = sc.nextInt();
            String paddedx = String.format("%03d", x);
            int n = 15;
            String paddeds1 = String.format("%-" + n + "s", s1);
            System.out.println(paddeds1 + paddedx);
        }
        System.out.println("================================");
        sc.close();
    }
}

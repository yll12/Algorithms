package algo.hackerrank;

import java.util.*;

public class CaesarCipher {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String unEncrypted = in.next();
        int shift = in.nextInt() % 26;
        for (int i = 0; i < n; i++) {
            char curr = unEncrypted.charAt(i);
            if (curr >= 'a' && curr <= 'z') {
                char x = (char) ((curr - 'a' + shift) % 26 + 'a');
                System.out.print(x);    
            } else if (curr >= 'A' && curr <= 'Z') {
                char x = (char) ((curr - 'A' + shift) % 26 + 'A');
                System.out.print(x);    
            } else {
                System.out.print(curr);
            }
        }
        in.close();
    }
}
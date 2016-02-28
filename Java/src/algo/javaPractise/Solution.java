package algo.javaPractise;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        for (int i = 0; i < 259; i++) {
            System.out.println(String.format("(%d, %c)", i, (char) i));
        }
        char one_half = 189;
        System.out.println(String.format("%c + %c = 1", one_half, one_half));
    }
}
package algo.programmingchallenge;

import java.io.*;
import java.util.*;

public class NewYearChaos {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] array = new int[n];
            for (int j = 0; j < n; j++) {
                array[j] = in.nextInt();
            }
            int[] correspondingList = getCorrespondingList(array);
            solve(array, correspondingList);
        }

    }

    private static void solve(int[] array, int[] correspondingList) {
        int n = correspondingList.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int current = correspondingList[i];
            System.out.println(Arrays.toString(array));
            System.out.println(Arrays.toString(correspondingList));
            if ((n - i - 1) - current > 2) {
                System.out.println("Too chaotic");
                return;
            } else if ((n - i - 1) - current == 1) {
                count++;
                correspondingList[n - array[current+1]]--;
                int tmp = array[current];
                array[current] = array[current + 1];
                array[current + 1] = tmp;
            } else if ((n - i - 1) - current == 2) {
                count += 2;
                correspondingList[n - array[current+1]]--;
                correspondingList[n - array[current+2]]--;
                int tmp2 = array[current];
                array[current] = array[current + 1];
                array[current + 1] = array[current + 2];
                array[current + 2] = tmp2;
            }
        }
        System.out.println(count);
    }

    public static int[] getCorrespondingList(int[] array) {
        int[] results = new int[array.length];
        int max = 0;
        int positionOfMax = 0;
        int[] intermediate = array.clone();
        for (int i = 0; i < intermediate.length; i++) {
            if (intermediate[i] > max) {
                max = intermediate[i];
                positionOfMax = i;
            }
        }
        for (int i = 0; i < results.length; i++) {
            intermediate[i] = max - intermediate[i];
        }

        results[0] = positionOfMax;

        for (int i = 1; i < results.length; i++) {
            results[intermediate[i]] = i;
        }

        return results;
    }
}

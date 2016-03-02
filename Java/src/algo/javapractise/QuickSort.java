package algo.javapractise;

import java.util.Random;


public class QuickSort implements Sort {

    @Override
    public void sort(int[] array) {
        quickSort(array);
    }

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int p = partition(array, low, high);
            quickSort(array, low, p - 1);
            quickSort(array, p + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int p = randomValueBetween(low, high);
        int pivot = array[p];
        swap(array, p, high);
        int partitionIndex = 0;
        
        for (int i = 0; i < high; i++) {
            if (array[i] <= pivot) {
                swap(array, i, partitionIndex);
                partitionIndex++;
            }
        }
        swap(array, partitionIndex, high);
        return partitionIndex;
    }
    
    private static int randomValueBetween(int low, int high) {
        return low + (new Random()).nextInt(high - low + 1);
    }
    
    private static void swap(int[] array, int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }
    
    public static void main(String[] args) {
        
        int[] array = {3, 7, 8, 5, 2, 1, 9, 5, 4};
        quickSort(array);
        System.out.print("{");;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) {
                System.out.print(", ");
            }
        }
        
        System.out.print("}\n");
        int[] array2 = {5};
        quickSort(array);
        System.out.print("{");;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("}\n");
    }
    
}

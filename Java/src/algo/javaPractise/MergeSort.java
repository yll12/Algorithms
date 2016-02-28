package algo.javaPractise;

import algo.programmingchallenge.Sort;

public class MergeSort implements Sort {

    @Override
    public void sort(int[] array) {
        mergeSort(array);
    }
    
    public static void mergeSort(int[] array) {
        int n = array.length;
        if (n <= 1) {
            return;
        }
        int middle = n / 2;
        int[] left = new int[middle];
        int[] right = new int[n - middle];
        
        System.arraycopy(array, 0, left, 0, left.length);
        System.arraycopy(array, middle, right, 0, right.length);
        
        mergeSort(left);
        mergeSort(right);
        
        merge(left, right, array);
    }
    
    //       first  second
    //        |       |
    // given {6, 5}, {3, 1},
    // return {1, 3, 5, 6}
    private static void merge(int[] first, int[] second, int[] result) {
        int iFirst = 0;
        int iSecond = 0;
        int iCurrent = 0;
        
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] > second[iSecond]) {
               result[iCurrent] = second[iSecond];
               iSecond++;
            } else {
               result[iCurrent] = first[iFirst];
               iFirst++;
            }
            iCurrent++;
        }
        System.arraycopy(first, iFirst, result, iCurrent, first.length - iFirst);
        System.arraycopy(second, iSecond, result, iCurrent, second.length - iSecond);
    }

     
}

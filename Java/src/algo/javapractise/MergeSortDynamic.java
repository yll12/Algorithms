package algo.javapractise;

public class MergeSortDynamic implements Sort {

    @Override
    public void sort(int[] array) {
        mergeSort(array);
    }

    public static void mergeSort(int[] array) {
        mergeSort_helper(array, 0, array.length - 1);
    }

    private static void mergeSort_helper(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort_helper(A, p, q);
            mergeSort_helper(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    private static void merge(int[] A, int p, int q, int r) {
        int leftLength = q - p + 1;
        int rightLength = r - q;
        int[] L = new int[leftLength + 1];
        int[] R = new int[rightLength + 1];
        for (int i = 0; i < leftLength; i++) {
            L[i] = A[p + i];
        }
        for (int i = 0; i < rightLength; i++) {
            R[i] = A[q + i + 1];
        }
        L[leftLength] = Integer.MAX_VALUE;
        R[rightLength] = Integer.MAX_VALUE;
        int iLeft = 0;
        int iRight = 0;
        for (int iCurrent = p; iCurrent <= r; iCurrent++) { // INCLUDING r
            if (L[iLeft] <= R[iRight]) {
                A[iCurrent] = L[iLeft];
                iLeft++;
            } else {
                A[iCurrent] = R[iRight];
                iRight++;
            }
        }
    }
    
    
}

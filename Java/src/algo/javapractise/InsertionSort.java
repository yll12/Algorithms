package algo.javapractise;


public class InsertionSort implements Sort {

    @Override
    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int rightHand = array[i];
            int j = 0;
            for (j = i - 1; j >= 0 && array[j] > rightHand; j--) {
                // Use your left hand and shift the card to the right
                array[j + 1] = array[j];
            }
            array[j + 1] = rightHand;
        }
    }

}

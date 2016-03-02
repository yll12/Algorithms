package algo.javapractise;

import static algo.javapractise.MergeSort.mergeSort;
import static algo.javapractise.QuickSort.quickSort;

import org.junit.Assert;
import org.junit.Test;

import algo.javapractise.InsertionSort;
import algo.javapractise.MergeSortDynamic;
import algo.javapractise.Sort;

public class SortTest {

    @Test
    public void quickSortTest() {
        int[] actuals = {3, 7, 8, 5, 2, 1, 9, 5, 4};
        quickSort(actuals);
        int[] expecteds = {1, 2, 3, 4, 5, 5, 7, 8, 9};
        Assert.assertArrayEquals(expecteds, actuals);
    }
    
    @Test
    public void quickSortTest2() {
        int[] actuals = {5};
        quickSort(actuals);
        int[] expecteds = {5};
        Assert.assertArrayEquals(expecteds, actuals);
    }
    
    @Test
    public void quickSortTest3() {
        int[] actuals = {};
        quickSort(actuals);
        int[] expecteds = {};
        Assert.assertArrayEquals(expecteds, actuals);
    }
    
    @Test
    public void quickSortTest4() {
        int[] actuals = {5, 4};
        quickSort(actuals);
        int[] expecteds = {4, 5};
        Assert.assertArrayEquals(expecteds, actuals);
    }
    
    @Test
    public void mergeSortTest() {
        int[] actuals = {3, 7, 8, 5, 2, 1, 9, 5, 4};
        mergeSort(actuals);
        int[] expecteds = {1, 2, 3, 4, 5, 5, 7, 8, 9};
        Assert.assertArrayEquals(expecteds, actuals);
    }
    
    @Test
    public void mergeSortTest2() {
        int[] actuals = {5};
        mergeSort(actuals);
        int[] expecteds = {5};
        Assert.assertArrayEquals(expecteds, actuals);
    }
    
    @Test
    public void mergeSortTest3() {
        int[] actuals = {};
        mergeSort(actuals);
        int[] expecteds = {};
        Assert.assertArrayEquals(expecteds, actuals);
    }
    
    @Test
    public void mergeSortTest4() {
        int[] actuals = {5, 4};
        mergeSort(actuals);
        int[] expecteds = {4, 5};
        Assert.assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void insertionSortTest() {
        int[] actuals = {3, 7, 8, 5, 2, 1, 9, 5, 4};
        Sort sorter = new InsertionSort();
        sorter.sort(actuals);
        int[] expecteds = {1, 2, 3, 4, 5, 5, 7, 8, 9};
        Assert.assertArrayEquals(expecteds, actuals);
    }
    
    @Test
    public void insertionSortTest2() {
        int[] actuals = {5};
        Sort sorter = new InsertionSort();
        sorter.sort(actuals);
        int[] expecteds = {5};
        Assert.assertArrayEquals(expecteds, actuals);
    }
    
    @Test
    public void insertionSortTest3() {
        int[] actuals = {};
        Sort sorter = new InsertionSort();
        sorter.sort(actuals);
        int[] expecteds = {};
        Assert.assertArrayEquals(expecteds, actuals);
    }
    
    @Test
    public void insertionSortTest4() {
        int[] actuals = {5, 4};
        Sort sorter = new InsertionSort();
        sorter.sort(actuals);
        int[] expecteds = {4, 5};
        Assert.assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void mergeSortDynamicTest1() {
        int[] actuals = {3, 7, 8, 5, 2, 1, 9, 5, 4};
        Sort sorter = new MergeSortDynamic();
        sorter.sort(actuals);
        int[] expecteds = {1, 2, 3, 4, 5, 5, 7, 8, 9};
        Assert.assertArrayEquals(expecteds, actuals);
    }
    
    @Test
    public void mergeSortDynamicTest5() {
        int[] actuals = {3, 7, 8, 5, 2, 1, 5, 4};
        Sort sorter = new MergeSortDynamic();
        sorter.sort(actuals);
        int[] expecteds = {1, 2, 3, 4, 5, 5, 7, 8};
        Assert.assertArrayEquals(expecteds, actuals);
    }
    
    @Test
    public void mergeSortDynamicTest6() {
        int[] actuals = {8, 7, 6, 5, 4, 3, 2, 1};
        Sort sorter = new MergeSortDynamic();
        sorter.sort(actuals);
        int[] expecteds = {1, 2, 3, 4, 5, 6, 7, 8};
        Assert.assertArrayEquals(expecteds, actuals);
    }
    
    @Test
    public void mergeSortDynamicTest2() {
        int[] actuals = {5};
        Sort sorter = new MergeSortDynamic();
        sorter.sort(actuals);
        int[] expecteds = {5};
        Assert.assertArrayEquals(expecteds, actuals);
    }
    
    @Test
    public void mergeSortDynamicTest3() {
        int[] actuals = {};
        Sort sorter = new MergeSortDynamic();
        sorter.sort(actuals);
        int[] expecteds = {};
        Assert.assertArrayEquals(expecteds, actuals);
    }
    
    @Test
    public void mergeSortDynamicTest4() {
        int[] actuals = {5, 4};
        Sort sorter = new MergeSortDynamic();
        sorter.sort(actuals);
        int[] expecteds = {4, 5};
        Assert.assertArrayEquals(expecteds, actuals);
    }

}

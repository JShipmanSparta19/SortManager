package com.sparta.jas;

import com.sparta.jas.sorter.Sorter;
import com.sparta.jas.sorter.bubbleSort.BubbleSort;
import com.sparta.jas.sorter.mergeSort.MergeSort;
import com.sparta.jas.sorter.quickSort.QuickSort;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

public class NullTest {
    private static int[] unsortedArray;
    private static int[] nullArray;
    private int[] bubbleSortedArray;
    private int[] mergeSortedArray;
    private int[] quickSortedArray;
    private Sorter bubbleSorter = new BubbleSort();
    private Sorter mergeSorter = new MergeSort();
    private Sorter quickSorter = new QuickSort();

    @BeforeClass
    public static void setClass() {
        unsortedArray = new int[]{};
        nullArray = new int[0];
    }

    @Before
    public void setup() {
        bubbleSortedArray = bubbleSorter.sortArray(unsortedArray);
        mergeSortedArray = mergeSorter.sortArray(unsortedArray);
        quickSortedArray = quickSorter.sortArray(unsortedArray);
    }

    @Test
    public void bubbleSortNull() {
        Assert.assertTrue(Arrays.equals(nullArray, bubbleSortedArray));
    }

    @Test
    public void mergeSortNull() {
        Assert.assertTrue(Arrays.equals(nullArray, mergeSortedArray));
    }

    @Test
    public void quickSortNull() {
        Assert.assertTrue(Arrays.equals(nullArray, quickSortedArray));
    }
}


package com.sparta.jas;

import com.sparta.jas.sorter.Sorter;
import com.sparta.jas.sorter.bubbleSort.BubbleSort;
import com.sparta.jas.sorter.mergeSort.MergeSort;
import com.sparta.jas.sorter.quickSort.QuickSort;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

public class SorterComparisonTester {
    private static int[] unsortedArray;
    private int[] bubbleSortedArray;
    private int[] mergeSortedArray;
    private int[] quickSortedArray;
    private Sorter bubbleSorter = new BubbleSort();
    private Sorter mergeSorter = new MergeSort();
    private Sorter quickSorter = new QuickSort();

    @BeforeClass
    public static void setClass(){
        Random random = new Random();
        int arrayLength = random.nextInt(10)+5;
        unsortedArray = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++){
            unsortedArray[i] = random.nextInt(100)-50;
        }
    }

    @Before
    public void setup(){
        bubbleSortedArray = bubbleSorter.sortArray(unsortedArray);
        mergeSortedArray = mergeSorter.sortArray(unsortedArray);
        quickSortedArray = quickSorter.sortArray(unsortedArray);
    }

    @Test
    public void bubbleMergeComparisonTest(){
        Assert.assertArrayEquals(bubbleSortedArray, mergeSortedArray);
    }

    @Test
    public void bubbleQuickComparisonTest(){
        Assert.assertArrayEquals(bubbleSortedArray, quickSortedArray);
    }

    @Test
    public void mergeQuickComparisonTest(){
        Assert.assertArrayEquals(quickSortedArray, mergeSortedArray);
    }
}

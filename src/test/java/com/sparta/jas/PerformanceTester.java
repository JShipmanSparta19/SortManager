package com.sparta.jas;

import com.sparta.jas.sorter.Sorter;
import com.sparta.jas.sorter.binarySort.BinarySort;
import com.sparta.jas.sorter.bubbleSort.BubbleSort;
import com.sparta.jas.sorter.mergeSort.MergeSort;
import com.sparta.jas.sorter.quickSort.QuickSort;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class PerformanceTester {

    private static int[] arrayToSort;
    private int[] unsortedArray;

    @BeforeClass
    public static void setupClass(){
        Random random = new Random();
        arrayToSort = new int[100_000];
        for (int i = 0; i < arrayToSort.length; i++){
            arrayToSort[i] = random.nextInt(100_000);
        }
    }

    @Before
    public void setup(){
        unsortedArray = arrayToSort.clone();
    }

    @Test
    public void testBubbleSorter(){
        Sorter bubbleSorter = new BubbleSort();
        long start = System.nanoTime();
        int[] sortedArray = bubbleSorter.sortArray(unsortedArray);
        long finish = System.nanoTime();
        printResults(bubbleSorter.toString(), finish - start, sortedArray);
    }

    @Test
    public void testMergeSorter(){
        Sorter mergeSorter = new MergeSort();
        long start = System.nanoTime();
        int[] sortedArray = mergeSorter.sortArray(unsortedArray);
        long finish = System.nanoTime();
        printResults(mergeSorter.toString(), finish - start, sortedArray);
    }

    @Test
    public void testBinarySorter(){
        Sorter binarySorter = new BinarySort();
        long start = System.nanoTime();
        int[] sortedArray = binarySorter.sortArray(unsortedArray);
        long finish = System.nanoTime();
        printResults(binarySorter.toString(), finish - start, sortedArray);
    }

    @Test
    public void testQuickSorter(){
        Sorter quickSorter = new QuickSort();
        long start = System.nanoTime();
        int[] sortedArray = quickSorter.sortArray(unsortedArray);
        long finish = System.nanoTime();
        printResults(quickSorter.toString(), finish - start, sortedArray);
    }

    private void printResults(String sorter, long time, int[] sortedArray){
        DecimalFormat df = new DecimalFormat("###,###.####");
        System.out.println(sorter + ":");
//        System.out.println(Arrays.toString(sortedArray));
        System.out.println("Time taken: " + df.format(time)+ " nanoseconds");
    }
}

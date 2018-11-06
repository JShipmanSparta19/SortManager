package com.sparta.jas;

import com.sparta.jas.sorter.Sorter;
import com.sparta.jas.sorter.mergeSort.MergeSort;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MergeSorterTester {

    private static int[] unsortedArray;
    private int[] sortedArray;
    private Sorter sorter = new MergeSort();

    @BeforeClass
    public static void setClass(){
        Random random = new Random();
        int arrayLength = random.nextInt(100)+50;
        unsortedArray = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++){
            unsortedArray[i] = random.nextInt(100)-50;
        }
    }

    @Before
    public void setup(){
        sortedArray = sorter.sortArray(unsortedArray);
    }

    @Test
    public void testSortedArray(){
        for (int i = 0; i < sortedArray.length - 1; i++){
            assertTrue(sortedArray[i] <= sortedArray[i+1]);
        }
    }

    @Test
    public void testArraySize(){
        assertEquals(unsortedArray.length, sortedArray.length);
    }

    @Test
    public void testZeroes() {
        int[] zeroArray = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        int[] sortedZeroArray = sorter.sortArray(zeroArray);
        for (int i = 0; i < sortedZeroArray.length - 1; i++) {
            Assert.assertArrayEquals(sortedZeroArray, zeroArray);
        }
    }
}

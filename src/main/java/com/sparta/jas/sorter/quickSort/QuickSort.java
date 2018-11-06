package com.sparta.jas.sorter.quickSort;

import com.sparta.jas.control.SortManager;
import com.sparta.jas.sorter.Sorter;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.Arrays;

public class QuickSort implements Sorter {

    private int[] array;

    private static final String LOG_PROPERTIES_FILE = "resources/log4j.properties";
    private static Logger log = Logger.getLogger(SortManager.class.getName());

    private static void initialiseLogging(){
        PropertyConfigurator.configure(LOG_PROPERTIES_FILE);
    }

    public int[] sortArray(int[] arrayToSort){
        if(arrayToSort == null || arrayToSort.length == 0){
            return new int[0];
        }
        this.array = arrayToSort.clone();
        quickSort(0, arrayToSort.length-1);
        return array;
    }

    private void quickSort(int endLeft, int endRight){
        initialiseLogging();

        int leftIndex = endLeft;
        int rightIndex = endRight;
        int pivot = array[(endLeft+endRight)/2];
//        log.debug("Pivot chosen at " + pivot + " from " + Arrays.toString(array));

        while(leftIndex <= rightIndex){
            while(array[leftIndex] < pivot){
                leftIndex++;
            }
            while(array[rightIndex] > pivot){
                rightIndex--;
            }
            if(leftIndex <= rightIndex){
                swap(leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        if(endLeft < rightIndex){
            quickSort(endLeft, rightIndex);
        }
        if(leftIndex < endRight){
          quickSort(leftIndex, endRight);
        }
    }

    private void swap(int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}

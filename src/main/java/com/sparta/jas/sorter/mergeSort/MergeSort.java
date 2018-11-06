package com.sparta.jas.sorter.mergeSort;

import com.sparta.jas.control.SortManager;
import com.sparta.jas.sorter.Sorter;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.Arrays;

public class MergeSort implements Sorter {

    private static final String LOG_PROPERTIES_FILE = "resources/log4j.properties";
    private static Logger log = Logger.getLogger(SortManager.class.getName());

    private static void initialiseLogging(){
        PropertyConfigurator.configure(LOG_PROPERTIES_FILE);
    }

    public int[] sortArray(int[] input){
        if(input == null || input.length == 0){
            return new int[0];
        }
        int inputHalf = input.length/2;
        int[] mergedArray;

        Split performSplit = new Split();

        int[][] splitArray = performSplit.splitter(input,inputHalf);
        int[] splitArrayLeft = splitArray[0];
        int[] splitArrayRight = splitArray[1];
//        log.debug("Array " + Arrays.toString(input) + " split into " + Arrays.toString(splitArrayLeft) + " and " + Arrays.toString(splitArrayRight));

        if(splitArrayLeft.length != 1){
            splitArrayLeft = sortArray(splitArrayLeft);
        }
        if(splitArrayRight.length != 1){
            splitArrayRight = sortArray(splitArrayRight);
        }

        Merge performMerge = new Merge(splitArrayLeft, splitArrayRight);
        mergedArray = performMerge.merge();
//        log.info("Merge performed on " + Arrays.toString(splitArrayLeft) + " and " + Arrays.toString(splitArrayRight));

        return mergedArray;
    }
}

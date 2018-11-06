package com.sparta.jas.sorter.bubbleSort;

import com.sparta.jas.control.SortManager;
import com.sparta.jas.sorter.Sorter;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class BubbleSort implements Sorter{

    private static final String LOG_PROPERTIES_FILE = "resources/log4j.properties";
    private static Logger log = Logger.getLogger(SortManager.class.getName());

    private static void initialiseLogging(){
        PropertyConfigurator.configure(LOG_PROPERTIES_FILE);
    }

    public int[] sortArray(int[] unsortedArray){
        initialiseLogging();
        if(unsortedArray == null || unsortedArray.length == 0){
            return new int[0];
        }
        int[] bSortArray = unsortedArray.clone();
        String change;
        do {
            change = "n";

            for (int i = 0; i < bSortArray.length - 1; i++) {
                if (bSortArray[i] > bSortArray[i + 1]) {
                    int temp = bSortArray[i];
                    bSortArray[i] = bSortArray[i + 1];
                    bSortArray[i + 1] = temp;
//                    log.debug("Swapped '" + bSortArray[i] + "' and '" + bSortArray[i+1] + "'");
                    change = "y";
                }
            }
        } while (change.equals("y"));
        return bSortArray;
    }
}

package com.sparta.jas.control;

import com.sparta.jas.display.Display;
import com.sparta.jas.display.DisplayToConsole;
import com.sparta.jas.exceptions.FactoryException;
import com.sparta.jas.sorter.Sorter;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.Arrays;

public class SortManager {
    private int[] arrayToSort = {1, 5, 7, 3, 8, 2, 4};
    private String sortType;
    private int[] outputArray;
    private Display consoleDisplay = new DisplayToConsole();

    private static final String LOG_PROPERTIES_FILE = "resources/log4j.properties";
    private static Logger log = Logger.getLogger(SortManager.class.getName());

    private static void initialiseLogging(){
        PropertyConfigurator.configure(LOG_PROPERTIES_FILE);
    }

    public void runSorter(){
        initialiser();
        Sorter sorter;
        try {
            sorter = SortFactory.getInstance();
            sortType = sorter.getClass().getSimpleName();
            log.info("User requested " + Arrays.toString(arrayToSort) + " to be sorted using a " + sortType);
            outputArray = sorter.sortArray(arrayToSort);
            displaySortedArray();
        } catch (FactoryException e) {
            log.fatal(e.getMessage());
        }
    }

    private void initialiser(){
        initialiseLogging();
        consoleDisplay.display(arrayToSort);
    }

    private void displaySortedArray(){
        consoleDisplay.display(outputArray, sortType);
    }

    private void displayExceptionMessage(String message){
        consoleDisplay.displayException(message);
    }
}

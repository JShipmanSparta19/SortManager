package com.sparta.jas;

import com.sparta.jas.control.SortFactory;
import com.sparta.jas.exceptions.FactoryException;
import com.sparta.jas.sorter.Sorter;
import com.sparta.jas.sorter.bubbleSort.BubbleSort;
import com.sparta.jas.sorter.mergeSort.MergeSort;
import com.sparta.jas.sorter.quickSort.QuickSort;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.io.FileReader;

public class FactoryTest {

    private static final String PATH = "resources/factory.properties";
    private Properties properties = new Properties();
    private static FileOutputStream out = null;

    @Before
    public void setup(){
        try {
            properties.load(new FileReader(PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out = new FileOutputStream("resources/factory.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void quickSortType(){
        properties.setProperty("sorter", "com.sparta.jas.sorter.quickSort.QuickSort");
        try {
            properties.store(out ,"");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Sorter sortTest = null;
        try {
            sortTest = SortFactory.getInstance();
        } catch (FactoryException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(sortTest instanceof QuickSort);
    }
    @Test
    public void mergeSortType(){
        properties.setProperty("sorter", "com.sparta.jas.sorter.mergeSort.MergeSort");
        try {
            properties.store(out ,"");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Sorter sortTest = null;
        try {
            sortTest = SortFactory.getInstance();
        } catch (FactoryException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(sortTest instanceof MergeSort);
    }
    @Test
    public void bubbleSortType(){
        properties.setProperty("sorter", "com.sparta.jas.sorter.bubbleSort.BubbleSort");
        try {
            properties.store(out ,"");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Sorter sortTest = null;
        try {
            sortTest = SortFactory.getInstance();
        } catch (FactoryException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(sortTest instanceof BubbleSort);
    }
}

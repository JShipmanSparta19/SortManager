package com.sparta.jas.control;

import com.sparta.jas.exceptions.FactoryException;
import com.sparta.jas.sorter.Sorter;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class SortFactory {
    private static final String PATH = "resources/factory.properties";

    public static Sorter getInstance() throws FactoryException{
        try {
            Properties properties = new Properties();
            properties.load(new FileReader(PATH));
            String sortType = properties.getProperty("sorter");
            Class selectedSorter = Class.forName(sortType);
            return (Sorter) selectedSorter.getDeclaredConstructor().newInstance();
        } catch (IOException | InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {
            String exceptionName = e.toString();
            String[] exceptionArray = exceptionName.split(":");
            exceptionName = exceptionArray[0];
            String[] exceptionArray2 = exceptionName.split("[.]");
            exceptionName = exceptionArray2[exceptionArray2.length - 1];
            throw new FactoryException(exceptionName);
        }
    }
}

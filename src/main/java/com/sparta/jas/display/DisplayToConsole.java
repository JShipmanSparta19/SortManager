package com.sparta.jas.display;

import java.util.Arrays;

public class DisplayToConsole implements Display {

    public void display(int[] outputArray){
        System.out.print("Array to be sorted: ");
        System.out.println(Arrays.toString(outputArray));
    }

    public void display(int[] outputArray, String sortType){
        System.out.print("Sorted using " + sortType + ": ");
        System.out.println(Arrays.toString(outputArray));
    }

    public void displayException(String message){
        System.out.println("Unable to process user request: " + message);
    }
}

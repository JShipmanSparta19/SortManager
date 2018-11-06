package com.sparta.jas.display;

public interface Display {
    void display(int[] outputArray);
    void display(int[] outputArray, String sortType);
    void displayException(String message);
}

package com.sparta.jas.sorter.mergeSort;

import java.util.Arrays;

public class Split {
    public int[][] splitter(int[] input, int inputHalf){
        int[][] output = new int[2][];
        output[0] = Arrays.copyOfRange(input, 0, inputHalf);
        output[1] = Arrays.copyOfRange(input, inputHalf, input.length);
        return output;
    }
}

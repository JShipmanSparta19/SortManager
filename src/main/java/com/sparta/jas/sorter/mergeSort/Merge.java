package com.sparta.jas.sorter.mergeSort;

import java.util.ArrayList;
import java.util.List;

public class Merge {
    private int[] arr1;
    private int[] arr2;

    Merge(int[] arr1, int[] arr2) {
        this.arr1 = arr1;
        this.arr2 = arr2;
    }


    public int[] merge() {
        int[] finArr = new int[arr1.length + arr2.length];
        int indexArr1 = 0;
        int indexArr2 = 0;
        int indexFinArr = 0;
        while(indexArr1 < arr1.length || indexArr2 < arr2.length){
            if (indexArr1 == arr1.length){
                finArr[indexFinArr] = arr2[indexArr2];
                indexArr2++;
                indexFinArr++;
            } else if (indexArr2 == arr2.length){
                finArr[indexFinArr] = arr1[indexArr1];
                indexArr1++;
                indexFinArr++;
            } else if (arr1[indexArr1] < arr2[indexArr2]) {
                finArr[indexFinArr] = arr1[indexArr1];
                indexArr1++;
                indexFinArr++;
            } else {
                finArr[indexFinArr] = arr2[indexArr2];
                indexArr2++;
                indexFinArr++;
            }
        }
        return finArr;
    }
}


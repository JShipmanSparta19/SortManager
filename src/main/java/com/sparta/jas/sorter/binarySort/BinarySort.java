package com.sparta.jas.sorter.binarySort;

import com.sparta.jas.sorter.Sorter;

public class BinarySort implements Sorter {

    @Override
    public int[] sortArray(int[] arrayToSort) {
        BinaryTree binaryTree = new Tree(arrayToSort);
        return binaryTree.getSortedTreeAsc();
    }
}

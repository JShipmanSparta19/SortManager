package com.sparta.jas.sorter.binarySort;

import com.sparta.jas.control.SortManager;
import com.sparta.jas.exceptions.ChildNotFoundException;
import com.sparta.jas.exceptions.DeleteRootException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.Arrays;

public class Tree implements BinaryTree{
    private final Node root;
    private int size = 0;
    private int index;
    private Node node;

    private static final String LOG_PROPERTIES_FILE = "resources/log4j.properties";
    private static Logger log = Logger.getLogger(SortManager.class.getName());

    private static void initialiseLogging(){
        PropertyConfigurator.configure(LOG_PROPERTIES_FILE);
    }

    public Tree(int rootVal) {
        root = new Node(rootVal);
        size++;
        initialiseLogging();
    }

    public Tree(int[] array){
        root = new Node(array[0]);
        size++;
        addElements(Arrays.copyOfRange(array,1,array.length));
        initialiseLogging();
    }

// Overrides
    @Override
    public int getRootElement() {
        return root.getValue();
    }

    @Override
    public int getNumberOfElements() {
        return size;
    }

    @Override
    public void addElement(int element) {
        Node child = new Node(element);
        node = root;
        boolean added = false;
        while (!added) {
            if (element < node.getValue()) {
                if (node.getLeftChild() != null) {
                    node = node.getLeftChild();
                } else {
                    node.setLeftChild(child);
                    size++;
                    added = true;
//                    log.debug("Created a node with value '" + element + "' that is a left child of '" + node.getValue() + "'");
                }
            } else if (element > node.getValue()) {
                if (node.getRightChild() != null){
                    node = node.getRightChild();
                } else{
                    node.setRightChild(child);
                    size++;
                    added = true;
//                    log.debug("Created a node with value '" + element + "' that is a right child of '" + node.getValue() + "'");
                }
            } else {
                added = true;
            }
        }
    }


    @Override
    public void addElements(int[] elements) {
        for (int element : elements) {
            addElement(element);
        }
    }

    @Override
    public boolean findElement(int value) {
        node = root;
        while (node != null){
            if(node.getValue() == value){
                return true;
            } else if(value < node.getValue()){
                node = node.getLeftChild();
            } else {
                node = node.getRightChild();
            }
        }
        return false;
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        node = root;
        String childType = "left";
        boolean exists = findElement(element);
        if(exists){
            try {
                return node.getLeftChild().getValue();
            } catch (NullPointerException e) {
                throw new ChildNotFoundException(element, childType);
            }
        } else{
            throw new ChildNotFoundException(element);
        }
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        node = root;
        String childType = "right";
        while (node != null){
            if(node.getValue() == element){
                try {
                    return node.getRightChild().getValue();
                } catch (NullPointerException e) {
                    throw new ChildNotFoundException(element, childType);
                }
            } else if(element < node.getValue()){
                node = node.getLeftChild();
            } else {
                node = node.getRightChild();
            }
        }
        throw new ChildNotFoundException(element);
    }

    @Override
    public int[] getSortedTreeAsc() {
        int[] sortedArray = new int[getNumberOfElements()];
        index = 0;
        fillArrayAsc(root, sortedArray);
        return sortedArray;
    }

    @Override
    public int[] getSortedTreeDesc() {
        int[] sortedArray = new int[getNumberOfElements()];
        index = 0;
        fillArrayDesc(root, sortedArray);
        return sortedArray;
    }

// Non-override public methods
    public void deleteElement(int element) throws DeleteRootException {
        if(root.getValue() == element){
            throw new DeleteRootException();
        }
        node = root;
        boolean removed = false;
        while (!removed && (node.getLeftChild() != null || node.getRightChild() != null)){
            if(node.getLeftChild() != null && node.getLeftChild().getValue() == element){
                removeNode("left");
                size--;
                removed = true;
            } else if (node.getRightChild() != null && node.getRightChild().getValue() == element){
                removeNode("right");
                size--;
                removed = true;
            } else if(element < node.getValue()){
                node = node.getLeftChild();
            } else {
                node = node.getRightChild();
            }
        }
    }

// Helper Methods
    private void fillArrayAsc(Node fillingNode, int[] arrayToFill){
        if(fillingNode.getLeftChild() != null){
            fillArrayAsc(fillingNode.getLeftChild(), arrayToFill);
        }
        arrayToFill[index++] = fillingNode.getValue();
        if(fillingNode.getRightChild() != null){
            fillArrayAsc(fillingNode.getRightChild(), arrayToFill);
        }
    }

    private void fillArrayDesc(Node fillingNode, int[] arrayToFill) {
        if (fillingNode.getRightChild() != null) {
            fillArrayDesc(fillingNode.getRightChild(), arrayToFill);
        }
        arrayToFill[index++] = fillingNode.getValue();
        if (fillingNode.getLeftChild() != null) {
            fillArrayDesc(fillingNode.getLeftChild(), arrayToFill);
        }
    }

    private void removeNode(String removeSide){
        Node nodeToRemove;
        if (removeSide.equals("left")){
            nodeToRemove = node.getLeftChild();
            if (nodeToRemove.getLeftChild() != null) {
                Node nodeRightChild = nodeToRemove.getRightChild();
                node.setLeftChild(nodeToRemove.getLeftChild());
                refillRightChild(node.getLeftChild(), nodeRightChild);
            } else if (nodeToRemove.getRightChild() != null){
                node.setLeftChild(nodeToRemove.getRightChild());
            } else {
                node.setLeftChild(null);
            }
        } else if (removeSide.equals("right")){
            nodeToRemove = node.getRightChild();
            if (nodeToRemove.getLeftChild() != null) {
                Node nodeRightChild = nodeToRemove.getRightChild();
                node.setRightChild(nodeToRemove.getLeftChild());
                refillRightChild(node.getRightChild(), nodeRightChild);
            } else if (nodeToRemove.getRightChild() != null){
                node.setRightChild(nodeToRemove.getRightChild());
            } else {
                node.setRightChild(null);
            }
        }
    }

    private void refillRightChild(Node nodeToFill,Node nodeRightChild){
        if (nodeToFill.getRightChild() != null){
            refillRightChild(nodeToFill.getRightChild(), nodeRightChild);
        } else {
            nodeToFill.setRightChild(nodeRightChild);
        }
    }
}

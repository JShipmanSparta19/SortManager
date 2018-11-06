package com.sparta.jas.exceptions;

public class ChildNotFoundException extends Exception {
    private int element;
    private String childType;

    public ChildNotFoundException(int element){
        this.element = element;
    }

    public ChildNotFoundException(int element, String childType){
        this.element = element;
        this.childType = childType;
    }

    public String getMessage(){
        String message;
        if (childType == null){
            message = "Child Not Found Exception:\nElement " + element + " does not exist.";
        } else {
            message = "Child Not Found Exception:\nElement " + element + " does not have a " + childType + "Child.";
        }
        return message;
    }
}

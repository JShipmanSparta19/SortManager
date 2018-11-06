package com.sparta.jas.exceptions;

public class FactoryException extends Exception {

    private String exceptionName;

    public FactoryException(String exceptionName){
        this.exceptionName = exceptionName;
    }

    @Override
    public String getMessage() {
        String message;
        switch (exceptionName) {
            case "ClassNotFoundException":
                message = exceptionName + "\n  * Please check the factory class path and re-run the Sort Manager";
                break;
            case "FileNotFoundException":
                message = exceptionName + "\n  * Please check the 'factory.properties' file path and re-run the Sort Manager";
                break;
            default:
                message = exceptionName + "\n  * Please contact the system administrator";
        }
        return message;
    }
}

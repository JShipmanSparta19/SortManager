package com.sparta.jas.exceptions;

public class DeleteRootException extends Exception {

    public String getMessage(){
        return  "Delete Root Exception:\nPlease do not attempt to delete the Root element";
    }
}

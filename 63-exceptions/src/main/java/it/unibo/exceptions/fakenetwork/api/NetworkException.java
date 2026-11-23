package it.unibo.exceptions.fakenetwork.api;

import java.io.IOException;
import java.util.Objects;

public class NetworkException extends IOException{

    private static final long serialVersionUID = 1L;
    
    public NetworkException(){
        super("Network error: no response");
    }

    public NetworkException(String message){
        Objects.requireNonNull(message);
        super(("Network error while sending message: " + message));
    }

}
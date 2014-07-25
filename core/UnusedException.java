package core;

import java.lang.Exception;

//
// Custom Exception to handle unimplemented interface methods
//
// @author Alex Petersen <theoperatore@gmail.com>
//
public class UnusedException extends Exception {
    
    //constructor
    public UnusedException(String message) {
        super(message);
    }

}
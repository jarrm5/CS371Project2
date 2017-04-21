/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author jarrm5
 */
public class AuthenticationException extends Exception{
    public AuthenticationException() { 
        super(); 
    }
    public AuthenticationException(String message) { 
        super(message); 
    }
}

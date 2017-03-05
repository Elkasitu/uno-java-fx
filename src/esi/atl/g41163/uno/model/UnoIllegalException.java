/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esi.atl.g41163.uno.model;

/**
 * Exception for the Uno game
 * @author Adrian Torres
 * @version 1.0
 * @since 2017-03-05
 */
public class UnoIllegalException extends Exception
{
    /**
     * Thrown when a play is illegal
     * @param msg Error message
     */
    public UnoIllegalException(String msg)
    {
        super(msg);
    }
}

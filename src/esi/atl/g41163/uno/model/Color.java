/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esi.atl.g41163.uno.model;

/**
 * A enum representing all the possible colors of a UNO card
 * @author Adrian Torres
 * @version 1.0
 * @since 2017-03-01
 */
public enum Color
{
    BLUE("Blue", 'B'),
    RED("Red", 'R'),
    YELLOW("Yellow", 'Y'),
    GREEN("Green", 'G');
    
    private final String repr;
    private final char conOut;
    
    /**
     * Constructor for the Color enum
     * @param repr A string representation of the color
     * @param conOut A character representing the console output representation
     */
    Color(String repr, char conOut)
    {
        this.repr = repr;
        this.conOut = conOut;
    }
    
    /**
     * Gets a human-readable representation of the color
     * @return A string that represents the color of a card
     */
    public String getStrRepr()
    {
        return this.repr;
    }
    
    /**
     * Gets the console output character representing the color
     * @return A char representing the console output that represents the color
     */
    public char getConOut()
    {
        return this.conOut;
    }
}

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
    NONE(""),
    BLUE("Blue"),
    RED("Red"),
    YELLOW("Yellow"),
    GREEN("Green");
    
    private final String repr;
    
    /**
     * Constructor for the Color enum
     * @param repr A string representation of the color
     */
    Color(String repr)
    {
        this.repr = repr;
    }
    
    /**
     * Gets a human-readable representation of the color
     * @return A string that represents the color of a card
     */
    public String getStrRepr()
    {
        return this.repr;
    }
}

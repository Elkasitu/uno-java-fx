/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esi.atl.g41163.uno.model;

/**
 * This enum represents all the possible values of a UNO Card
 * @author Adrian Torres
 * @version 1.0
 * @since 2017-03-01
 */
public enum Value
{
    ONE("One"),
    TWO("Two"),
    THREE("Three"),
    FOUR("Four"),
    FIVE("Five"),
    SIX("Six"),
    SEVEN("Seven"),
    EIGHT("Eight"),
    NINE("Nine"),
    WILD_4("Wild Draw Four"),
    WILD("Wild Card"),
    D_TWO("Draw Two"),
    SKIP("Skip"),
    REVERSE("Reverse");
    
    private final String repr;
    
    /**
     * Constructor for this enum
     * @param repr String representation of the enum value
     */
    Value(String repr)
    {
        this.repr = repr;
    }
    
    /**
     * Gets the human-readable representation of this value
     * @return A human-readable string representing the value
     */
    public String getStrRepr()
    {
        return this.repr;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esi.atl.g41163.uno.model;

import java.util.Objects;

/**
 * This class represents a Card in the game of UNO
 * @author Adrian Torres
 * @version 1.0
 * @since 2017-03-01
 */
public class Card
{
    private final Color color;
    private final int value;
    
    /**
     * Constructor for the Card class
     * @param color Color of the card (Color enum)
     * @param value Integer representing the value of the card
     */
    Card(Color color, int value)
    {
        this.color = color;
        this.value = value;
    }
    
    /**
     * Gets the color of the card object
     * @return Color value of the card
     */
    public Color getColor()
    {
        return this.color;
    }
    
    /**
     * Gets the value of the card object
     * @return Value value of the card
     */
    public int getValue()
    {
        return this.value;
    }
    
    /**
     * Gets a human-readable representation of the Card object
     * @return A string representing the card in human-readable form
     */
    @Override
    public String toString()
    {
        StringBuilder buf = new StringBuilder();
        
        buf.append(this.color.getStrRepr());
        buf.append(" ");
        buf.append(String.valueOf(this.value));
        
        return buf.toString();
    }

    /**
     * Creates a identifier for this object based on its attributes
     * @return An integer that represents this object
     */
    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.color);
        hash = 67 * hash + this.value;
        return hash;
    }

    /**
     * Checks if Object obj is equal to this instance of Card
     * @param obj The object to check
     * @return True if both objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Card other = (Card) obj;
        if (this.value != other.value)
        {
            return false;
        }
        if (this.color == other.color)
        {
        }
        else
        {
            return false;
        }
        return true;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esi.atl.g41163.uno.model;

/**
 * This class represents a Card in the game of UNO
 * @author Adrian Torres
 * @version 1.0
 * @since 2017-03-01
 */
public class Card
{
    private final Color color;
    private final Value value;
    
    /**
     * Constructor for the Card class
     * @param color Color of the card (Color enum)
     * @param value Value of the card (Value enum)
     */
    public Card(Color color, Value value)
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
    public Value getValue()
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
        buf.append(this.value.getStrRepr());
        
        return buf.toString();
    }
}

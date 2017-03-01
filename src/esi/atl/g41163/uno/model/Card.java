/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esi.atl.g41163.uno.model;

/**
 *
 * @author G41163
 */
public class Card
{
    private final Color color;
    private final Value value;
    
    public Card(Color color, Value value)
    {
        this.color = color;
        this.value = value;
    }
    
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

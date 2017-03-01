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
    
    Value(String repr)
    {
        this.repr = repr;
    }
    
    public String getStrRepr()
    {
        return this.repr;
    }
}

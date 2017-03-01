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
public enum Color
{
    NONE(""),
    BLUE("Blue"),
    RED("Red"),
    YELLOW("Yellow"),
    GREEN("Green");
    
    private final String repr;
    
    Color(String repr)
    {
        this.repr = repr;
    }
    
    public String getStrRepr()
    {
        return this.repr;
    }
}

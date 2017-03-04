/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esi.atl.g41163.uno.model;

/**
 * A class representing the discarded cards pile in a game of UNO
 * @author Adrian Torres
 * @version 1.0
 * @since 2017-03-04
 */
public class Discarded extends CardCollection
{
    Discarded()
    {
        super();
    }
    
    /**
     * Gets the card at the top of the Discarded stack
     * @return The card object at position 0
     */
    Card getCard()
    {
        return getCard(0);
    }
}

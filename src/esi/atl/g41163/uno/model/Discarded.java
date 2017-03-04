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
    /**
     * This constructor calls CardCollection's constructor to instantiate itself
     */
    Discarded()
    {
        super();
    }
    
    /**
     * Gets the card at the top of the Discarded stack
     * @return The card object at the last position
     */
    Card getCard()
    {
        return this.cardList.get(this.cardList.size() - 1);
    }
    
    void flush()
    {
        for (Card card : this.cardList)
        {
            this.cardList.remove(card);
        }
    }
}

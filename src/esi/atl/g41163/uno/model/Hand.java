/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esi.atl.g41163.uno.model;

import java.util.List;

/**
 * A class representing the player's hand
 * @author Adrian Torres
 * @version 1.0
 * @since 2017-03-04
 */
public class Hand extends CardCollection
{
    /**
     * This constructor calls CardCollection's constructor to instantiate itself
     */
    Hand()
    {
        super();
    }
    
    /**
     * Copy constructor for the Hand class
     * @param hand Hand object to be copied
     */
    Hand(Hand hand)
    {
        super();
        this.cardList = hand.cardList;
    }
    
    /**
     * Gets the ArrayList object
     * @return ArrayList object containing this hand's cards
     */
    public List<Card> getList()
    {
        return this.cardList;
    }
    
    /**
     * Gets a string representing the Hand contents
     * @return A string representing the hand contents
     */
    @Override
    public String toString()
    {
        StringBuilder buf = new StringBuilder();
        
        for (Card card : this.cardList)
        {
            int i = this.cardList.indexOf(card);
            
            buf.append(String.valueOf(i + 1));
            buf.append(". ");
            buf.append(card.toString());
            buf.append("\n");
        }
        
        return buf.toString();
    }
}

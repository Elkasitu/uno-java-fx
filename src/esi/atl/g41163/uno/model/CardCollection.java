/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esi.atl.g41163.uno.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class representing a collection of cards
 * @author Adrian Torres
 * @version 1.0
 * @since 2017-03-04
 */
public abstract class CardCollection
{
    /**
     * List where the cards will be stored
     */
    protected List<Card> cardList;
    
    /**
     * Constructor for the abstract class, instantiates the list of cards
     */
    protected CardCollection()
    {
        this.cardList = new ArrayList();
    }
    
    /**
     * Counts the amount of cards left in the CardCollection
     * @return An int representing the amount of cards left in the collection
     */
    protected int getCount()
    {
        return this.cardList.size();
    }
    
    /**
     * Tells whether the collection is empty or not
     * @return True if the collection is empty, false otherwise
     */
    protected boolean isEmpty()
    {
        return getCount() == 0;
    }
    
    /**
     * Adds card to this object's collection of cards
     * @param card The Card object to be added
     */
    protected void addCard(Card card)
    {
        this.cardList.add(card);
    }
    
    /**
     * Removes the card passed in as an argument
     * @param card The card object to be deleted from the list
     */
    protected void removeCard(Card card)
    {
        this.cardList.remove(card);
    }
    
    /**
     * Gets the card at index i
     * @return The Card object and removes it from the collection
     * @param i Index of the card to be fetched
     */
    protected Card getCard(int i)
    {
        Card card;
        try
        {
            card = this.cardList.get(i);
            removeCard(card);
        }
        catch (Exception e)
        {
            // This works as a "skip turn"
            card = null;
        }
        
        return card;
    }
    
    /**
     * Clears the cardList List
     */
    protected void flush()
    {
        this.cardList = new ArrayList();
    }
}

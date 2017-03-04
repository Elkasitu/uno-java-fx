/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esi.atl.g41163.uno.model;

import java.util.Collections;
import java.util.Random;

/**
 * An abstract class that represents a Deck of UNO cards
 * @author Adrian Torres
 * @version 1.0
 * @since 2017-03-04
 */
public class Deck extends CardCollection
{
    /**
     * This class' constructor calls to its superclass' constructor
     */
    Deck()
    {
        super();
    }
    
    /**
     * Generates all 76 cards found in a standard UNO deck
     */
    void generateDeck()
    {
        int k;
        
        // Will create 19 cards per color
        for (Color color : Color.values())
        {
            for (int i = 0; i < 10; i++)
            {
                // Only one zero per color, 2 of every other value
                if (i == 0)
                    k = 1;
                else
                    k = 2;
                
                for (int j = 0; j < k; j++)
                {
                    addCard(new Card(color, i));
                }
            }
        }
    }
    
    /**
     * Gets the card at the top of the deck
     * @return The card object at position 0
     */
    Card getCard()
    {
        return getCard(0);
    }
    
    /**
     * Shuffles the Deck object (usually done after a "refill" only)
     */
    private void shuffle()
    {
        long seed = System.nanoTime();
        Collections.shuffle(cardList, new Random(seed));
    }
    
    /**
     * Refills the deck with the given stack of discarded cards
     * @param stack A Discarded object
     */
    void refill(Discarded stack)
    {
        for (int i = 0; i < stack.getCount(); i++)
        {
            this.addCard(stack.getCard());
        }
        
        // Shuffle the deck otherwise we'll get a perfect chain of cards
        shuffle();
    }
}

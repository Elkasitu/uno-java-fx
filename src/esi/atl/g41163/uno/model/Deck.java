/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esi.atl.g41163.uno.model;

import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Adrian Torres
 */
public class Deck extends CardCollection
{
    Deck()
    {
        super();
    }
    
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
     * Gets the card at the top of the deck (index 0)
     * @return The Card object and removes it from the collection
     */
    Card getCard()
    {
        Card card = this.cardList.get(0);
        removeCard(card);
        return card;
    }
    
    /**
     * Shuffles the Deck object (usually done after a "refill" only)
     */
    private void shuffle()
    {
        long seed = System.nanoTime();
        Collections.shuffle(cardList, new Random(seed));
    }
    
    //TODO: Complete after building the Stack class
    void refill(){}
}

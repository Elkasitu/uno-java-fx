/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esi.atl.g41163.uno.model;

import java.util.ArrayList;


/**
 * This class represents a Player in the game of UNO
 * @author Adrian Torres
 * @version 1.0
 * @since 2017-03-01
 */
public class Player
{
    private final ArrayList<Card> hand;
    private final String name;
    private int score;
    private boolean hasUno;
    
    /**
     * Constructor for the Player class
     * @param name Name of the player
     */
    public Player(String name)
    {
        this.name = name;
        this.score = 0;
        this.hand = new ArrayList();
        this.hasUno = false;
    }
    
    /**
     * Adds n to the Player's score
     * @param n Amount to be added to the player's score
     */
    public void addScore(int n)
    {
        this.score += n;
    }
    
    /**
     * Gets the player's score
     * @return An integer representing the player's score
     */
    public int getScore()
    {
        return this.score;
    }
    
    /**
     * Gets the player's name
     * @return A string representing the player's name
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * Adds the passed-in card to the player's hand
     * @param card Card to be added to the player's hand
     */
    public void drawCard(Card card)
    {
        this.hand.add(card);
    }
    
    /**
     * Gets the card i (from left to right) from the player's hand
     * @param i Index of the card in the player's hand
     * @return The card object at position i in the player's hand ArrayList
     */
    public Card getCard(int i)
    {
        Card card = this.hand.get(i);
        this.hand.remove(card);
        return card;
    }
    
    /**
     * If the player "yells" uno and he has only one card in his hand, set hasUno
     * to true (required for winning)
     * @return True if player has uno, false otherwise
     */
    public boolean yellUno()
    {
        if (this.hand.size() == 1)
            this.hasUno = true;
        
        return this.hasUno;
    }
}
